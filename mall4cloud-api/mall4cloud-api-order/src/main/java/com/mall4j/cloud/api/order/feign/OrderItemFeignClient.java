package com.mall4j.cloud.api.order.feign;

import com.mall4j.cloud.api.order.bo.ExpressOrderItemBO;
import com.mall4j.cloud.common.feign.FeignInsideAuthConfig;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface OrderItemFeignClient {

    /**
     * 通过快递查询订单项的信息
     * @param expressNo
     * @param expressCode
     * @return
     */
    @GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX+"/insider/getOrderItems")
    ServerResponseEntity<List<ExpressOrderItemBO>> getOrderItems(String expressNo, String expressCode);
}
