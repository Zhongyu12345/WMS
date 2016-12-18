package com.wms.bean;

import java.util.Date;

public class SalesReturn {
    private Integer srId;

    private String srName;

    private String srSipping;

    private Integer srStorerid;

    private String srPhone;

    private String srNames;

    private String srSkumodel;

    private Double srNum;

    private String srCause;

    private Date srTime;

    private Integer srWhid;

    private Double srVolume;

    public Integer getSrId() {
        return srId;
    }

    public void setSrId(Integer srId) {
        this.srId = srId;
    }

    public String getSrName() {
        return srName;
    }

    public void setSrName(String srName) {
        this.srName = srName == null ? null : srName.trim();
    }

    public String getSrSipping() {
        return srSipping;
    }

    public void setSrSipping(String srSipping) {
        this.srSipping = srSipping == null ? null : srSipping.trim();
    }

    public Integer getSrStorerid() {
        return srStorerid;
    }

    public void setSrStorerid(Integer srStorerid) {
        this.srStorerid = srStorerid;
    }

    public String getSrPhone() {
        return srPhone;
    }

    public void setSrPhone(String srPhone) {
        this.srPhone = srPhone == null ? null : srPhone.trim();
    }

    public String getSrNames() {
        return srNames;
    }

    public void setSrNames(String srNames) {
        this.srNames = srNames == null ? null : srNames.trim();
    }

    public String getSrSkumodel() {
        return srSkumodel;
    }

    public void setSrSkumodel(String srSkumodel) {
        this.srSkumodel = srSkumodel == null ? null : srSkumodel.trim();
    }

    public Double getSrNum() {
        return srNum;
    }

    public void setSrNum(Double srNum) {
        this.srNum = srNum;
    }

    public String getSrCause() {
        return srCause;
    }

    public void setSrCause(String srCause) {
        this.srCause = srCause == null ? null : srCause.trim();
    }

    public Date getSrTime() {
        return srTime;
    }

    public void setSrTime(Date srTime) {
        this.srTime = srTime;
    }

    public Integer getSrWhid() {
        return srWhid;
    }

    public void setSrWhid(Integer srWhid) {
        this.srWhid = srWhid;
    }

    public Double getSrVolume() {
        return srVolume;
    }

    public void setSrVolume(Double srVolume) {
        this.srVolume = srVolume;
    }
}