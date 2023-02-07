package com.mall4j.cloud.express.mapper;

import com.mall4j.cloud.express.model.ExpressTrack;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpressTrackMapper {
    List<ExpressTrack> selectBySelective(ExpressTrack expressTrack);

    void insertSelective(ExpressTrack expressTrack);

    int updateByPrimaryKeySelective(ExpressTrack expressTrack);
}
