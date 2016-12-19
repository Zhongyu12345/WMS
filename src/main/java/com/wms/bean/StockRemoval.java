package com.wms.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * stock_removal出库计划单表
 */
public class StockRemoval {
	
	@TableId(type = IdType.AUTO)
    @TableField(value = "s_id")
    private Integer sId;

	@TableField(value = "s_storerid")
    private String sStorerid;

	@TableField(value = "s_time")
    private Date sTime;

	@TableField(value = "s_phone")
    private String sPhone;

	@TableField(value = "sh_sippingNO")
    private String shSippingno;

	@TableField(value = "s_whid")
    private String sWhid;

	@TableField(value = "s_client")
    private String sClient;

	@TableField(value = "s_SKUmodel")
    private String sSkumodel;

	@TableField(value = "s_name")
    private String sName;

	@TableField(value = "s_num")
    private Double sNum;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsStorerid() {
        return sStorerid;
    }

    public void setsStorerid(String sStorerid) {
        this.sStorerid = sStorerid == null ? null : sStorerid.trim();
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone == null ? null : sPhone.trim();
    }

    public String getShSippingno() {
        return shSippingno;
    }

    public void setShSippingno(String shSippingno) {
        this.shSippingno = shSippingno == null ? null : shSippingno.trim();
    }

    public String getsWhid() {
        return sWhid;
    }

    public void setsWhid(String sWhid) {
        this.sWhid = sWhid == null ? null : sWhid.trim();
    }

    public String getsClient() {
        return sClient;
    }

    public void setsClient(String sClient) {
        this.sClient = sClient == null ? null : sClient.trim();
    }

    public String getsSkumodel() {
        return sSkumodel;
    }

    public void setsSkumodel(String sSkumodel) {
        this.sSkumodel = sSkumodel == null ? null : sSkumodel.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Double getsNum() {
        return sNum;
    }

    public void setsNum(Double sNum) {
        this.sNum = sNum;
    }
}