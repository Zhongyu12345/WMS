package com.wms.bean;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * cargo 货物表
 */
public class Cargo {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "c_id")
    private Integer cId;

	@TableField(value = "c_name")
    private String cName;

	@TableField(value = "c_storerid")
    private String cStorerid;

	@TableField(value = "c_supplierid")
    private String cSupplierid;

	@TableField(value = "c_shippingNO")
    private String cShippingno;

	@TableField(value = "c_whid")
    private String cWhid;

	@TableField(value = "c_num")
    private Integer cNum;

	private Date createdateStart;

	private Date createdateEnd;

    private List<Godown> godowns;

    /**
	 * 不要
	 */
	@TableField(value = "c_totalweight")
    private Double cTotalweight;

	@TableField(value = "c_totalvolume")
    private Double cTotalvolume;

	@TableField(value = "c_receivedate")
    private Date cReceivedate;

	@TableField(value = "c_SKUmodel")
    private String cSkumodel;

	@TableField(value = "c_phone")
    private String cPhone;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcStorerid() {
        return cStorerid;
    }

    public void setcStorerid(String cStorerid) {
        this.cStorerid = cStorerid == null ? null : cStorerid.trim();
    }

    public String getcSupplierid() {
        return cSupplierid;
    }

    public void setcSupplierid(String cSupplierid) {
        this.cSupplierid = cSupplierid == null ? null : cSupplierid.trim();
    }

    public String getcShippingno() {
        return cShippingno;
    }

    public void setcShippingno(String cShippingno) {
        this.cShippingno = cShippingno == null ? null : cShippingno.trim();
    }

    public String getcWhid() {
        return cWhid;
    }

    public void setcWhid(String cWhid) {
        this.cWhid = cWhid == null ? null : cWhid.trim();
    }

    public Integer getcNum() {
        return cNum;
    }

    public void setcNum(Integer cNum) {
        this.cNum = cNum;
    }

    public Double getcTotalweight() {
        return cTotalweight;
    }

    public void setcTotalweight(Double cTotalweight) {
        this.cTotalweight = cTotalweight;
    }

    public Double getcTotalvolume() {
        return cTotalvolume;
    }

    public void setcTotalvolume(Double cTotalvolume) {
        this.cTotalvolume = cTotalvolume;
    }

    public Date getcReceivedate() {
        return cReceivedate;
    }

    public void setcReceivedate(Date cReceivedate) {
        this.cReceivedate = cReceivedate;
    }

    public String getcSkumodel() {
        return cSkumodel;
    }

    public void setcSkumodel(String cSkumodel) {
        this.cSkumodel = cSkumodel == null ? null : cSkumodel.trim();
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

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public List<Godown> getGodowns() {
        return godowns;
    }

    public void setGodowns(List<Godown> godowns) {
        this.godowns = godowns;
    }
}