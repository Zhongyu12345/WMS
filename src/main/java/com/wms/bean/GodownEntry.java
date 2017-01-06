package com.wms.bean;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * godown_entry入库计划单
 */
public class GodownEntry {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "g_id")
    private Integer gId;

	@TableField(value = "g_name")
    private String gName;

	@TableField(value = "g_storerid")
    private String gStorerid;

	@TableField(value = "g_phone")
    private String gPhone;

	@TableField(value = "g_supplierid")
    private String gSupplierid;

	@TableField(value = "g_sippingNO")
    private String gSippingno;

	@TableField(value = "g_whid")
    private String gWhid;

	@TableField(value = "g_num")
    private Double gNum;

	@TableField(value = "g_crossflag")
    private String gCrossflag;

	@TableField(value = "g_directflag")
    private String gDirectflag;

	@TableField(value = "g_time")
    private Date gTime;

	@TableField(value = "g_adminid")
    private Integer gAdminid;

	@TableField(value = "g_SKUmodel")
    private String gSkumodel;
	
	@TableField(value = "g_number")
    private int gNumber;
	
	@TableField(value = "g_heavy")
    private double gHeavy;
	
	private List<Godown> godowns; 
	
	private Date createdateStart;
    private Date createdateEnd;

    public int getgNumber() {
		return gNumber;
	}

	public void setgNumber(int gNumber) {
		this.gNumber = gNumber;
	}

	public double getgHeavy() {
		return gHeavy;
	}

	public void setgHeavy(double gHeavy) {
		this.gHeavy = gHeavy;
	}

	public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public String getgStorerid() {
        return gStorerid;
    }

    public void setgStorerid(String gStorerid) {
        this.gStorerid = gStorerid == null ? null : gStorerid.trim();
    }

    public String getgPhone() {
        return gPhone;
    }

    public void setgPhone(String gPhone) {
        this.gPhone = gPhone == null ? null : gPhone.trim();
    }

    public String getgSupplierid() {
        return gSupplierid;
    }

    public void setgSupplierid(String gSupplierid) {
        this.gSupplierid = gSupplierid == null ? null : gSupplierid.trim();
    }

    public String getgSippingno() {
        return gSippingno;
    }

    public void setgSippingno(String gSippingno) {
        this.gSippingno = gSippingno == null ? null : gSippingno.trim();
    }

    public String getgWhid() {
        return gWhid;
    }

    public void setgWhid(String gWhid) {
        this.gWhid = gWhid == null ? null : gWhid.trim();
    }

    public Double getgNum() {
        return gNum;
    }

    public void setgNum(Double gNum) {
        this.gNum = gNum;
    }

    @Override
	public String toString() {
		return "GodownEntry [gId=" + gId + ", gName=" + gName + ", gStorerid=" + gStorerid + ", gPhone=" + gPhone
				+ ", gSupplierid=" + gSupplierid + ", gSippingno=" + gSippingno + ", gWhid=" + gWhid + ", gNum=" + gNum
				+ ", gCrossflag=" + gCrossflag + ", gDirectflag=" + gDirectflag + ", gTime=" + gTime + ", gAdminid="
				+ gAdminid + ", gSkumodel=" + gSkumodel + ", gNumber=" + gNumber + ", gHeavy=" + gHeavy + "]";
	}

	public String getgCrossflag() {
        return gCrossflag;
    }

    public void setgCrossflag(String gCrossflag) {
        this.gCrossflag = gCrossflag == null ? null : gCrossflag.trim();
    }

    public String getgDirectflag() {
        return gDirectflag;
    }

    public void setgDirectflag(String gDirectflag) {
        this.gDirectflag = gDirectflag == null ? null : gDirectflag.trim();
    }

    public Date getgTime() {
        return gTime;
    }

    public void setgTime(Date gTime) {
        this.gTime = gTime;
    }

    public Integer getgAdminid() {
        return gAdminid;
    }

    public void setgAdminid(Integer gAdminid) {
        this.gAdminid = gAdminid;
    }

    public String getgSkumodel() {
        return gSkumodel;
    }

    public void setgSkumodel(String gSkumodel) {
        this.gSkumodel = gSkumodel == null ? null : gSkumodel.trim();
    }

	public List<Godown> getGodowns() {
		return godowns;
	}

	public void setGodowns(List<Godown> godowns) {
		this.godowns = godowns;
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
}