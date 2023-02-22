package com.mall4j.cloud.integral.feign;

import com.mall4j.cloud.api.integral.feign.UpdatePointFeignClient;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.integral.service.IntegralPointService;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdatePointFeignController implements UpdatePointFeignClient {

    @Autowired
    IntegralPointService integralPointService;
    @Override
    public ServerResponseEntity<Void> updateUserPoint(String userId, String point,String refType) {

        integralPointService.updateUserIntegralPoint(userId,point,refType);
        return new ServerResponseEntity<>() ;
    }
}
