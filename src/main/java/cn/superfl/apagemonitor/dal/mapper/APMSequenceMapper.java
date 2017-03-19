package cn.superfl.apagemonitor.dal.mapper;

import cn.superfl.apagemonitor.dal.dao.APMSequence;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface APMSequenceMapper {
    int insert(APMSequence record);

    int insertSelective(APMSequence record);

    APMSequence selectBySeqNameForUpdate(String seqName);

    int updateSeqValueBySeqName(APMSequence record);
}