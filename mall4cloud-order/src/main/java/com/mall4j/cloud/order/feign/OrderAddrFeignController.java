package com.mall4j.cloud.order.feign;

import com.mall4j.cloud.api.order.bo.OrderAddressBo;
import com.mall4j.cloud.api.order.feign.OrderAddrFeignClient;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.order.model.OrderAddr;
import com.mall4j.cloud.order.service.OrderAddrService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderAddrFeignController implements OrderAddrFeignClient {
    @Autowired
    OrderAddrService orderAddrService;

    public ServerResponseEntity<OrderAddressBo> getOrderExpressByOrderIdList(List<Long> orderIds) {
        OrderAddr orderAddr = orderAddrService.getByOrderAddrId(orderIds.get(0).longValue());
        OrderAddressBo retBo = new OrderAddressBo();
        BeanUtils.copyProperties(orderAddr,retBo);
        return ServerResponseEntity.success(retBo);
    }

}
