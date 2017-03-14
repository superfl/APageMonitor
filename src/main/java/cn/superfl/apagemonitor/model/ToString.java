/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author superfl
 * @version $Id: ToString.java, v 0.1 2017-03-14 上午11:31 superfl Exp $$
 */
public abstract class ToString {
    /**
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}