package com.wms.bean;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * 
 * 公告栏
 *
 */
public class Notice {
	
	@TableId(type = IdType.AUTO)
	private int nid;
	private String text;//公告内容
	private int userid;//发布人
	private Date ntime;//发布时间
	private int nstatus;//发布状态

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getNtime() {
		return ntime;
	}

	public void setNtime(Date ntime) {
		this.ntime = ntime;
	}

	public int getNstatus() {
		return nstatus;
	}

	public void setNstatus(int nstatus) {
		this.nstatus = nstatus;
	}

}
