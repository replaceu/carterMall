package com.mall4j.cloud.firmware.async.impl;

import com.alibaba.nacos.shaded.com.google.gson.JsonObject;
import com.alibaba.nacos.shaded.com.google.gson.JsonParser;
import com.mall4j.cloud.firmware.async.AsyncFirmwareService;
import com.mall4j.cloud.firmware.mapper.ProductRegisterLogMapper;
import com.mall4j.cloud.firmware.model.ProductRegisterLog;
import com.mall4j.cloud.firmware.service.ProductApiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncFirmwareServiceImpl implements AsyncFirmwareService {
    @Autowired
    ProductApiService productApiService;
    @Autowired
    ProductRegisterLogMapper productRegisterLogMapper;

    @Override
    @Async("asyncServiceExecutor")
    public void asyncOsRegister(ProductRegisterLog productRegisterLog, Long userId, String email, String sn) {
        String registerReturn = productApiService.callFirmwareRegister(userId, email, sn);
        String[] registerReturnWithCode = null;
        if (!StringUtils.isBlank(registerReturn)) {
            registerReturnWithCode = registerReturn.split("HONG");
            registerReturn = registerReturnWithCode[0];
            JsonParser jsonParse = new JsonParser();
            JsonObject returnJson = (JsonObject) jsonParse.parse(registerReturn);
            if (null != returnJson.get("data")) {

                productRegisterLog.setSucceedOSRegistered(Boolean.TRUE);
                if (productRegisterLog.getIsOtaOpen() == null) {
                    productRegisterLog.setIsOtaOpen(0);
                }
                productRegisterLogMapper.updateSelective(productRegisterLog);
            }
        }
    }
}
