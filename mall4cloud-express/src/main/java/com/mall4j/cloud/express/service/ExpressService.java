package com.mall4j.cloud.express.service;

import com.mall4j.cloud.express.dto.ExpressInfoDTO;
import com.mall4j.cloud.express.dto.ExpressRspDTO;
import com.mall4j.cloud.express.dto.ExpressTrackDTO;

public interface ExpressService {

    /**
     * 查询物流信息
     * @param expressTrack
     * @return
     */
    ExpressInfoDTO getExpressInfoByCodeAndNo(ExpressTrackDTO expressTrack);

    /**
     * 同步快递签收的信息到OS系统
     */
    void doExpressOsSync();
}
