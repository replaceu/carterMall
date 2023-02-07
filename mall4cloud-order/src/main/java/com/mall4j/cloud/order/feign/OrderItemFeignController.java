package com.mall4j.cloud.order.feign;

import com.mall4j.cloud.api.order.bo.ExpressOrderItemBO;
import com.mall4j.cloud.api.order.feign.OrderItemFeignClient;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.order.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderItemFeignController implements OrderItemFeignClient {

    @Autowired
    OrderItemService orderItemService;
    /**
     * 通过快递查询订单项的信息
     * @param expressNo
     * @param expressCode
     * @return
     */
    @Override
    public ServerResponseEntity<List<ExpressOrderItemBO>> getOrderItems(String expressNo, String expressCode) {
        List<ExpressOrderItemBO> expressOrderItemBoList = orderItemService.getOrderItemsByExpress(expressNo,expressCode);
        return ServerResponseEntity.success(expressOrderItemBoList);
    }
}
