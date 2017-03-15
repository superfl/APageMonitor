/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.model;

/**
 *
 * @author superfl
 * @version $Id: APMException.java, v 0.1 2017-03-16 上午12:09 superfl Exp $$
 */
public class APMException extends RuntimeException {

    /** result code */
    private int resultCode;

    public APMException(int resultCode, String message){
        super(message);
        this.resultCode = resultCode;
    }


    /**
     * Getter method for property resultCode.
     *
     * @return property value of resultCode
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * Setter method for property resultCode.
     *
     * @param resultCode value to be assigned to property resultCode
     */
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}