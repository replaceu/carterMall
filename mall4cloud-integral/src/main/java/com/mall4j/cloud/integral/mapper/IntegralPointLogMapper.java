package com.mall4j.cloud.integral.mapper;

import com.github.pagehelper.Page;
import com.mall4j.cloud.integral.model.IntegralPointLog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface IntegralPointLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(IntegralPointLog record);

    int insertSelective(IntegralPointLog record);

    IntegralPointLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IntegralPointLog record);

    int updateByPrimaryKey(IntegralPointLog record);

    Page<IntegralPointLog> selectUserIntegralPointLogList(Object uiplqDto, RowBounds buildRowBounds);

    List<IntegralPointLog> selectUserIntegralPointByUserId(String userId);

    List<IntegralPointLog> selectIntegralPointLogByUserIds(@Param("userIdList") List<String> userIdList);

    void batchInsertIntegralPointLog(@Param("toInsertList") List<IntegralPointLog> toInsertList);

    List<String> selectByLigIds(@Param("ids") List<String> ids);

    List<IntegralPointLog> selectByPrimaryKeys(IntegralPointLog params);

    List<IntegralPointLog> selectUserPointLogInRefValueList(@Param("userId") String userId, @Param("refValueList") List<String> refValueList);

    Page<IntegralPointLog> selectUserIntegralPointLogDistinctList(Object uiplqDto, RowBounds buildRowBounds);

    List<String> selectAllUserIdList();

    List<String> selectUserIdByRefTypeList(@Param("refTypeList") List<String> refTypeList);

    List<IntegralPointLog> selectUserPointLogValid(@Param("userId") String userId);

    void batchUpdatePointLogUsedVal(@Param("logList") List<IntegralPointLog> logList);

    List<String> selectUserIdListValid();

    Integer sumSubIntegralPointByIdList(@Param("logIdList") List<String> logIdList);

    List<IntegralPointLog> selectUnbalanceAddPointLogByUserId(@Param("userId") String userId);

    List<IntegralPointLog> selectAllUnDealSubLogs();

    List<IntegralPointLog> selectAllUnExpiredAddLogs(@Param("startDate") String startDate, @Param("endDate") String endDate);
}

