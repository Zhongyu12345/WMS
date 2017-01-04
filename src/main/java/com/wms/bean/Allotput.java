package com.wms.bean;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * allotput 调拨入库表
 */
public class Allotput {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "ap_id")
    private Integer apId;

	@TableField(value = "ap_name")
    private String apName;

	@TableField(value = "ap_SKUmodel")
    private String apSkumodel;

	@TableField(value = "ap_num")
    private Double apNum;

	@TableField(value = "ap_whid")
    private String apWhid;

	@TableField(value = "ap_sipping")
    private String apSipping;

	@TableField(value = "ap_time")
    private Date apTime;

	@TableField(value = "ap_volume")
    private Double apVolume;

	@TableField(value = "ap_address")
    private String apAddress;
	
    private Date createdateStart;
    private Date createdateEnd;
    
    private List<Godown> godowns;

    public Integer getApId() {
        return apId;
    }

    public void setApId(Integer apId) {
        this.apId = apId;
    }

    public String getApName() {
        return apName;
    }

    public void setApName(String apName) {
        this.apName = apName == null ? null : apName.trim();
    }

    public String getApSkumodel() {
        return apSkumodel;
    }

    public void setApSkumodel(String apSkumodel) {
        this.apSkumodel = apSkumodel == null ? null : apSkumodel.trim();
    }

    public Double getApNum() {
        return apNum;
    }

    public void setApNum(Double apNum) {
        this.apNum = apNum;
    }

    public String getApWhid() {
        return apWhid;
    }

    public void setApWhid(String apWhid) {
        this.apWhid = apWhid == null ? null : apWhid.trim();
    }

    public String getApSipping() {
        return apSipping;
    }

    public void setApSipping(String apSipping) {
        this.apSipping = apSipping == null ? null : apSipping.trim();
    }

    public Date getApTime() {
        return apTime;
    }

    public void setApTime(Date apTime) {
        this.apTime = apTime;
    }

    public Double getApVolume() {
        return apVolume;
    }

    public void setApVolume(Double apVolume) {
        this.apVolume = apVolume;
    }

    public String getApAddress() {
        return apAddress;
    }

    public void setApAddress(String apAddress) {
        this.apAddress = apAddress == null ? null : apAddress.trim();
    }

	public Date getCreatedateStart() {
		return createdateStart;
	}

	public void setCreatedateStart(Date createdateStart) {
		this.createdateStart = createdateStart;
	}

	public Date getCreatedateEnd() {
		return createdateEnd;
	}

	public void setCreatedateEnd(Date createdateEnd) {
		this.createdateEnd = createdateEnd;
	}

	public List<Godown> getGodowns() {
		return godowns;
	}

	public void setGodowns(List<Godown> godowns) {
		this.godowns = godowns;
	}
}