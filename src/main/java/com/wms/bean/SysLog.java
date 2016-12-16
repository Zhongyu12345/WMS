package com.wms.bean;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.wms.commons.utils.JsonUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志
 */
@TableName("sys_log")
public class SysLog implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 登陆名
     */
    @TableField(value = "login_name")
    private String loginName;

    /**
     * 角色名
     */
    @TableField(value = "role_name")
    private String roleName;

    /**
     * 内容
     */
    @TableField(value = "opt_content")
    private String optContent;

    /**
     * 客户端ip
     */
    @TableField(value = "client_ip")
    private String clientIp;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOptContent() {
        return this.optContent;
    }

    public void setOptContent(String optContent) {
        this.optContent = optContent;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
