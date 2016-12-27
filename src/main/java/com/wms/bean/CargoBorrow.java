package com.wms.bean;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * cargo_borrow 货品借用表
 */
public class CargoBorrow {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "cb_id")
    private Integer cbId;

	@TableField(value = "cb_name")
    private String cbName;

	@TableField(value = "cb_SKUmodel")
    private String cbSkumodel;

	@TableField(value = "cb_num")
    private Double cbNum;

	@TableField(value = "cb_cause")
    private String cbCause;

	@TableField(value = "cb_names")
    private String cbNames;

	@TableField(value = "cb_time")
    private Date cbTime;

	@TableField(value = "cb_status")
	private String cbStatus;

	@TableField(value = "cb_Endtime")
	private Date cbEndtime;

	private Date createdateStart;

	private Date createdateEnd;

    public Integer getCbId() {
        return cbId;
    }

    public void setCbId(Integer cbId) {
        this.cbId = cbId;
    }

    public String getCbName() {
        return cbName;
    }

    public void setCbName(String cbName) {
        this.cbName = cbName == null ? null : cbName.trim();
    }

    public String getCbSkumodel() {
        return cbSkumodel;
    }

    public void setCbSkumodel(String cbSkumodel) {
        this.cbSkumodel = cbSkumodel == null ? null : cbSkumodel.trim();
    }

    public Double getCbNum() {
        return cbNum;
    }

    public void setCbNum(Double cbNum) {
        this.cbNum = cbNum;
    }

    public String getCbCause() {
        return cbCause;
    }

    public void setCbCause(String cbCause) {
        this.cbCause = cbCause == null ? null : cbCause.trim();
    }

    public String getCbNames() {
        return cbNames;
    }

    public void setCbNames(String cbNames) {
        this.cbNames = cbNames == null ? null : cbNames.trim();
    }

    public Date getCbTime() {
        return cbTime;
    }

    public void setCbTime(Date cbTime) {
        this.cbTime = cbTime;
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

    public String getCbStatus() {
        return cbStatus;
    }

    public void setCbStatus(String cbStatus) {
        this.cbStatus = cbStatus;
    }

    public Date getCbEndtime() {
        return cbEndtime;
    }

    public void setCbEndtime(Date cbEndtime) {
        this.cbEndtime = cbEndtime;
    }
}