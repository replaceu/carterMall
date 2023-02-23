package com.mall4j.cloud.firmware.mapper;

import com.mall4j.cloud.firmware.model.ProductDevice;

import java.util.List;

public interface ProductDeviceMapper {
    ProductDevice getProductDeviceByProductLabel(String productLable);

    List<ProductDevice> selectAllProductDevice();

}
