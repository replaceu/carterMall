package com.mall4j.cloud.express.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.mall4j.cloud.api.order.bo.ExpressOrderItemBO;
import com.mall4j.cloud.api.order.bo.OrderAddressBo;
import com.mall4j.cloud.api.order.bo.OrderExpressBO;
import com.mall4j.cloud.api.order.feign.OrderAddrFeignClient;
import com.mall4j.cloud.api.order.feign.OrderFeignClient;
import com.mall4j.cloud.api.order.feign.OrderItemFeignClient;
import com.mall4j.cloud.common.exception.Mall4cloudException;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.common.rocketmq.config.RocketMqConstant;
import com.mall4j.cloud.express.dto.ExpressInfoDTO;
import com.mall4j.cloud.express.dto.ExpressRspDTO;
import com.mall4j.cloud.express.dto.ExpressTrackDTO;
import com.mall4j.cloud.express.mapper.ExpressTrackMapper;
import com.mall4j.cloud.express.model.ExpressTrack;
import com.mall4j.cloud.express.service.ExpressService;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import java.util.*;

@Service
public class ExpressServiceImpl implements ExpressService {
	@Value("${express.host}")
	private String			host;
	@Value("${express.path}")
	private String			path;
	@Value("${express.appcode}")
	private String			appcode;
	private String			method	= "GET";
	Map<String, String>		headers	= new HashMap<>();
	@Autowired
	ExpressTrackMapper		expressTrackMapper;
	@Autowired
	OrderItemFeignClient	orderItemFeignClient;
	@Autowired
	OrderAddrFeignClient	orderAddrFeignClient;
	@Autowired
	OrderFeignClient		orderFeignClient;
	@Autowired
	ExpressService			expressService;
	@Autowired
	RocketMQTemplate		integralPointUpdateTemplate;

	Logger logger = LoggerFactory.getLogger(ExpressServiceImpl.class);

	/**
	 * ?????????????????????????????????
	 *
	 * @param expressTrackDTO
	 * @return
	 */
	@Override
	public ExpressInfoDTO getExpressInfoByCodeAndNo(ExpressTrackDTO expressTrackDTO) {
		ExpressInfoDTO expressInfo = new ExpressInfoDTO();
		if (expressTrackDTO.getExpressCode() == null) { throw new Mall4cloudException("??????????????????????????????"); }
		ExpressTrack expressTrack = new ExpressTrack();
		expressTrack.setExpressCode(expressTrackDTO.getExpressCode());
		expressTrack.setExpressNo(expressTrack.getExpressNo());
		List<ExpressTrack> expressTrackList = expressTrackMapper.selectBySelective(expressTrack);
		String id = null;
		Gson gson = new Gson();
		if (!CollectionUtil.isEmpty(expressTrackList)) {
			ExpressTrack mallExpressTrack = expressTrackList.get(0);
			id = mallExpressTrack.getId();
			long expired = 1000 * 60 * 30;
			Boolean inThirtyMinutes = System.currentTimeMillis() - mallExpressTrack.getUpdateDate().getTime() < expired;
			//??????????????????????????? ?????? ??????????????? ??????????????????
			if (mallExpressTrack.getDeliveryStatus().equals("3") || inThirtyMinutes) {
				String track = mallExpressTrack.getExpressTrack();
				ExpressInfoDTO result = gson.fromJson(track, ExpressInfoDTO.class);
				return result;
			}
		}

		String searchExpressNo = expressTrackDTO.getExpressNo();
		if (expressTrackDTO.getExpressCode().equals("SFEXPRESS")) {
			//todo:??????Feign????????????????????????????????????
			try {
				ServerResponseEntity<List<ExpressOrderItemBO>> expressInfoBo = orderItemFeignClient.getOrderItems(expressTrackDTO.getExpressNo(), expressTrackDTO.getExpressCode());
				if (expressInfoBo.isSuccess()) {
					Long orderId = expressInfoBo.getData().get(0).getOrderId();
					List<Long> orderIdList = Arrays.asList(orderId);
					ServerResponseEntity<OrderAddressBo> orderAddrList = orderAddrFeignClient.getOrderExpressByOrderIdList(orderIdList);
					if (orderAddrList.isSuccess()) {
						searchExpressNo = expressTrackDTO.getExpressNo() + ":" + orderAddrList.getData().getMobile().substring(orderAddrList.getData().getMobile().length() - 4, orderAddrList.getData().getMobile().length());
					}
				}

			} catch (Exception e) {
				throw new Mall4cloudException("???????????????????????????");
			}

		}
		HttpBrowser browser = new HttpBrowser();
		String param = "?type=" + expressTrackDTO.getExpressNo() + "&no=" + searchExpressNo;

		HttpRequest request = HttpRequest.get(host + path + param);
		request.header("Authorization", "APPCODE " + appcode);
		request.header("Content-type", "application/x-www-form-urlencoded");

		String expressJSON = null;
		try {
			logger.info(request.toString());
			HttpResponse res = browser.sendRequest(request);
			expressJSON = new String(res.bodyBytes(), "UTF-8");
			logger.info("CALL ALI EXPRESS API response ------->>> body :" + expressJSON + "  statusCode : " + res.statusCode());
			//?????????: 200 ?????????400 URL?????????401 appCode????????? 403 ??????????????? 500 API????????????
			//??????response???body

			ExpressRspDTO expressResponse = gson.fromJson(expressJSON, ExpressRspDTO.class);
			if (expressResponse.getStatus().equals("0")) {
				expressInfo = expressResponse.getResult();
				ExpressTrack mallExpressTrack = new ExpressTrack();
				mallExpressTrack.setDeliveryStatus(expressInfo.getDeliverystatus());
				mallExpressTrack.setExpressTrack(gson.toJson(expressInfo));
				mallExpressTrack.setUpdateDate(new Date());
				if (StringUtils.isEmpty(id)) {
					mallExpressTrack.setExpressNo(expressTrackDTO.getExpressNo());
					mallExpressTrack.setExpressCode(expressTrackDTO.getExpressCode());
					mallExpressTrack.setId(UUID.randomUUID().toString());
					mallExpressTrack.setCreateDate(new Date());
					expressTrackMapper.insertSelective(mallExpressTrack);
				} else {
					mallExpressTrack.setId(id);
					expressTrackMapper.updateByPrimaryKeySelective(mallExpressTrack);
				}
				return expressInfo;
			} else {
				throw new Mall4cloudException("???????????????????????????");
			}
		} catch (Exception e) {
			logger.error(e.getClass().getSimpleName(), e.getMessage());
		}
		return expressInfo;
	}

	@Override
	public void doExpressOsSync() {
		//todo???????????????????????????????????????????????????
		ServerResponseEntity<List<OrderExpressBO>> deliveredOrderList = orderFeignClient.getDeliveredOrder();
		if (!deliveredOrderList.isSuccess()) {
			return;
		} else {
			List<OrderExpressBO> deliveredOrderListData = deliveredOrderList.getData();

			List<Long> orderIdList = new ArrayList<>();
			for (OrderExpressBO deliveredOrder : deliveredOrderListData) {
				ExpressTrackDTO expressTrackDTO = new ExpressTrackDTO();
				expressTrackDTO.setExpressCode(deliveredOrder.getSyncOsExpress());
				expressTrackDTO.setExpressNo(deliveredOrder.getSyncOsExpressNo());
				ExpressInfoDTO expressInfo = expressService.getExpressInfoByCodeAndNo(expressTrackDTO);
				if (expressInfo != null) {
					String deliveryStatus = expressInfo.getDeliverystatus();
					String isSign = expressInfo.getIsSign();
					if (isSign.equals("1") && deliveryStatus.equals("3")) {
						//todo:?????????????????????????????????????????????????????????????????????????????????
						orderIdList.add(deliveredOrder.getOrderId());
					}
				}
			}

			try {
				//todo????????????????????????
				orderFeignClient.updateExpressOrder(orderIdList);
				integralPointUpdateTemplate.syncSend(RocketMqConstant.INTEGRAL_POINT_UPDATE_TOPIC, new GenericMessage<List<Long>>(orderIdList));
			} catch (Exception e) {
				throw new Mall4cloudException("????????????????????????");
			}
		}
	}
}
