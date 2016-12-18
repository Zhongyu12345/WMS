package com.wms.bean;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class CompayAccounts {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "ao_id")
    private Integer caId;

	
	
	@TableField(value = "ca_accounts")
    private Integer caAccounts;

	

	@TableField(value = "ca_name")
    private String caName;

    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public Integer getCaAccounts() {
        return caAccounts;
    }

    public void setCaAccounts(Integer caAccounts) {
        this.caAccounts = caAccounts;
    }

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName == null ? null : caName.trim();
    }
}