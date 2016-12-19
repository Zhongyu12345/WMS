package com.wms.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * income 收/入财务表
 */
public class Income {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "i_id")
    private Integer iId;

	@TableField(value = "i_income")
    private Long iIncome;

	@TableField(value = "i_pay")
    private Long iPay;

	@TableField(value = "i_time")
    private Date iTime;

	@TableField(value = "i_caid")
    private Integer iCaid;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public Long getiIncome() {
        return iIncome;
    }

    public void setiIncome(Long iIncome) {
        this.iIncome = iIncome;
    }

    public Long getiPay() {
        return iPay;
    }

    public void setiPay(Long iPay) {
        this.iPay = iPay;
    }

    public Date getiTime() {
        return iTime;
    }

    public void setiTime(Date iTime) {
        this.iTime = iTime;
    }

    public Integer getiCaid() {
        return iCaid;
    }

    public void setiCaid(Integer iCaid) {
        this.iCaid = iCaid;
    }
}