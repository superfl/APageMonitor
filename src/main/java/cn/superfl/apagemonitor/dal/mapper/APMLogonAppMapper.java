package cn.superfl.apagemonitor.dal.mapper;

import cn.superfl.apagemonitor.dal.dao.APMLogonApp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface APMLogonAppMapper {
    int deleteByPrimaryKey(Long logonid);

    int insert(APMLogonApp record);

    int insertSelective(APMLogonApp record);

    APMLogonApp selectByPrimaryKey(Long logonid);

    int updateByPrimaryKeySelective(APMLogonApp record);

    int updateByPrimaryKey(APMLogonApp record);
}