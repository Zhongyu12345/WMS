package com.wms.bean;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * 价目表
 * @author Li
 *
 */
public class Tariff {
	
	@TableId(type = IdType.AUTO)
	private int id;
	
	private String cause;//收费原因
	
	private int scope;//收费范围
	
	private BigDecimal money;//收费金额
	
	private String unit;//收费单位

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
