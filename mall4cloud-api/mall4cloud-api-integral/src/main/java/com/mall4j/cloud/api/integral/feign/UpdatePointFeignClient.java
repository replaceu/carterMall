package com.mall4j.cloud.api.integral.feign;

import com.mall4j.cloud.common.feign.FeignInsideAuthConfig;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface UpdatePointFeignClient {
    @GetMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX+"/insider/updateUserPoint")
    ServerResponseEntity<Void> updateUserPoint(String userId,String point,String refType);
}
