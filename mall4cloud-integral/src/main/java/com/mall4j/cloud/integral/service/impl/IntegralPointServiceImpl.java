package com.mall4j.cloud.integral.service.impl;

import com.mall4j.cloud.api.order.bo.EsOrderBO;
import com.mall4j.cloud.api.order.feign.OrderFeignClient;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.integral.mapper.IntegralPointLogMapper;
import com.mall4j.cloud.integral.mapper.IntegralUserPointMapper;
import com.mall4j.cloud.integral.service.IntegralPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
				EsOrderBO esOrder = esOrderBo.getData();

			}

		}
	}
}
