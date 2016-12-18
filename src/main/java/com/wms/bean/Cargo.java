package com.wms.bean;

import java.util.Date;

public class Cargo {
    private Integer cId;

    private String cName;

    private String cStorerid;

    private String cSupplierid;

    private String cShippingno;

    private String cWhid;

    private Integer cNum;

    private Double cTotalweight;

    private Double cTotalvolume;

    private Date cReceivedate;

    private String cSkumodel;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcStorerid() {
        return cStorerid;
    }

    public void setcStorerid(String cStorerid) {
        this.cStorerid = cStorerid == null ? null : cStorerid.trim();
    }

    public String getcSupplierid() {
        return cSupplierid;
    }

    public void setcSupplierid(String cSupplierid) {
        this.cSupplierid = cSupplierid == null ? null : cSupplierid.trim();
    }

    public String getcShippingno() {
        return cShippingno;
    }

    public void setcShippingno(String cShippingno) {
        this.cShippingno = cShippingno == null ? null : cShippingno.trim();
    }

    public String getcWhid() {
        return cWhid;
    }

    public void setcWhid(String cWhid) {
        this.cWhid = cWhid == null ? null : cWhid.trim();
    }

    public Integer getcNum() {
        return cNum;
    }

    public void setcNum(Integer cNum) {
        this.cNum = cNum;
    }

    public Double getcTotalweight() {
        return cTotalweight;
    }

    public void setcTotalweight(Double cTotalweight) {
        this.cTotalweight = cTotalweight;
    }

    public Double getcTotalvolume() {
        return cTotalvolume;
    }

    public void setcTotalvolume(Double cTotalvolume) {
        this.cTotalvolume = cTotalvolume;
    }

    public Date getcReceivedate() {
        return cReceivedate;
    }

    public void setcReceivedate(Date cReceivedate) {
        this.cReceivedate = cReceivedate;
    }

    public String getcSkumodel() {
        return cSkumodel;
    }

    public void setcSkumodel(String cSkumodel) {
        this.cSkumodel = cSkumodel == null ? null : cSkumodel.trim();
    }
}