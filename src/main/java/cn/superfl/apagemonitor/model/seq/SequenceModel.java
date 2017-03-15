/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.model.seq;

/**
 *
 * @author superfl
 * @version $Id: SequenceModel.java, v 0.1 2017-03-15 下午11:23 superfl Exp $$
 */
public class SequenceModel {

    /** 当前seq的名称 */
    private String seqName;

    /** 当前seq,还没使用 */
    private long currentSeqValue;

    /** 当前seq最大值 */
    private long maxSeqValue;

    /**
     * 获取seq
     *
     * @return >0值 seq
     *         -1   seq超限,重新获取
     */
    public synchronized long getCurrentSequence(){
        if (currentSeqValue <= maxSeqValue){
            return currentSeqValue++;
        }
        return -1;
    }


    /**
     * Getter method for property seqName.
     *
     * @return property value of seqName
     */
    public String getSeqName() {
        return seqName;
    }

    /**
     * Setter method for property seqName.
     *
     * @param seqName value to be assigned to property seqName
     */
    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    /**
     * Getter method for property currentSeqValue.
     *
     * @return property value of currentSeqValue
     */
    public long getCurrentSeqValue() {
        return currentSeqValue;
    }

    /**
     * Setter method for property currentSeqValue.
     *
     * @param currentSeqValue value to be assigned to property currentSeqValue
     */
    public void setCurrentSeqValue(long currentSeqValue) {
        this.currentSeqValue = currentSeqValue;
    }

    /**
     * Getter method for property maxSeqValue.
     *
     * @return property value of maxSeqValue
     */
    public long getMaxSeqValue() {
        return maxSeqValue;
    }

    /**
     * Setter method for property maxSeqValue.
     *
     * @param maxSeqValue value to be assigned to property maxSeqValue
     */
    public void setMaxSeqValue(long maxSeqValue) {
        this.maxSeqValue = maxSeqValue;
    }
}