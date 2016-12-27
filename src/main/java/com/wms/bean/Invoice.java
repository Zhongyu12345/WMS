package com.wms.bean;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;
import java.util.List;

/**
 * Invoice 直接发货单
 */
public class Invoice {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "in_id")
    private Integer inId;

	@TableField(value = "in_name")
    private String inName;

	@TableField(value = "in_SKUmodel")
    private String inSkumodel;

	@TableField(value = "in_num")
    private Double inNum;

	@TableField(value = "in_whid")
    private String inWhid;

	@TableField(value = "in_oddnumber")
    private String inOddnumber;

	@TableField(value = "in_time")
    private Date inTime;

	@TableField(value = "in_volume")
    private Double inVolume;

    private List<Godown> godowns;

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName == null ? null : inName.trim();
    }

    public String getInSkumodel() {
        return inSkumodel;
    }

    public void setInSkumodel(String inSkumodel) {
        this.inSkumodel = inSkumodel == null ? null : inSkumodel.trim();
    }

    public Double getInNum() {
        return inNum;
    }

    public void setInNum(Double inNum) {
        this.inNum = inNum;
    }

    public String getInWhid() {
        return inWhid;
    }

    public void setInWhid(String inWhid) {
        this.inWhid = inWhid == null ? null : inWhid.trim();
    }

    public String getInOddnumber() {
        return inOddnumber;
    }

    public void setInOddnumber(String inOddnumber) {
        this.inOddnumber = inOddnumber == null ? null : inOddnumber.trim();
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Double getInVolume() {
        return inVolume;
    }

    public void setInVolume(Double inVolume) {
        this.inVolume = inVolume;
    }

    public List<Godown> getGodowns() {
        return godowns;
    }

    public void setGodowns(List<Godown> godowns) {
        this.godowns = godowns;
    }
}