package com.mall4j.cloud.firmware.mapper;

import com.mall4j.cloud.firmware.model.ProductApiFailureLog;

public interface ProductApiFailureLogMapper {
    void insertSelective(ProductApiFailureLog apiFailureLog);
}
