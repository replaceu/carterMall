package com.mall4j.cloud.integral.listener;

import com.mall4j.cloud.common.rocketmq.config.RocketMqConstant;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mall4j.cloud.integral.service.IntegralPointService;

import java.util.List;

@Component
@RocketMQMessageListener(topic= RocketMqConstant.INTEGRAL_POINT_UPDATE_TOPIC,consumerGroup = RocketMqConstant.INTEGRAL_POINT_UPDATE_TOPIC)
public class IntegralPointUpdateConsumer implements RocketMQListener<List<Long>> {

    @Autowired
    IntegralPointService integralPointService;

    /**
     * 用户收到货之后给他增加积分
     */
    @Override
    public void onMessage(List<Long> orderIdList) {
        integralPointService.updateUserIntegralPoint(orderIdList);
    }
}
