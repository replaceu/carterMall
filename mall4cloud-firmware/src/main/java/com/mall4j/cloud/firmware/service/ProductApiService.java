package com.mall4j.cloud.firmware.service;

public interface ProductApiService {
    String callFirmwareRegister(Long userId, String email, String sn);
}
