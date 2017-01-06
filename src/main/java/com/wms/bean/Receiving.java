package com.wms.bean;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * receiving 实际入库表
 */
public class Receiving {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "r_id")
    private Integer rId;

	@TableField(value = "r_name")
    private String rName;

	@TableField(value = "r_storerid")
    private String rStorerid;

	@TableField(value = "r_phone")
    private String rPhone;

	@TableField(value = "r_supplierid")
    private String rSupplierid;

	@TableField(value = "r_sippingNO")
    private String rSippingno;

	@TableField(value = "r_whid")
    private String rWhid;

	@Override
	public String toString() {
		return "Receiving [rId=" + rId + ", rName=" + rName + ", rStorerid=" + rStorerid + ", rPhone=" + rPhone
				+ ", rSupplierid=" + rSupplierid + ", rSippingno=" + rSippingno + ", rWhid=" + rWhid + ", rNum=" + rNum
				+ ", rCrossflag=" + rCrossflag + ", rDirectflag=" + rDirectflag + ", rTime=" + rTime + ", rAdminid="
				+ rAdminid + ", rPartflag=" + rPartflag + ", rSkumodel=" + rSkumodel + ", rNumber=" + rNumber
				+ ", rHeavy=" + rHeavy + ", godowns=" + godowns + ", users=" + users + ", adminname=" + adminname
				+ ", createdateStart=" + createdateStart + ", createdateEnd=" + createdateEnd + "]";
	}

	@TableField(value = "r_num")
    private Double rNum;

	@TableField(value = "r_crossflag")
    private String rCrossflag;

	@TableField(value = "r_directflag")
    private String rDirectflag;

	@TableField(value = "r_time")
    private Date rTime;

	@TableField(value = "r_adminid")
    private Integer rAdminid;

	@TableField(value = "r_partflag")
    private Integer rPartflag;

	@TableField(value = "r_SKUmodel")
    private String rSkumodel;
	
	@TableField(value = "r_number")
    private int rNumber;
	
	@TableField(value = "r_heavy")
    private double rHeavy;
	private List<Godown> godowns;
	
	private List<User> users;
	
	private String adminname;
	
    public int getrNumber() {
		return rNumber;
	}

	public void setrNumber(int rNumber) {
		this.rNumber = rNumber;
	}

	public double getrHeavy() {
		return rHeavy;
	}

	public void setrHeavy(double rHeavy) {
		this.rHeavy = rHeavy;
	}

	private Date createdateStart;
    private Date createdateEnd;
	
    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrStorerid() {
        return rStorerid;
    }

    public void setrStorerid(String rStorerid) {
        this.rStorerid = rStorerid == null ? null : rStorerid.trim();
    }

    public String getrPhone() {
        return rPhone;
    }

    public void setrPhone(String rPhone) {
        this.rPhone = rPhone == null ? null : rPhone.trim();
    }

    public String getrSupplierid() {
        return rSupplierid;
    }

    public void setrSupplierid(String rSupplierid) {
        this.rSupplierid = rSupplierid == null ? null : rSupplierid.trim();
    }

    public String getrSippingno() {
        return rSippingno;
    }

    public void setrSippingno(String rSippingno) {
        this.rSippingno = rSippingno == null ? null : rSippingno.trim();
    }

    public String getrWhid() {
        return rWhid;
    }

    public void setrWhid(String rWhid) {
        this.rWhid = rWhid == null ? null : rWhid.trim();
    }

    public Double getrNum() {
        return rNum;
    }

    public void setrNum(Double rNum) {
        this.rNum = rNum;
    }

    public String getrCrossflag() {
        return rCrossflag;
    }

    public void setrCrossflag(String rCrossflag) {
        this.rCrossflag = rCrossflag == null ? null : rCrossflag.trim();
    }

    public String getrDirectflag() {
        return rDirectflag;
    }

    public void setrDirectflag(String rDirectflag) {
        this.rDirectflag = rDirectflag == null ? null : rDirectflag.trim();
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public Integer getrAdminid() {
        return rAdminid;
    }

    public void setrAdminid(Integer rAdminid) {
        this.rAdminid = rAdminid;
    }

    public Integer getrPartflag() {
        return rPartflag;
    }

    public void setrPartflag(Integer rPartflag) {
        this.rPartflag = rPartflag;
    }

    public String getrSkumodel() {
        return rSkumodel;
    }

    public void setrSkumodel(String rSkumodel) {
        this.rSkumodel = rSkumodel == null ? null : rSkumodel.trim();
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}



}