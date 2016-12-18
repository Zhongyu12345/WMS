package com.wms.bean;

import java.util.Date;

public class Allotput {
    private Integer apId;

    private String apName;

    private String apSkumodel;

    private Double apNum;

    private String apWhid;

    private String apSipping;

    private Date apTime;

    private Double apVolume;

    private String apAddress;

    public Integer getApId() {
        return apId;
    }

    public void setApId(Integer apId) {
        this.apId = apId;
    }

    public String getApName() {
        return apName;
    }

    public void setApName(String apName) {
        this.apName = apName == null ? null : apName.trim();
    }

    public String getApSkumodel() {
        return apSkumodel;
    }

    public void setApSkumodel(String apSkumodel) {
        this.apSkumodel = apSkumodel == null ? null : apSkumodel.trim();
    }

    public Double getApNum() {
        return apNum;
    }

    public void setApNum(Double apNum) {
        this.apNum = apNum;
    }

    public String getApWhid() {
        return apWhid;
    }

    public void setApWhid(String apWhid) {
        this.apWhid = apWhid == null ? null : apWhid.trim();
    }

    public String getApSipping() {
        return apSipping;
    }

    public void setApSipping(String apSipping) {
        this.apSipping = apSipping == null ? null : apSipping.trim();
    }

    public Date getApTime() {
        return apTime;
    }

    public void setApTime(Date apTime) {
        this.apTime = apTime;
    }

    public Double getApVolume() {
        return apVolume;
    }

    public void setApVolume(Double apVolume) {
        this.apVolume = apVolume;
    }

    public String getApAddress() {
        return apAddress;
    }

    public void setApAddress(String apAddress) {
        this.apAddress = apAddress == null ? null : apAddress.trim();
    }
}