package com.mall4j.cloud.firmware.mapper;

import com.mall4j.cloud.firmware.model.ProductDeviceInfo;

import java.util.List;

public interface ProductDeviceInfoMapper {
    List<ProductDeviceInfo> selectDeviceBySn(String sn);
}
