package cn.superfl.apagemonitor.dal.mapper;

import cn.superfl.apagemonitor.dal.dao.APMTask;

public interface APMTaskMapper {
    int deleteByPrimaryKey(String taskid);

    int insert(APMTask record);

    int insertSelective(APMTask record);

    APMTask selectByPrimaryKey(String taskid);

    int updateByPrimaryKeySelective(APMTask record);

    int updateByPrimaryKeyWithBLOBs(APMTask record);

    int updateByPrimaryKey(APMTask record);
}