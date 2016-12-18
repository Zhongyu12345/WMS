package com.wms.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class Allotout {

	@TableId(type = IdType.AUTO)
	@TableField(value = "ao_id")
	private Integer aoId;

	@TableField(value = "ao_name")
	private String aoName;

	@TableField(value = "ao_SKUmodel")
	private String aoSkumodel;

	@TableField(value = "ao_num")
	private Integer aoNum;

	@TableField(value = "ao_whid")
	private String aoWhid;

	@TableField(value = "ao_sippingNO")
	private String aoSippingno;

	@TableField(value = "ao_time")
	private Date aoTime;

	@TableField(value = "ao_volume")
	private Double aoVolume;

	public Integer getAoId() {
		return aoId;
	}

	public void setAoId(Integer aoId) {
		this.aoId = aoId;
	}

	public String getAoName() {
		return aoName;
	}

	public void setAoName(String aoName) {
		this.aoName = aoName == null ? null : aoName.trim();
	}

	public String getAoSkumodel() {
		return aoSkumodel;
	}

	public void setAoSkumodel(String aoSkumodel) {
		this.aoSkumodel = aoSkumodel == null ? null : aoSkumodel.trim();
	}

	public Integer getAoNum() {
		return aoNum;
	}

	public void setAoNum(Integer aoNum) {
		this.aoNum = aoNum;
	}

	public String getAoWhid() {
		return aoWhid;
	}

	public void setAoWhid(String aoWhid) {
		this.aoWhid = aoWhid == null ? null : aoWhid.trim();
	}

	public String getAoSippingno() {
		return aoSippingno;
	}

	public void setAoSippingno(String aoSippingno) {
		this.aoSippingno = aoSippingno == null ? null : aoSippingno.trim();
	}

	public Date getAoTime() {
		return aoTime;
	}

	public void setAoTime(Date aoTime) {
		this.aoTime = aoTime;
	}

	public Double getAoVolume() {
		return aoVolume;
	}

	public void setAoVolume(Double aoVolume) {
		this.aoVolume = aoVolume;
	}
}