package com.wms.bean;

import java.util.Date;

public class Receiving {
    private Integer rId;

    private String rName;

    private String rStorerid;

    private String rPhone;

    private String rSupplierid;

    private String rSippingno;

    private String rWhid;

    private Double rNum;

    private String rCrossflag;

    private String rDirectflag;

    private Date rTime;

    private Integer rAdminid;

    private Integer rPartflag;

    private String rSkumodel;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrStorerid() {
        return rStorerid;
    }

    public void setrStorerid(String rStorerid) {
        this.rStorerid = rStorerid == null ? null : rStorerid.trim();
    }

    public String getrPhone() {
        return rPhone;
    }

    public void setrPhone(String rPhone) {
        this.rPhone = rPhone == null ? null : rPhone.trim();
    }

    public String getrSupplierid() {
        return rSupplierid;
    }

    public void setrSupplierid(String rSupplierid) {
        this.rSupplierid = rSupplierid == null ? null : rSupplierid.trim();
    }

    public String getrSippingno() {
        return rSippingno;
    }

    public void setrSippingno(String rSippingno) {
        this.rSippingno = rSippingno == null ? null : rSippingno.trim();
    }

    public String getrWhid() {
        return rWhid;
    }

    public void setrWhid(String rWhid) {
        this.rWhid = rWhid == null ? null : rWhid.trim();
    }

    public Double getrNum() {
        return rNum;
    }

    public void setrNum(Double rNum) {
        this.rNum = rNum;
    }

    public String getrCrossflag() {
        return rCrossflag;
    }

    public void setrCrossflag(String rCrossflag) {
        this.rCrossflag = rCrossflag == null ? null : rCrossflag.trim();
    }

    public String getrDirectflag() {
        return rDirectflag;
    }

    public void setrDirectflag(String rDirectflag) {
        this.rDirectflag = rDirectflag == null ? null : rDirectflag.trim();
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public Integer getrAdminid() {
        return rAdminid;
    }

    public void setrAdminid(Integer rAdminid) {
        this.rAdminid = rAdminid;
    }

    public Integer getrPartflag() {
        return rPartflag;
    }

    public void setrPartflag(Integer rPartflag) {
        this.rPartflag = rPartflag;
    }

    public String getrSkumodel() {
        return rSkumodel;
    }

    public void setrSkumodel(String rSkumodel) {
        this.rSkumodel = rSkumodel == null ? null : rSkumodel.trim();
    }
}