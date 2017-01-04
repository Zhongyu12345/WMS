package com.wms.bean;

import java.util.List;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * godown 仓库表
 */
public class Godown {
	
	@TableId(type = IdType.AUTO)
	@TableField(value = "go_id")
    private Integer goId;

	@TableField(value = "go_whid")
    private String goWhid;

	@TableField(value = "go_p")
    private String goP;

	@TableField(value = "go_volume")
    private Double goVolume;

	@TableField(value = "go_usevolume")
    private Double goUsevolume;

	@TableField(value = "go_rdvolume")
    private Double goRdvolume;
	
	/**
	 * gostatus仓库状态
	 * 0:正常
	 * 1:停用
	 * 2:已满
	 */
	private int gostatus;
	
	private List<User> userList;

    public int getGostatus() {
		return gostatus;
	}

	public void setGostatus(int gostatus) {
		this.gostatus = gostatus;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Integer getGoId() {
        return goId;
    }

    public void setGoId(Integer goId) {
        this.goId = goId;
    }

    public String getGoWhid() {
        return goWhid;
    }

    public void setGoWhid(String goWhid) {
        this.goWhid = goWhid == null ? null : goWhid.trim();
    }

    public String getGoP() {
        return goP;
    }

    public void setGoP(String goP) {
        this.goP = goP == null ? null : goP.trim();
    }

    public Double getGoVolume() {
        return goVolume;
    }

    public void setGoVolume(Double goVolume) {
        this.goVolume = goVolume;
    }

    public Double getGoUsevolume() {
        return goUsevolume;
    }

    public void setGoUsevolume(Double goUsevolume) {
        this.goUsevolume = goUsevolume;
    }

    public Double getGoRdvolume() {
        return goRdvolume;
    }

    public void setGoRdvolume(Double goRdvolume) {
        this.goRdvolume = goRdvolume;
    }
}