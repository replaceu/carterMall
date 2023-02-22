package com.mall4j.cloud.firmware.async;

import com.mall4j.cloud.firmware.model.ProductRegisterLog;

public interface AsyncFirmwareService {

    void asyncOsRegister(ProductRegisterLog productRegisterLog, Long userId, String email, String sn);
}
