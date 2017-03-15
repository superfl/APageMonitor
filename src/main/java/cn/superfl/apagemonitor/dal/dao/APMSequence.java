package cn.superfl.apagemonitor.dal.dao;

import java.util.Date;

public class APMSequence {
    private String seqname;

    private Long seqvalue;

    private Long minseqvalue;

    private Long maxseqvalue;

    private Long seqstep;

    private Date createtime;

    private Date modifytime;

    public String getSeqname() {
        return seqname;
    }

    public void setSeqname(String seqname) {
        this.seqname = seqname == null ? null : seqname.trim();
    }

    public Long getSeqvalue() {
        return seqvalue;
    }

    public void setSeqvalue(Long seqvalue) {
        this.seqvalue = seqvalue;
    }

    public Long getMinseqvalue() {
        return minseqvalue;
    }

    public void setMinseqvalue(Long minseqvalue) {
        this.minseqvalue = minseqvalue;
    }

    public Long getMaxseqvalue() {
        return maxseqvalue;
    }

    public void setMaxseqvalue(Long maxseqvalue) {
        this.maxseqvalue = maxseqvalue;
    }

    public Long getSeqstep() {
        return seqstep;
    }

    public void setSeqstep(Long seqstep) {
        this.seqstep = seqstep;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}