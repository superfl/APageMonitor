package cn.superfl.apagemonitor.dal.dao;

import java.util.Date;

public class APMTask {
    private String taskid;

    private String tasktype;

    private String userid;

    private String pageurl;

    private Byte contentchanged;

    private Date createdate;

    private Date changeddate;

    private Integer checkinterval;

    private String pagecontent;

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype == null ? null : tasktype.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPageurl() {
        return pageurl;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl == null ? null : pageurl.trim();
    }

    public Byte getContentchanged() {
        return contentchanged;
    }

    public void setContentchanged(Byte contentchanged) {
        this.contentchanged = contentchanged;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getChangeddate() {
        return changeddate;
    }

    public void setChangeddate(Date changeddate) {
        this.changeddate = changeddate;
    }

    public Integer getCheckinterval() {
        return checkinterval;
    }

    public void setCheckinterval(Integer checkinterval) {
        this.checkinterval = checkinterval;
    }

    public String getPagecontent() {
        return pagecontent;
    }

    public void setPagecontent(String pagecontent) {
        this.pagecontent = pagecontent == null ? null : pagecontent.trim();
    }
}