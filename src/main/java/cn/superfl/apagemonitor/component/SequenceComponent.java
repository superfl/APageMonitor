/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.component;

/**
 * Sequence管理
 *
 * @author superfl
 * @version $Id: SequenceComponent.java, v 0.1 2017-03-15 下午11:08 superfl Exp $$
 */
public interface SequenceComponent {

    /**
     * 获取sequence
     *
     * @return
     */
    public long getSequence(String sequenceName);
}