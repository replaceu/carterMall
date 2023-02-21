package com.mall4j.cloud.firmware.controller.app;

import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.firmware.dto.FirmwareRegisterRequestDto;
import com.mall4j.cloud.firmware.service.FirmwareService;
import com.mall4j.cloud.firmware.vo.ResultResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/p/firmware")
public class FirmwareController {
    @Autowired
    private FirmwareService firmwareService;

    @PostMapping("/firmwareRegister")
    @ApiOperation(value = "用户注册产品设备",notes = "依据参数来进行产品注册")
    public ServerResponseEntity<ResultResponseVO> userFirmwareRegister(@RequestBody FirmwareRegisterRequestDto firmwareRegisterRequestDto){
        ResultResponseVO result = firmwareService.userFirmwareRegister(firmwareRegisterRequestDto);

        return ServerResponseEntity.success(result);

    }




}
