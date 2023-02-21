package com.mall4j.cloud.firmware.service.impl;

import com.mall4j.cloud.api.auth.bo.UserInfoInTokenBO;
import com.mall4j.cloud.api.auth.feign.TokenFeignClient;
import com.mall4j.cloud.api.user.feign.UserFeignClient;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.firmware.constant.MsgConstants;
import com.mall4j.cloud.firmware.dto.FirmwareRegisterRequestDto;
import com.mall4j.cloud.firmware.service.FirmwareService;
import com.mall4j.cloud.firmware.vo.ResultResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirmwareServiceImpl implements FirmwareService {
    @Autowired
    TokenFeignClient tokenFeignClient;

    @Override
    public ResultResponseVO userFirmwareRegister(FirmwareRegisterRequestDto firmwareRegisterRequestDto) {
        ResultResponseVO retResponse = new ResultResponseVO();
        ServerResponseEntity<UserInfoInTokenBO> userInfoInTokenBOResponse = tokenFeignClient.checkToken(firmwareRegisterRequestDto.getToken());
        if (userInfoInTokenBOResponse.isSuccess()){
            UserInfoInTokenBO userInfoBO = userInfoInTokenBOResponse.getData();
            if (userInfoBO==null){
                retResponse.setResult(false);
                retResponse.setCode("84");
                retResponse.setReturnMsg(MsgConstants.missingToken());
                return retResponse;
            }

            //sn先进到deviceInfo找productLabel


        }
        return null;
    }
}
