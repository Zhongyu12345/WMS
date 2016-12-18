package com.wms.bean;

import java.util.Date;

public class CargoBorrow {
    private Integer cbId;

    private String cbName;

    private String cbSkumodel;

    private Double cbNum;

    private String cbCause;

    private String cbNames;

    private Date cbTime;

    public Integer getCbId() {
        return cbId;
    }

    public void setCbId(Integer cbId) {
        this.cbId = cbId;
    }

    public String getCbName() {
        return cbName;
    }

    public void setCbName(String cbName) {
        this.cbName = cbName == null ? null : cbName.trim();
    }

    public String getCbSkumodel() {
        return cbSkumodel;
    }

    public void setCbSkumodel(String cbSkumodel) {
        this.cbSkumodel = cbSkumodel == null ? null : cbSkumodel.trim();
    }

    public Double getCbNum() {
        return cbNum;
    }

    public void setCbNum(Double cbNum) {
        this.cbNum = cbNum;
    }

    public String getCbCause() {
        return cbCause;
    }

    public void setCbCause(String cbCause) {
        this.cbCause = cbCause == null ? null : cbCause.trim();
    }

    public String getCbNames() {
        return cbNames;
    }

    public void setCbNames(String cbNames) {
        this.cbNames = cbNames == null ? null : cbNames.trim();
    }

    public Date getCbTime() {
        return cbTime;
    }

    public void setCbTime(Date cbTime) {
        this.cbTime = cbTime;
    }
}