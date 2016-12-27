package com.wms.bean;

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
    private Integer pid;

    private String pcause;

    private Date ptime;

    private String pabout;

    private Long pcount;

    private Long ppay;

    private Long punexpense;

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

    public Long getPcount() {
        return pcount;
    }

    public void setPcount(Long pcount) {
        this.pcount = pcount;
    }

    public Long getPpay() {
        return ppay;
    }

    public void setPpay(Long ppay) {
        this.ppay = ppay;
    }

    public Long getPunexpense() {
        return punexpense;
    }

    public void setPunexpense(Long punexpense) {
        this.punexpense = punexpense;
    }
}