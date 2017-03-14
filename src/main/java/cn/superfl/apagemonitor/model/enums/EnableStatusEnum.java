/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.model.enums;

/**
 * 状态枚举
 *
 * @author superfl
 * @version $Id: EnableStatusEnum.java, v 0.1 2017-03-14 下午1:08 superfl Exp $$
 */
public enum EnableStatusEnum {

    /** 正常状态 */
    NORMAL(1, "正常状态"),

    /** 冻结状态 */
    BLOCK(2, "冻结状态");

    /** status code */
    private int statusCode;

    /** status msg */
    private String statusMsg;

    EnableStatusEnum(int statusCode, String statusMsg){
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    /**
     * Setter method for property statusCode.
     *
     * @param statusCode value to be assigned to property statusCode
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Setter method for property statusMsg.
     *
     * @param statusMsg value to be assigned to property statusMsg
     */
    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    /**
     * Getter method for property statusCode.
     *
     * @return property value of statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Getter method for property statusMsg.
     *
     * @return property value of statusMsg
     */
    public String getStatusMsg() {
        return statusMsg;
    }
}