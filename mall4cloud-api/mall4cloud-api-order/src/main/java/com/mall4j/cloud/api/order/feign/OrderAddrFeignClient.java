package com.mall4j.cloud.api.order.feign;

import com.mall4j.cloud.api.order.bo.ExpressOrderItemBO;
import com.mall4j.cloud.api.order.bo.OrderAddressBo;
import com.mall4j.cloud.common.feign.FeignInsideAuthConfig;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface OrderAddrFeignClient {
    @GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX+"/insider/getOrderExpress")
    ServerResponseEntity<OrderAddressBo> getOrderExpressByOrderIdList(List<Long> orderIds);
}
