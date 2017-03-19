/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.service;

import cn.superfl.apagemonitor.component.UserComponent;
import cn.superfl.apagemonitor.model.APMException;
import cn.superfl.apagemonitor.model.enums.ResultEnum;
import cn.superfl.apagemonitor.model.enums.UserTypeEnum;
import cn.superfl.apagemonitor.model.result.UserOperationResult;
import cn.superfl.apagemonitor.model.user.UserInfo;
import cn.superfl.apagemonitor.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author superfl
 * @version $Id: UserManageServiceImpl.java, v 0.1 2017-03-14 上午11:49 superfl Exp $$
 */
@Service
public class UserManageServiceImpl implements UserManageService {

    /** logger */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserComponent userComponent;

    /**
     * 注册新的用户
     *
     * @param logonApp
     * @return
     */
    @Override
    public UserOperationResult registerUser(String logonApp, String logonType, String password) {
        UserOperationResult userOperationResult;
        try{
            // 生成uid
            String userId = userComponent.genUserId(UserTypeEnum.PERSON.getTypeCode());

            // 注册
            UserInfo userInfo = userComponent.createUser(userId, logonApp,logonType,password);
            if (userInfo == null){
                userOperationResult = UserOperationResult.valueOfResult(ResultEnum.SYSTEM_ERROR, null);
            }else {
                userOperationResult = UserOperationResult.valueOfResult(ResultEnum.SUCCESS, userInfo);
            }

        }catch (APMException apmExp){
            ResultEnum errorRes = ResultEnum.getByCode(apmExp.getResultCode());
            userOperationResult = UserOperationResult.valueOfResult(errorRes, null);
        }
        catch (Throwable throwable){
            LoggerUtil.error(logger, throwable, "operation error");
            userOperationResult = UserOperationResult.valueOfResult(ResultEnum.SYSTEM_ERROR, null);
        }
        LoggerUtil.info(logger, "regist new user, logonapp:", logonApp, ",logontype:", logonType, ",result=",
                userOperationResult);
        return userOperationResult;
    }

}