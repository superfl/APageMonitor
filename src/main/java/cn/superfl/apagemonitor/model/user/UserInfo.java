/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.model.user;

import cn.superfl.apagemonitor.model.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  用户信息模型
 *
 * @author superfl
 * @version $Id: UserInfo.java, v 0.1 2017-03-14 上午11:11 superfl Exp $$
 */
public class UserInfo extends ToString{

    /** 用户id */
    private long userId;

    /** 用户密码 */
    private String password;

    /** 使用状态 */
    private Integer enablestatus;

    /** 创建时间 */
    private Date createdate;

    /** 登录号列表 */
    private List<LogonApp> logonAppList = new ArrayList<>();

    /**
     * Setter method for property userId.
     *
     * @param userId value to be assigned to property userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Getter method for property userId.
     *
     * @return property value of userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Getter method for property password.
     *
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property password.
     *
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for property enablestatus.
     *
     * @return property value of enablestatus
     */
    public Integer getEnablestatus() {
        return enablestatus;
    }

    /**
     * Setter method for property enablestatus.
     *
     * @param enablestatus value to be assigned to property enablestatus
     */
    public void setEnablestatus(Integer enablestatus) {
        this.enablestatus = enablestatus;
    }

    /**
     * Getter method for property createdate.
     *
     * @return property value of createdate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * Setter method for property createdate.
     *
     * @param createdate value to be assigned to property createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * Getter method for property logonAppList.
     *
     * @return property value of logonAppList
     */
    public List<LogonApp> getLogonAppList() {
        return logonAppList;
    }

    /**
     * Setter method for property logonAppList.
     *
     * @param logonAppList value to be assigned to property logonAppList
     */
    public void setLogonAppList(List<LogonApp> logonAppList) {
        this.logonAppList = logonAppList;
    }
}