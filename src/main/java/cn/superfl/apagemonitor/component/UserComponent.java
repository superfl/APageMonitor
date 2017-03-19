/**
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.component;

import cn.superfl.apagemonitor.model.user.UserInfo;

/**
 *
 * @author superfl
 * @version $Id: UserComponent.java, v 0.1 2017-03-16 下午2:03 superfl Exp $$
 */
public interface UserComponent {

    /**
     * 生成UserId
     * 格式: 5233+六位时间戳倒置+10位seq前4位倒置+用户分类位+10位seq后6位+校验位
     * 共22位
     * @return
     */
    public String genUserId(int userType);

    /**
     * 创建用户
     *
     * @param logonApp
     * @param logonType
     * @param password
     * @return
     */
    public UserInfo createUser(String userId, String logonApp, String logonType, String password);

}