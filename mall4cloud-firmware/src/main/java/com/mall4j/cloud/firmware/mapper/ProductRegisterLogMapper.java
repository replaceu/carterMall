package com.mall4j.cloud.firmware.mapper;

import com.mall4j.cloud.firmware.model.ProductRegisterLog;

public interface ProductRegisterLogMapper {
    ProductRegisterLog verifyUniqueLog(String email, String sn);

    void insertSelective(ProductRegisterLog newRegisterLog);

    void updateSelective(ProductRegisterLog productRegisterLog);
}
