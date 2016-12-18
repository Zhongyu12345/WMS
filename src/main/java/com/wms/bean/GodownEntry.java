package com.wms.bean;

import java.util.Date;

public class GodownEntry {
    private Integer gId;

    private String gName;

    private String gStorerid;

    private String gPhone;

    private String gSupplierid;

    private String gSippingno;

    private String gWhid;

    private Double gNum;

    private String gCrossflag;

    private String gDirectflag;

    private Date gTime;

    private Integer gAdminid;

    private String gSkumodel;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public String getgStorerid() {
        return gStorerid;
    }

    public void setgStorerid(String gStorerid) {
        this.gStorerid = gStorerid == null ? null : gStorerid.trim();
    }

    public String getgPhone() {
        return gPhone;
    }

    public void setgPhone(String gPhone) {
        this.gPhone = gPhone == null ? null : gPhone.trim();
    }

    public String getgSupplierid() {
        return gSupplierid;
    }

    public void setgSupplierid(String gSupplierid) {
        this.gSupplierid = gSupplierid == null ? null : gSupplierid.trim();
    }

    public String getgSippingno() {
        return gSippingno;
    }

    public void setgSippingno(String gSippingno) {
        this.gSippingno = gSippingno == null ? null : gSippingno.trim();
    }

    public String getgWhid() {
        return gWhid;
    }

    public void setgWhid(String gWhid) {
        this.gWhid = gWhid == null ? null : gWhid.trim();
    }

    public Double getgNum() {
        return gNum;
    }

    public void setgNum(Double gNum) {
        this.gNum = gNum;
    }

    public String getgCrossflag() {
        return gCrossflag;
    }

    public void setgCrossflag(String gCrossflag) {
        this.gCrossflag = gCrossflag == null ? null : gCrossflag.trim();
    }

    public String getgDirectflag() {
        return gDirectflag;
    }

    public void setgDirectflag(String gDirectflag) {
        this.gDirectflag = gDirectflag == null ? null : gDirectflag.trim();
    }

    public Date getgTime() {
        return gTime;
    }

    public void setgTime(Date gTime) {
        this.gTime = gTime;
    }

    public Integer getgAdminid() {
        return gAdminid;
    }

    public void setgAdminid(Integer gAdminid) {
        this.gAdminid = gAdminid;
    }

    public String getgSkumodel() {
        return gSkumodel;
    }

    public void setgSkumodel(String gSkumodel) {
        this.gSkumodel = gSkumodel == null ? null : gSkumodel.trim();
    }
}