/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.model.enums;

/**
 *
 * @author superfl
 * @version $Id: UserTypeEnum.java, v 0.1 2017-03-16 下午3:06 superfl Exp $$
 */
public enum UserTypeEnum {

    /** 企业用户 */
    ENT(0, "企业用户"),

    /** 个人用户 */
    PERSON(2, "个人用户");

    /** type code */
    private int typeCode;

    /** type msg */
    private String typeMsg;

    UserTypeEnum(int code, String msg){
        this.typeCode = code;
        this.typeMsg = msg;
    }

    /**
     * Getter method for property typeCode.
     *
     * @return property value of typeCode
     */
    public int getTypeCode() {
        return typeCode;
    }

    /**
     * Setter method for property typeCode.
     *
     * @param typeCode value to be assigned to property typeCode
     */
    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * Getter method for property typeMsg.
     *
     * @return property value of typeMsg
     */
    public String getTypeMsg() {
        return typeMsg;
    }

    /**
     * Setter method for property typeMsg.
     *
     * @param typeMsg value to be assigned to property typeMsg
     */
    public void setTypeMsg(String typeMsg) {
        this.typeMsg = typeMsg;
    }
}