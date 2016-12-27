package com.wms.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * give_back 货品归还表
 */
public class GiveBack {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "gb_id")
    private Integer gbId;

	@TableField(value = "gb_name")
    private String gbName;

	@TableField(value = "gb_SKUmodel")
    private String gbSkumodel;

	@TableField(value = "gb_num")
    private Double gbNum;

	@TableField(value = "gb_cause")
    private String gbCause;

	@TableField(value = "gb_status")
    private Integer gbStatus;

	@TableField(value = "gb_time")
    private Date gbTime;

    private Date createdateStart;

    private Date createdateEnd;

    public Integer getGbId() {
        return gbId;
    }

    public void setGbId(Integer gbId) {
        this.gbId = gbId;
    }

    public String getGbName() {
        return gbName;
    }

    public void setGbName(String gbName) {
        this.gbName = gbName == null ? null : gbName.trim();
    }

    public String getGbSkumodel() {
        return gbSkumodel;
    }

    public void setGbSkumodel(String gbSkumodel) {
        this.gbSkumodel = gbSkumodel == null ? null : gbSkumodel.trim();
    }

    public Double getGbNum() {
        return gbNum;
    }

    public void setGbNum(Double gbNum) {
        this.gbNum = gbNum;
    }

    public String getGbCause() {
        return gbCause;
    }

    public void setGbCause(String gbCause) {
        this.gbCause = gbCause == null ? null : gbCause.trim();
    }

    public Integer getGbStatus() {
        return gbStatus;
    }

    public void setGbStatus(Integer gbStatus) {
        this.gbStatus = gbStatus;
    }

    public Date getGbTime() {
        return gbTime;
    }

    public void setGbTime(Date gbTime) {
        this.gbTime = gbTime;
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