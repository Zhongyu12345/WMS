package com.wms.bean;

public class CompayAccounts {
    private Integer caId;

    private Integer caAccounts;

    private String caName;

    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public Integer getCaAccounts() {
        return caAccounts;
    }

    public void setCaAccounts(Integer caAccounts) {
        this.caAccounts = caAccounts;
    }

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName == null ? null : caName.trim();
    }
}