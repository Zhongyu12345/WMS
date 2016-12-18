package com.wms.bean;

import java.util.Date;

public class StockRemoval {
    private Integer sId;

    private String sStorerid;

    private Date sTime;

    private String sPhone;

    private String shSippingno;

    private String sWhid;

    private String sClient;

    private String sSkumodel;

    private String sName;

    private Double sNum;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsStorerid() {
        return sStorerid;
    }

    public void setsStorerid(String sStorerid) {
        this.sStorerid = sStorerid == null ? null : sStorerid.trim();
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone == null ? null : sPhone.trim();
    }

    public String getShSippingno() {
        return shSippingno;
    }

    public void setShSippingno(String shSippingno) {
        this.shSippingno = shSippingno == null ? null : shSippingno.trim();
    }

    public String getsWhid() {
        return sWhid;
    }

    public void setsWhid(String sWhid) {
        this.sWhid = sWhid == null ? null : sWhid.trim();
    }

    public String getsClient() {
        return sClient;
    }

    public void setsClient(String sClient) {
        this.sClient = sClient == null ? null : sClient.trim();
    }

    public String getsSkumodel() {
        return sSkumodel;
    }

    public void setsSkumodel(String sSkumodel) {
        this.sSkumodel = sSkumodel == null ? null : sSkumodel.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Double getsNum() {
        return sNum;
    }

    public void setsNum(Double sNum) {
        this.sNum = sNum;
    }
}