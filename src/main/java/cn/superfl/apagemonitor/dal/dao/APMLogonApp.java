package cn.superfl.apagemonitor.dal.dao;

import java.util.Date;

public class APMLogonApp {
    private Long logonid;

    private String logonapp;

    private String logontype;

    private Long userid;

    private Integer enablestatus;

    private Date createdate;

    public Long getLogonid() {
        return logonid;
    }

    public void setLogonid(Long logonid) {
        this.logonid = logonid;
    }

    public String getLogonapp() { return logonapp; }

    public void setLogonapp(String logonapp) {
        this.logonapp = logonapp == null? null : logonapp.trim();
    }

    public String getLogontype() {
        return logontype;
    }

    public void setLogontype(String logontype) {
        this.logontype = logontype == null ? null : logontype.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getEnablestatus() {
        return enablestatus;
    }

    public void setEnablestatus(Integer enablestatus) {
        this.enablestatus = enablestatus;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getCreatedate() {
        return createdate;
    }
}