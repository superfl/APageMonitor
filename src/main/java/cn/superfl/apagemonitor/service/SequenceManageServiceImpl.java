/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.service;

import cn.superfl.apagemonitor.dal.dao.APMSequence;
import cn.superfl.apagemonitor.dal.mapper.APMSequenceMapper;
import cn.superfl.apagemonitor.model.APMException;
import cn.superfl.apagemonitor.model.enums.ResultEnum;
import cn.superfl.apagemonitor.model.seq.SequenceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author superfl
 * @version $Id: SequenceManageServiceImpl.java, v 0.1 2017-03-15 下午11:12 superfl Exp $$
 */
@Service
public class SequenceManageServiceImpl implements SequenceManageService {

    /** map */
    private ConcurrentHashMap<String, SequenceModel> sequenceMap = new ConcurrentHashMap<>();

    @Autowired
    private APMSequenceMapper apmSequenceMapper;

    /**
     * 获取sequence
     *
     * @return

     * @param sequenceName
     */
    @Override public long getSequence(String sequenceName) {
        SequenceModel sequenceModel = sequenceMap.get(sequenceName);
        if (sequenceModel != null ){
            long seq = sequenceModel.getCurrentSequence();
            // 大于-1返回seq
            if (seq > -1) return seq;
        }
        // seqmodel为空或者已超限,重新获取sequencemodel
        sequenceModel = getSequenceModelFromDB(sequenceName);
        long seq =  sequenceModel.getCurrentSequence();
        sequenceMap.put(sequenceName, sequenceModel);
        return seq;
    }

    /**
     * 从db查询SequenceModel
     *
     * db maxSeqValue是开区间
     * db minSeqValue是闭区间
     *
     * @param sequenceName
     * @return
     */
    @Transactional
    private SequenceModel getSequenceModelFromDB(String sequenceName){
        // 获取模型
        APMSequence apmSequence = apmSequenceMapper.selectBySeqNameForUpdate(sequenceName);

        // 计算当前seq范围
        long nextMaxSeq = apmSequence.getSeqvalue() + apmSequence.getSeqstep();
        long currentSeq = apmSequence.getSeqvalue();
        if (nextMaxSeq > apmSequence.getMaxseqvalue()){
            nextMaxSeq = apmSequence.getMinseqvalue() + apmSequence.getSeqstep();
            currentSeq = apmSequence.getMinseqvalue();
        }

        // 构造更新的sequence
        apmSequence.setSeqvalue(nextMaxSeq);
        apmSequence.setModifytime(new Date());
        int updateResult = apmSequenceMapper.updateSeqValueBySeqName(apmSequence);
        if (updateResult != 1){
            throw new APMException(ResultEnum.UPDATE_DB_ERROR.getCode(), "更新Sequence表返回影响行数为"+updateResult);
        }

        // 构造返回的SequenceModel
        SequenceModel sequenceModel = new SequenceModel();
        sequenceModel.setSeqName(sequenceName);
        sequenceModel.setCurrentSeqValue(currentSeq);
        sequenceModel.setMaxSeqValue(nextMaxSeq-1);
        return sequenceModel;
    }
}