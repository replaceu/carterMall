package com.mall4j.cloud.integral.service.impl;

import com.mall4j.cloud.api.integral.constant.IntegralPointLogConstants;
import com.mall4j.cloud.api.order.bo.EsOrderBO;
import com.mall4j.cloud.api.order.feign.OrderFeignClient;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.integral.mapper.IntegralPointLogMapper;
import com.mall4j.cloud.integral.mapper.IntegralUserPointMapper;
import com.mall4j.cloud.integral.model.IntegralPointLog;
import com.mall4j.cloud.integral.model.IntegralUserPoint;
import com.mall4j.cloud.integral.service.IntegralPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class IntegralPointServiceImpl implements IntegralPointService {
	@Autowired
	IntegralUserPointMapper integralUserPointMapper;
	@Autowired
	IntegralPointLogMapper	integralPointLogMapper;
	@Autowired
	OrderFeignClient		orderFeignClient;

	@Override
	public void updateUserIntegralPoint(List<Long> orderIdList) {

		for (Long orderId : orderIdList) {
			ServerResponseEntity<EsOrderBO> esOrderBo = orderFeignClient.getEsOrder(orderId);
			if (esOrderBo.isSuccess()) {
				EsOrderBO elasticSearchOrderBo = esOrderBo.getData();
				Long orderTotal = elasticSearchOrderBo.getTotal();
				List<IntegralUserPoint> pointList = integralUserPointMapper.selectByUserId(esOrderBo.getData().getUserId().toString());
				IntegralPointLog integralPointLog = new IntegralPointLog();
				integralPointLog.setCreateDate(new Date());
				integralPointLog.setId(UUID.randomUUID().toString());
				integralPointLog.setBeforeVal(pointList.get(0).getIntegralPoint());
				integralPointLog.setChangeVal(orderTotal.toString());
				integralPointLog.setCurrentVal(pointList.get(0).getIntegralPoint()+orderTotal);
				integralPointLog.setRefType(IntegralPointLogConstants.RefType.a_order_complete);
				integralPointLog.setLogDesc(IntegralPointLogConstants.RefTypeLogTitleEnum.a_order_complete.getLogTitle());
				integralPointLog.setRefVal(elasticSearchOrderBo.getOrderId().toString());
				integralPointLog.setUserId(elasticSearchOrderBo.getUserId().toString());
				integralPointLogMapper.insertSelective(integralPointLog);
				IntegralUserPoint userPoint = new IntegralUserPoint();
				userPoint.setUserId(elasticSearchOrderBo.getUserId().toString());
				userPoint.setIntegralPoint(integralPointLog.getCurrentVal());
				userPoint.setId(UUID.randomUUID().toString());
				userPoint.setCreateDate(new Date());
				userPoint.setVersion(pointList.get(0).getVersion());
				integralUserPointMapper.updateByPrimaryKeySelective(userPoint);
			}

		}
	}
}
