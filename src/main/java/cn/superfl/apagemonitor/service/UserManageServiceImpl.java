/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.service;

import cn.superfl.apagemonitor.dal.dao.APMLogonApp;
import cn.superfl.apagemonitor.dal.dao.APMUser;
import cn.superfl.apagemonitor.dal.mapper.APMLogonAppMapper;
import cn.superfl.apagemonitor.dal.mapper.APMUserMapper;
import cn.superfl.apagemonitor.model.enums.EnableStatusEnum;
import cn.superfl.apagemonitor.model.enums.ResultEnum;
import cn.superfl.apagemonitor.model.result.UserOperationResult;
import cn.superfl.apagemonitor.model.user.LogonApp;
import cn.superfl.apagemonitor.model.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 *
 * @author superfl
 * @version $Id: UserManageServiceImpl.java, v 0.1 2017-03-14 上午11:49 superfl Exp $$
 */
@Service
public class UserManageServiceImpl implements UserManageService {

    /**
     * 用户表
     */
    @Autowired
    private APMUserMapper apmUserMapper;

    /**
     * 登录号表
     */
    @Autowired
    private APMLogonAppMapper apmLogonAppMapper;


    /**
     * 注册新的用户
     *
     * @param logonApp
     * @return
     */
    @Override
    @Transactional
    public UserOperationResult registerUser(String logonApp, String logonType, String password) {
        // 新建用户
        APMUser apmUser = new APMUser();
        apmUser.setPassword(password);
        apmUser.setEnablestatus(EnableStatusEnum.NORMAL.getStatusCode());
        apmUser.setCreatedate(new Date());
        apmUserMapper.insert(apmUser);

        // 新建登录号
        APMLogonApp apmLogonApp = new APMLogonApp();
        apmLogonApp.setLogonapp(logonApp);
        apmLogonApp.setLogontype(logonType);
        apmLogonApp.setUserid(apmUser.getUserid());
        apmLogonApp.setEnablestatus(EnableStatusEnum.NORMAL.getStatusCode());
        apmLogonApp.setCreatedate(new Date());
        apmLogonAppMapper.insert(apmLogonApp);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(apmUser.getUserid());
        userInfo.setEnablestatus(apmUser.getEnablestatus());
        userInfo.setPassword(apmUser.getPassword());
        userInfo.setCreatedate(apmUser.getCreatedate());

        LogonApp logonAppModel = new LogonApp();
        logonAppModel.setLogonapp(apmLogonApp.getLogonapp());
        logonAppModel.setLogontype(apmLogonApp.getLogontype());
        logonAppModel.setEnablestatus(apmLogonApp.getEnablestatus());
        logonAppModel.setCreatedate(apmLogonApp.getCreatedate());

        userInfo.getLogonAppList().add(logonAppModel);
        UserOperationResult userOperationResult =new UserOperationResult();
        userOperationResult.setResultCode(ResultEnum.SUCCESS.getCode());
        userOperationResult.setResultMsg(ResultEnum.SUCCESS.getMemo());
        userOperationResult.setUserInfo(userInfo);
        return userOperationResult;
    }
}