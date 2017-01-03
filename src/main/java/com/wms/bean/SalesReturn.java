package com.wms.bean;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * sales_return 退货入库表
 */
public class SalesReturn {
	
	@TableId(type = IdType.AUTO)
    @TableField(value = "sr_id")
    private Integer srId;

	@TableField(value = "sr_name")
    private String srName;

	@TableField(value = "sr_sipping")
    private String srSipping;

	@TableField(value = "sr_storerid")
    private String srStorerid;

	@TableField(value = "sr_phone")
    private String srPhone;

	@TableField(value = "sr_names")
    private String srNames;

	@TableField(value = "sr_SKUmodel")
    private String srSkumodel;

	@TableField(value = "sr_num")
    private Double srNum;

	@TableField(value = "sr_cause")
    private String srCause;

	@TableField(value = "sr_time")
    private Date srTime;

	@TableField(value = "sr_whid")
    private Integer srWhid;

	@TableField(value = "sr_volume")
    private Double srVolume;
	
    private Date createdateStart;
    private Date createdateEnd;
    
    private List<Godown> godowns;

    public Integer getSrId() {
        return srId;
    }

    public void setSrId(Integer srId) {
        this.srId = srId;
    }

    public String getSrName() {
        return srName;
    }

    public void setSrName(String srName) {
        this.srName = srName == null ? null : srName.trim();
    }

    public String getSrSipping() {
        return srSipping;
    }

    public void setSrSipping(String srSipping) {
        this.srSipping = srSipping == null ? null : srSipping.trim();
    }

    public String getSrStorerid() {
        return srStorerid;
    }

    public void setSrStorerid(String srStorerid) {
        this.srStorerid = srStorerid;
    }

    public String getSrPhone() {
        return srPhone;
    }

    public void setSrPhone(String srPhone) {
        this.srPhone = srPhone == null ? null : srPhone.trim();
    }

    public String getSrNames() {
        return srNames;
    }

    public void setSrNames(String srNames) {
        this.srNames = srNames == null ? null : srNames.trim();
    }

    public String getSrSkumodel() {
        return srSkumodel;
    }

    public void setSrSkumodel(String srSkumodel) {
        this.srSkumodel = srSkumodel == null ? null : srSkumodel.trim();
    }

    public Double getSrNum() {
        return srNum;
    }

    public void setSrNum(Double srNum) {
        this.srNum = srNum;
    }

    public String getSrCause() {
        return srCause;
    }

    public void setSrCause(String srCause) {
        this.srCause = srCause == null ? null : srCause.trim();
    }

    public Date getSrTime() {
        return srTime;
    }

    public void setSrTime(Date srTime) {
        this.srTime = srTime;
    }

    public Integer getSrWhid() {
        return srWhid;
    }

    public void setSrWhid(Integer srWhid) {
        this.srWhid = srWhid;
    }

    public Double getSrVolume() {
        return srVolume;
    }

    public void setSrVolume(Double srVolume) {
        this.srVolume = srVolume;
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