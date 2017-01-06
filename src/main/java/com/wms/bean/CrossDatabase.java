package com.wms.bean;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;
import java.util.List;

/**
 * cross_database 越库出货单
 */
public class CrossDatabase {

	@TableId(type = IdType.AUTO)
	@TableField(value = "cd_id")
    private Integer cdId;

	@TableField(value = "cd_name")
    private String cdName;

	@TableField(value = "cd_SKUmodel")
    private String cdSkumodel;

	@TableField(value = "cd_num")
    private Double cdNum;

	@TableField(value = "cd_whid")
    private String cdWhid;

	@TableField(value = "cd_oddnumbers")
    private String cdOddnumbers;

	@TableField(value = "cd_time")
    private Date cdTime;

	@TableField(value = "cd_volume")
    private Double cdVolume;
	
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

    public Integer getCdId() {
        return cdId;
    }

    public void setCdId(Integer cdId) {
        this.cdId = cdId;
    }

    public String getCdName() {
        return cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName == null ? null : cdName.trim();
    }

    public String getCdSkumodel() {
        return cdSkumodel;
    }

    public void setCdSkumodel(String cdSkumodel) {
        this.cdSkumodel = cdSkumodel == null ? null : cdSkumodel.trim();
    }

    public Double getCdNum() {
        return cdNum;
    }

    public void setCdNum(Double cdNum) {
        this.cdNum = cdNum;
    }

    public String getCdWhid() {
        return cdWhid;
    }

    public void setCdWhid(String cdWhid) {
        this.cdWhid = cdWhid == null ? null : cdWhid.trim();
    }

    public String getCdOddnumbers() {
        return cdOddnumbers;
    }

    public void setCdOddnumbers(String cdOddnumbers) {
        this.cdOddnumbers = cdOddnumbers == null ? null : cdOddnumbers.trim();
    }

    public Date getCdTime() {
        return cdTime;
    }

    public void setCdTime(Date cdTime) {
        this.cdTime = cdTime;
    }

    public Double getCdVolume() {
        return cdVolume;
    }

    public void setCdVolume(Double cdVolume) {
        this.cdVolume = cdVolume;
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