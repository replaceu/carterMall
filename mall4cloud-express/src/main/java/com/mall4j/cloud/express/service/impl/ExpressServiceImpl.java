package com.mall4j.cloud.express.service.impl;

import com.mall4j.cloud.common.exception.Mall4cloudException;
import com.mall4j.cloud.express.dto.ExpressInfoDTO;
import com.mall4j.cloud.express.dto.ExpressRspDTO;
import com.mall4j.cloud.express.dto.ExpressTrackDTO;
import com.mall4j.cloud.express.service.ExpressService;
import org.springframework.stereotype.Service;

@Service
public class ExpressServiceImpl implements ExpressService {
    @Override
    public ExpressInfoDTO getExpressInfoByCodeAndNo(ExpressTrackDTO expressTrack) {
        if (expressTrack.getExpressCode()==null){
            throw new Mall4cloudException("获取快递公司名称失败");
        }

        return null;
    }
}
