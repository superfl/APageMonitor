/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.controller;

import cn.superfl.apagemonitor.model.enums.ResultEnum;
import cn.superfl.apagemonitor.model.result.BaseResult;
import cn.superfl.apagemonitor.service.UserManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author superfl
 * @version $Id: UserController.java, v 0.1 2017-03-14 下午1:29 superfl Exp $$
 */

@RestController
public class UserController {

    /** logger */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserManageService userManageService;

    @ResponseBody
    @RequestMapping(value="/users",method = RequestMethod.POST)
    public BaseResult register(@RequestParam(value = "logonApp", required = true) String logonApp,
                               @RequestParam(value = "logonType", required = true) String logonType,
                               @RequestParam(value = "password", required = true) String password) {
        try {
            BaseResult result = userManageService.registerUser(logonApp, logonType, password);
            logger.info("regist success ", result);
            return result;
        }
        catch (Throwable th){
            logger.error("register error", th);
            return BaseResult.valueOfResult(ResultEnum.SYSTEM_ERROR);
        }

    }

}