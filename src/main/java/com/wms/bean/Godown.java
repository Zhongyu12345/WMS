package com.wms.bean;

public class Godown {
    private Integer goId;

    private String goWhid;

    private String goP;

    private Double goVolume;

    private Double goUsevolume;

    private Double goRdvolume;

    public Integer getGoId() {
        return goId;
    }

    public void setGoId(Integer goId) {
        this.goId = goId;
    }

    public String getGoWhid() {
        return goWhid;
    }

    public void setGoWhid(String goWhid) {
        this.goWhid = goWhid == null ? null : goWhid.trim();
    }

    public String getGoP() {
        return goP;
    }

    public void setGoP(String goP) {
        this.goP = goP == null ? null : goP.trim();
    }

    public Double getGoVolume() {
        return goVolume;
    }

    public void setGoVolume(Double goVolume) {
        this.goVolume = goVolume;
    }

    public Double getGoUsevolume() {
        return goUsevolume;
    }

    public void setGoUsevolume(Double goUsevolume) {
        this.goUsevolume = goUsevolume;
    }

    public Double getGoRdvolume() {
        return goRdvolume;
    }

    public void setGoRdvolume(Double goRdvolume) {
        this.goRdvolume = goRdvolume;
    }
}