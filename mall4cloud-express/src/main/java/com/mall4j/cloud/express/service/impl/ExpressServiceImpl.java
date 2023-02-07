package com.mall4j.cloud.express.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.mall4j.cloud.api.order.bo.ExpressOrderItemBO;
import com.mall4j.cloud.api.order.feign.OrderItemFeignClient;
import com.mall4j.cloud.common.exception.Mall4cloudException;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.express.dto.ExpressInfoDTO;
import com.mall4j.cloud.express.dto.ExpressTrackDTO;
import com.mall4j.cloud.express.mapper.ExpressTrackMapper;
import com.mall4j.cloud.express.model.ExpressTrack;
import com.mall4j.cloud.express.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService {
    @Autowired
    ExpressTrackMapper expressTrackMapper;
    @Autowired
    OrderItemFeignClient orderItemFeignClient;

    /**
     * 查询用户货物的物流状态
     * @param expressTrackDTO
     * @return
     */
    @Override
    public ExpressInfoDTO getExpressInfoByCodeAndNo(ExpressTrackDTO expressTrackDTO) {
        ExpressInfoDTO expressInfo = new ExpressInfoDTO();
        if (expressTrackDTO.getExpressCode()==null){
            throw new Mall4cloudException("获取快递公司名称失败");
        }
        ExpressTrack expressTrack = new ExpressTrack();
        expressTrack.setExpressCode(expressTrackDTO.getExpressCode());
        expressTrack.setExpressNo(expressTrack.getExpressNo());
        List<ExpressTrack> expressTrackList = expressTrackMapper.selectBySelective(expressTrack);
        String id =null;
        Gson gson = new Gson();
        if (!CollectionUtil.isEmpty(expressTrackList)){
            ExpressTrack mallExpressTrack = expressTrackList.get(0);
            id= mallExpressTrack.getId();
            long expired = 1000*60*30;
            Boolean inThirtyMinutes = System.currentTimeMillis()-mallExpressTrack.getUpdateDate().getTime()<expired;
            //三十分钟内再次查询 或者 已签收状态 走数据库查询
            if (mallExpressTrack.getDeliveryStatus().equals("3")||inThirtyMinutes){
                String track = mallExpressTrack.getExpressTrack();
                ExpressInfoDTO result = gson.fromJson(track, ExpressInfoDTO.class);
                return result;
            }
        }

        String expressNo = expressTrackDTO.getExpressNo();
        if (expressTrackDTO.getExpressCode().equals("SFEXPRESS")){
            //todo:通过Feign来查询订单物流的相关信息
            ServerResponseEntity<List<ExpressOrderItemBO>> expressInfoBo = orderItemFeignClient.getOrderItems(expressNo,expressTrackDTO.getExpressCode());
            if (expressInfoBo.isSuccess()){

            }
        }


        return null;
    }
}
