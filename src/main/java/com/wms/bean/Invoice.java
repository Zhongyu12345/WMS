package com.wms.bean;

import java.util.Date;

public class Invoice {
    private Integer inId;

    private String inName;

    private String inSkumodel;

    private Double inNum;

    private String inWhid;

    private String inOddnumber;

    private Date inTime;

    private Double inVolume;

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName == null ? null : inName.trim();
    }

    public String getInSkumodel() {
        return inSkumodel;
    }

    public void setInSkumodel(String inSkumodel) {
        this.inSkumodel = inSkumodel == null ? null : inSkumodel.trim();
    }

    public Double getInNum() {
        return inNum;
    }

    public void setInNum(Double inNum) {
        this.inNum = inNum;
    }

    public String getInWhid() {
        return inWhid;
    }

    public void setInWhid(String inWhid) {
        this.inWhid = inWhid == null ? null : inWhid.trim();
    }

    public String getInOddnumber() {
        return inOddnumber;
    }

    public void setInOddnumber(String inOddnumber) {
        this.inOddnumber = inOddnumber == null ? null : inOddnumber.trim();
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Double getInVolume() {
        return inVolume;
    }

    public void setInVolume(Double inVolume) {
        this.inVolume = inVolume;
    }
}