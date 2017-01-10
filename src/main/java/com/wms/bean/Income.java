package com.wms.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;

public class Income {
	@TableId(type = IdType.AUTO)
    private Integer iid;

    private String icause;

    private Date itime;

    private String iabout;

    private BigDecimal icount;

    private BigDecimal iincome;

    private BigDecimal ibalance;

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

    public BigDecimal getIcount() {
        return icount;
    }

    public void setIcount(BigDecimal icount) {
        this.icount = icount;
    }

    public BigDecimal getIincome() {
        return iincome;
    }

    public void setIincome(BigDecimal iincome) {
        this.iincome = iincome;
    }

    public BigDecimal getIbalance() {
        return ibalance;
    }

    public void setIbalance(BigDecimal ibalance) {
        this.ibalance = ibalance;
    }
}