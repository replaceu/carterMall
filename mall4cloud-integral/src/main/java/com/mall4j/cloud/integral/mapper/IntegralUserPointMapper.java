package com.mall4j.cloud.integral.mapper;

import com.mall4j.cloud.integral.model.IntegralUserPoint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IntegralUserPointMapper {
    int deleteByPrimaryKey(String id);

    int insert(IntegralUserPoint record);

    int insertSelective(IntegralUserPoint record);

    IntegralUserPoint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IntegralUserPoint record);

    int updateByPrimaryKey(IntegralUserPoint record);

    IntegralUserPoint selectOneByUserId(@Param("userId") String userId);

    List<String> selectUnInitialUserList();

    List<IntegralUserPoint> selectAllIntegralPoints();

    List<IntegralUserPoint> selectIntegralPointsByUserIds(@Param("userIdList") List<String> userIdList);

    List<IntegralUserPoint> selectByUserId(@Param("userId") String userId);

    List<String> selectUserIdByUserIdList(@Param("userIdList") List<String> userIdList);

    void batchUpdateUserPoint(@Param("updatePointList") List<IntegralUserPoint> updatePointList);
}
