package cn.superfl.apagemonitor.dal.dao;

import java.util.Date;

public class APMTask {
    private Long taskid;

    private Long userid;

    private String pageurl;

    private Byte contentchanged;

    private Date createdate;

    private Date changeddate;

    private Integer checkinterval;

    private String pagecontent;

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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