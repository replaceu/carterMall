package com.mall4j.cloud.firmware.service;

import com.mall4j.cloud.firmware.dto.FirmwareRegisterRequestDto;
import com.mall4j.cloud.firmware.vo.ResultResponseVO;

public interface FirmwareService {
    ResultResponseVO userFirmwareRegister(FirmwareRegisterRequestDto firmwareRegisterRequestDto);
}
