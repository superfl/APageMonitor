package cn.superfl.apagemonitor.dal.mapper;

import cn.superfl.apagemonitor.dal.dao.APMUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface APMUserMapper {
    int deleteByPrimaryKey(Long userid);

    int insert(APMUser record);

    int insertSelective(APMUser record);

    APMUser selectByPrimaryKey(Long userid);

    int updateByPrimaryKeySelective(APMUser record);

    int updateByPrimaryKey(APMUser record);
}