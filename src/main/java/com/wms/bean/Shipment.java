package com.wms.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class Shipment {
	
	@TableId(type = IdType.AUTO)
    @TableField(value = "sh_id")
    private Integer shId;

    @TableField(value = "sh_storeid")
    private String shStoreid;
	
    @TableField(value = "sh_time")
    private Date shTime;

    @TableField(value = "sh_phone")
    private String shPhone;

    @TableField(value = "sh_sippingNO")
    private String shSippingno;

    @TableField(value = "sh_whid")
    private String shWhid;

    @TableField(value = "sh_damage")
    private Integer shDamage;

    @TableField(value = "sh_cause")
    private String shCause;

    @TableField(value = "sh_SKUmodel")
    private String shSkumodel;

    @TableField(value = "sh_shnum")
    private Double shShnum;
    
    @TableField(value = "sh_totalweigh")
    private Double shTotalweigh;

    @TableField(value = "sh_totalvolume")
    private Double shTotalvolume;

    public Integer getShId() {
        return shId;
    }

    public void setShId(Integer shId) {
        this.shId = shId;
    }

    public String getShStoreid() {
        return shStoreid;
    }

    public void setShStoreid(String shStoreid) {
        this.shStoreid = shStoreid == null ? null : shStoreid.trim();
    }

    public Date getShTime() {
        return shTime;
    }

    public void setShTime(Date shTime) {
        this.shTime = shTime;
    }

    public String getShPhone() {
        return shPhone;
    }

    public void setShPhone(String shPhone) {
        this.shPhone = shPhone == null ? null : shPhone.trim();
    }

    public String getShSippingno() {
        return shSippingno;
    }

    public void setShSippingno(String shSippingno) {
        this.shSippingno = shSippingno == null ? null : shSippingno.trim();
    }

    public String getShWhid() {
        return shWhid;
    }

    public void setShWhid(String shWhid) {
        this.shWhid = shWhid == null ? null : shWhid.trim();
    }

    public Integer getShDamage() {
        return shDamage;
    }

    public void setShDamage(Integer shDamage) {
        this.shDamage = shDamage;
    }

    public String getShCause() {
        return shCause;
    }

    public void setShCause(String shCause) {
        this.shCause = shCause == null ? null : shCause.trim();
    }

    public String getShSkumodel() {
        return shSkumodel;
    }

    public void setShSkumodel(String shSkumodel) {
        this.shSkumodel = shSkumodel == null ? null : shSkumodel.trim();
    }

    public Double getShShnum() {
        return shShnum;
    }

    public void setShShnum(Double shShnum) {
        this.shShnum = shShnum;
    }

    public Double getShTotalweigh() {
        return shTotalweigh;
    }

    public void setShTotalweigh(Double shTotalweigh) {
        this.shTotalweigh = shTotalweigh;
    }

    public Double getShTotalvolume() {
        return shTotalvolume;
    }

    public void setShTotalvolume(Double shTotalvolume) {
        this.shTotalvolume = shTotalvolume;
    }
}