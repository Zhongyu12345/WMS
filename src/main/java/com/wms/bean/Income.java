package com.wms.bean;

import java.util.Date;

public class Income {
    private Integer iId;

    private Long iIncome;

    private Long iPay;

    private Date iTime;

    private Integer iCaid;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public Long getiIncome() {
        return iIncome;
    }

    public void setiIncome(Long iIncome) {
        this.iIncome = iIncome;
    }

    public Long getiPay() {
        return iPay;
    }

    public void setiPay(Long iPay) {
        this.iPay = iPay;
    }

    public Date getiTime() {
        return iTime;
    }

    public void setiTime(Date iTime) {
        this.iTime = iTime;
    }

    public Integer getiCaid() {
        return iCaid;
    }

    public void setiCaid(Integer iCaid) {
        this.iCaid = iCaid;
    }
}