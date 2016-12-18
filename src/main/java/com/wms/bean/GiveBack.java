package com.wms.bean;

import java.util.Date;

public class GiveBack {
    private Integer gbId;

    private String gbName;

    private String gbSkumodel;

    private Double gbNum;

    private String gbCause;

    private Integer gbStatus;

    private Date gbTime;

    public Integer getGbId() {
        return gbId;
    }

    public void setGbId(Integer gbId) {
        this.gbId = gbId;
    }

    public String getGbName() {
        return gbName;
    }

    public void setGbName(String gbName) {
        this.gbName = gbName == null ? null : gbName.trim();
    }

    public String getGbSkumodel() {
        return gbSkumodel;
    }

    public void setGbSkumodel(String gbSkumodel) {
        this.gbSkumodel = gbSkumodel == null ? null : gbSkumodel.trim();
    }

    public Double getGbNum() {
        return gbNum;
    }

    public void setGbNum(Double gbNum) {
        this.gbNum = gbNum;
    }

    public String getGbCause() {
        return gbCause;
    }

    public void setGbCause(String gbCause) {
        this.gbCause = gbCause == null ? null : gbCause.trim();
    }

    public Integer getGbStatus() {
        return gbStatus;
    }

    public void setGbStatus(Integer gbStatus) {
        this.gbStatus = gbStatus;
    }

    public Date getGbTime() {
        return gbTime;
    }

    public void setGbTime(Date gbTime) {
        this.gbTime = gbTime;
    }
}