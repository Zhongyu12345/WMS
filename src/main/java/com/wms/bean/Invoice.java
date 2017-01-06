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
	
	private String store;
	
	private String phone;
	
	private int damage;
	
	private String cause;
	
	private Double totalweigh;
	/**
	 * status 0:正在确认  1:已确认
	 */
	private int status;

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

    public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Double getTotalweigh() {
		return totalweigh;
	}

	public void setTotalweigh(Double totalweigh) {
		this.totalweigh = totalweigh;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Godown> getGodowns() {
        return godowns;
    }

    public void setGodowns(List<Godown> godowns) {
        this.godowns = godowns;
    }
}