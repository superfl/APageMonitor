/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package cn.superfl.apagemonitor.model.user;

import cn.superfl.apagemonitor.model.ToString;

import java.util.Date;

/**
 *
 * @author superfl
 * @version $Id: LogonApp.java, v 0.1 2017-03-14 上午11:12 superfl Exp $$
 */
public class LogonApp extends ToString{
    /** 登录号 */
    private String logonapp;

    /** 登录号类型 */
    private String logontype;

    /** 登录号状态 */
    private Integer enablestatus;

    /** 创建时间 */
    private Date createdate;

    /**
     * Getter method for property logonapp.
     *
     * @return property value of logonapp
     */
    public String getLogonapp() {
        return logonapp;
    }

    /**
     * Setter method for property logonapp.
     *
     * @param logonapp value to be assigned to property logonapp
     */
    public void setLogonapp(String logonapp) {
        this.logonapp = logonapp;
    }

    /**
     * Getter method for property logontype.
     *
     * @return property value of logontype
     */
    public String getLogontype() {
        return logontype;
    }

    /**
     * Setter method for property logontype.
     *
     * @param logontype value to be assigned to property logontype
     */
    public void setLogontype(String logontype) {
        this.logontype = logontype;
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
}