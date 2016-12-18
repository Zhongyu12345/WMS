package com.wms.bean;

import java.util.Date;

public class MakeInventory {
    private Integer miId;

    private String miName;

    private String miSkumodel;

    private Double miNum;

    private String miNames;

    private Integer miWhid;

    private Date miTime;

    public Integer getMiId() {
        return miId;
    }

    public void setMiId(Integer miId) {
        this.miId = miId;
    }

    public String getMiName() {
        return miName;
    }

    public void setMiName(String miName) {
        this.miName = miName == null ? null : miName.trim();
    }

    public String getMiSkumodel() {
        return miSkumodel;
    }

    public void setMiSkumodel(String miSkumodel) {
        this.miSkumodel = miSkumodel == null ? null : miSkumodel.trim();
    }

    public Double getMiNum() {
        return miNum;
    }

    public void setMiNum(Double miNum) {
        this.miNum = miNum;
    }

    public String getMiNames() {
        return miNames;
    }

    public void setMiNames(String miNames) {
        this.miNames = miNames == null ? null : miNames.trim();
    }

    public Integer getMiWhid() {
        return miWhid;
    }

    public void setMiWhid(Integer miWhid) {
        this.miWhid = miWhid;
    }

    public Date getMiTime() {
        return miTime;
    }

    public void setMiTime(Date miTime) {
        this.miTime = miTime;
    }
}