package cn.superfl.apagemonitor.dal.mapper;

import cn.superfl.apagemonitor.dal.dao.APMTask;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface APMTaskMapper {
    int deleteByPrimaryKey(Long taskid);

    int insert(APMTask record);

    int insertSelective(APMTask record);

    APMTask selectByPrimaryKey(Long taskid);

    int updateByPrimaryKeySelective(APMTask record);

    int updateByPrimaryKeyWithBLOBs(APMTask record);

    int updateByPrimaryKey(APMTask record);
}