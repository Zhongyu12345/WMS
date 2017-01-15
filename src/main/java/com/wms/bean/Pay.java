package com.wms.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * 
 * @author Li
 * 支付表
 *
 */
public class Pay {
	@TableId(type = IdType.AUTO)
    private Integer pid; //id

    private String pcause;  //原因

    private Date ptime; //时间

    private String pabout;

    private BigDecimal pcount;

    private BigDecimal ppay;  //支付金额

    private BigDecimal punexpense;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPcause() {
        return pcause;
    }

    public void setPcause(String pcause) {
        this.pcause = pcause == null ? null : pcause.trim();
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getPabout() {
        return pabout;
    }

    public void setPabout(String pabout) {
        this.pabout = pabout == null ? null : pabout.trim();
    }

    public BigDecimal getPcount() {
        return pcount;
    }

    public void setPcount(BigDecimal pcount) {
        this.pcount = pcount;
    }

    public BigDecimal getPpay() {
        return ppay;
    }

    public void setPpay(BigDecimal ppay) {
        this.ppay = ppay;
    }

    public BigDecimal getPunexpense() {
        return punexpense;
    }

    public void setPunexpense(BigDecimal punexpense) {
        this.punexpense = punexpense;
    }
}