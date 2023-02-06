package com.mall4j.cloud.express.service;

import com.mall4j.cloud.express.dto.ExpressInfoDTO;
import com.mall4j.cloud.express.dto.ExpressRspDTO;
import com.mall4j.cloud.express.dto.ExpressTrackDTO;

public interface ExpressService {

    ExpressInfoDTO getExpressInfoByCodeAndNo(ExpressTrackDTO expressTrack);
}
