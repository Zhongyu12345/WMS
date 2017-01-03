package com.wms.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * make_inventory物料盘点表
 */
public class MakeInventory {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "mi_id")
    private Integer miId;

	@TableField(value = "mi_name")
    private String miName;

	@TableField(value = "mi_SKUmodel")
    private String miSkumodel;

	@TableField(value = "mi_num")
    private Double miNum;

	@TableField(value = "mi_Actual")
	private Double miActual;

	@TableField(value = "mi_names")
    private String miNames;

	@TableField(value = "mi_whid")
    private String miWhid;

	@TableField(value = "mi_time")
    private Date miTime;

	private Date createState;

	private Date createEnd;

	public MakeInventory(Integer miId,String miName,String miWhid,Double miNum,String miNames,String miSkumodel,Date miTime){
	    this.miId = miId;
	    this.miName = miName;
	    this.miWhid = miWhid;
	    this.miNum = miNum;
        this.miNames = miNames;
	    this.miSkumodel = miSkumodel;
	    this.miTime = miTime;
    }

    public MakeInventory(){}

    public Date getCreateState() {
        return createState;
    }

    public void setCreateState(Date createState) {
        this.createState = createState;
    }

    public Date getCreateEnd() {
        return createEnd;
    }

    public void setCreateEnd(Date createEnd) {
        this.createEnd = createEnd;
    }

    public Integer getMiId() {
        return miId;
    }

    public void setMiId(Integer miId) {
        this.miId = miId;
    }

    public String getMiName() {
        return miName;
    }

    public void setMiName(String miName) {
        this.miName = miName == null ? null : miName.trim();
    }

    public String getMiSkumodel() {
        return miSkumodel;
    }

    public void setMiSkumodel(String miSkumodel) {
        this.miSkumodel = miSkumodel == null ? null : miSkumodel.trim();
    }

    public Double getMiNum() {
        return miNum;
    }

    public void setMiNum(Double miNum) {
        this.miNum = miNum;
    }

    public String getMiNames() {
        return miNames;
    }

    public void setMiNames(String miNames) {
        this.miNames = miNames == null ? null : miNames.trim();
    }

    public String getMiWhid() {
        return miWhid;
    }

    public void setMiWhid(String miWhid) {
        this.miWhid = miWhid;
    }

    public Date getMiTime() {
        return miTime;
    }

    public void setMiTime(Date miTime) {
        this.miTime = miTime;
    }

    public Double getMiActual() {
        return miActual;
    }

    public void setMiActual(Double miActual) {
        this.miActual = miActual;
    }
}