/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.service;

import cn.superfl.apagemonitor.model.result.UserOperationResult;

/**
 *
 * @author superfl
 * @version $Id: UserManageService.java, v 0.1 2017-03-14 上午10:53 superfl Exp $$
 */
public interface UserManageService {

    /**
     * 注册新的用户
     *
     * @param logonApp
     * @return
     */
    public UserOperationResult registerUser(String logonApp, String logonType, String password);
}