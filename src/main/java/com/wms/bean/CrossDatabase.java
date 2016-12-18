package com.wms.bean;

import java.util.Date;

public class CrossDatabase {
    private Integer cdId;

    private String cdName;

    private String cdSkumodel;

    private Double cdNum;

    private String cdWhid;

    private String cdOddnumbers;

    private Date cdTime;

    private Double cdVolume;

    public Integer getCdId() {
        return cdId;
    }

    public void setCdId(Integer cdId) {
        this.cdId = cdId;
    }

    public String getCdName() {
        return cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName == null ? null : cdName.trim();
    }

    public String getCdSkumodel() {
        return cdSkumodel;
    }

    public void setCdSkumodel(String cdSkumodel) {
        this.cdSkumodel = cdSkumodel == null ? null : cdSkumodel.trim();
    }

    public Double getCdNum() {
        return cdNum;
    }

    public void setCdNum(Double cdNum) {
        this.cdNum = cdNum;
    }

    public String getCdWhid() {
        return cdWhid;
    }

    public void setCdWhid(String cdWhid) {
        this.cdWhid = cdWhid == null ? null : cdWhid.trim();
    }

    public String getCdOddnumbers() {
        return cdOddnumbers;
    }

    public void setCdOddnumbers(String cdOddnumbers) {
        this.cdOddnumbers = cdOddnumbers == null ? null : cdOddnumbers.trim();
    }

    public Date getCdTime() {
        return cdTime;
    }

    public void setCdTime(Date cdTime) {
        this.cdTime = cdTime;
    }

    public Double getCdVolume() {
        return cdVolume;
    }

    public void setCdVolume(Double cdVolume) {
        this.cdVolume = cdVolume;
    }
}