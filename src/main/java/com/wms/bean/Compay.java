package com.wms.bean;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;

public class Compay {
	@TableId(type = IdType.AUTO)
    private Integer caid;

    private String caaccounts;

    private String caname;

    private BigDecimal camoney;

    private BigDecimal cacount;

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public String getCaaccounts() {
        return caaccounts;
    }

    public void setCaaccounts(String caaccounts) {
        this.caaccounts = caaccounts == null ? null : caaccounts.trim();
    }

    public String getCaname() {
        return caname;
    }

    public void setCaname(String caname) {
        this.caname = caname == null ? null : caname.trim();
    }

    public BigDecimal getCamoney() {
        return camoney;
    }

    public void setCamoney(BigDecimal camoney) {
        this.camoney = camoney;
    }

    public BigDecimal getCacount() {
        return cacount;
    }

    public void setCacount(BigDecimal cacount) {
        this.cacount = cacount;
    }
}