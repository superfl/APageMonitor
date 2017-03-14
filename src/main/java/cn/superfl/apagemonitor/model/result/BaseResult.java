/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.model.result;

import cn.superfl.apagemonitor.model.ToString;
import cn.superfl.apagemonitor.model.enums.ResultEnum;

/**
 *
 * @author superfl
 * @version $Id: BaseResult.java, v 0.1 2017-03-14 上午10:55 superfl Exp $$
 */
public class BaseResult extends ToString {

    /**
     * 结果码
     */
    private int resultCode;

    /**
     * 结果文案
     */
    private String resultMsg;

    /**
     * 根据ResultEnum构建结果
     *
     * @param resultEnum
     * @return
     */
    public static BaseResult valueOfResult(ResultEnum resultEnum){
        BaseResult baseResult = new BaseResult();
        baseResult.setResultCode(resultEnum.getCode());
        baseResult.setResultMsg(resultEnum.getMemo());
        return baseResult;
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

    /**
     * Getter method for property resultMsg.
     *
     * @return property value of resultMsg
     */
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * Setter method for property resultMsg.
     *
     * @param resultMsg value to be assigned to property resultMsg
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}