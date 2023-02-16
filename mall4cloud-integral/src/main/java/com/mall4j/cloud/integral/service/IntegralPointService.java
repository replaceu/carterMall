package com.mall4j.cloud.integral.service;

import java.util.List;

public interface IntegralPointService {

    /**
     * 更新用户积分
     * @param orderIdList
     */
    void updateUserIntegralPoint(List<Long> orderIdList);
}
