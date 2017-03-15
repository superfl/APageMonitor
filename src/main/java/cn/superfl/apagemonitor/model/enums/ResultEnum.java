/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.model.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author superfl
 * @version $Id: ResultEnum.java, v 0.1 2017-03-14 上午10:58 superfl Exp $$
 */
public enum ResultEnum {

    SUCCESS(1000, "操作成功"),

    UPDATE_DB_ERROR(2001, "更新DB失败"),

    SYSTEM_ERROR(9999, "稍候再试试");

    private int code;

    private String memo;

    /** 错误码集合 */
    private static final Map<Integer, ResultEnum> MAP = new HashMap<Integer, ResultEnum>();

    static {
        for (ResultEnum each : ResultEnum.values()) {
            MAP.put(each.getCode(), each);
        }
    }

    private ResultEnum(int code, String memo) {
        this.code = code;
        this.memo = memo;
    }

    /**
     * 根据传入code值返回对应的ResultEnum；如果没有查到直接返回SYSTEMERROR的码
     *
     * @param code
     * @return
     */
    public static ResultEnum getByCode(int code) {
        ResultEnum re = MAP.get(code);
        if (null != re) {
            return re;
        } else {
            return SYSTEM_ERROR;
        }
    }

    /**
     * Getter method for property code.
     *
     * @return property value of code
     */
    public int getCode() {
        return code;
    }

    /**
     * Setter method for property code.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Getter method for property memo.
     *
     * @return property value of memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Setter method for property memo.
     *
     * @param memo value to be assigned to property memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }
}