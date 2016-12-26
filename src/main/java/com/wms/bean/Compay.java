package com.wms.bean;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;

public class Compay {
	@TableId(type = IdType.AUTO)
    private Integer caid;

    private String caaccounts;

    private String caname;

    private Long camoney;

    private Long cacount;

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

    public Long getCamoney() {
        return camoney;
    }

    public void setCamoney(Long camoney) {
        this.camoney = camoney;
    }

    public Long getCacount() {
        return cacount;
    }

    public void setCacount(Long cacount) {
        this.cacount = cacount;
    }
}