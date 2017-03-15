package cn.superfl.apagemonitor.dal.mapper;

import cn.superfl.apagemonitor.dal.dao.APMSequence;

public interface APMSequenceMapper {
    int insert(APMSequence record);

    int insertSelective(APMSequence record);

    APMSequence selectBySeqNameForUpdate(String seqName);

    int updateSeqValueBySeqName(APMSequence record);
}