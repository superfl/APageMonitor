/**

 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.controller;

import cn.superfl.apagemonitor.model.result.BaseResult;
import cn.superfl.apagemonitor.service.UserManageService;
import cn.superfl.apagemonitor.util.LoggerUtil;
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
        BaseResult result = userManageService.registerUser(logonApp, logonType, password);
        LoggerUtil.info(logger, "regist finish, result:", result);
        return result;
    }




}