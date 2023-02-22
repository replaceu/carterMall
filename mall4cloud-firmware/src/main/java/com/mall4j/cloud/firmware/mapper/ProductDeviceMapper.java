package com.mall4j.cloud.firmware.mapper;

import com.mall4j.cloud.firmware.model.ProductDevice;

public interface ProductDeviceMapper {
    ProductDevice getProductDeviceByProductLabel(String productLable);
}
