/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.model.result;

import cn.superfl.apagemonitor.model.user.UserInfo;

/**
 *  用户相关操作结果
 *
 * @author superfl
 * @version $Id: UserOperationResult.java, v 0.1 2017-03-14 上午11:10 superfl Exp $$
 */
public class UserOperationResult extends BaseResult {

    /** 用户信息 */
    private UserInfo userInfo;

    /**
     * Getter method for property userInfo.
     *
     * @return property value of userInfo
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * Setter method for property userInfo.
     *
     * @param userInfo value to be assigned to property userInfo
     */
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}