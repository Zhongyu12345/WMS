package com.wms.bean;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * 
 * 公告栏
 *
 */
public class Notice {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "nid")
	private int nid;
	@TableField(value = "text")
	private String text;//公告内容
	@TableField(value = "userid")
	private int userid;//发布人
	@TableField(value = "ntime")
	private Date ntime;//发布时间
	@TableField(value = "nstatus")
	private int nstatus;//发布状态

	private String username;

	private List<User> users;

	private String stringtime;



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {

		this.users = users;
	}


	public String getStringtime() {
		return stringtime;
	}

	public void setStringtime(String stringtime) {
		this.stringtime = stringtime;
	}

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
