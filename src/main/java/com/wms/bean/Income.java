package com.wms.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;

public class Income {
	@TableId(type = IdType.AUTO)
    private Integer iid;

    private String icause;

    private Date itime;

    private String iabout;

    private Long icount;

    private Long iincome;

    private Long ibalance;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getIcause() {
        return icause;
    }

    public void setIcause(String icause) {
        this.icause = icause == null ? null : icause.trim();
    }

    public Date getItime() {
        return itime;
    }

    public void setItime(Date itime) {
        this.itime = itime;
    }

    public String getIabout() {
        return iabout;
    }

    public void setIabout(String iabout) {
        this.iabout = iabout == null ? null : iabout.trim();
    }

    public Long getIcount() {
        return icount;
    }

    public void setIcount(Long icount) {
        this.icount = icount;
    }

    public Long getIincome() {
        return iincome;
    }

    public void setIincome(Long iincome) {
        this.iincome = iincome;
    }

    public Long getIbalance() {
        return ibalance;
    }

    public void setIbalance(Long ibalance) {
        this.ibalance = ibalance;
    }
}