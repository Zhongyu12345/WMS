package com.wms.bean.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wms.bean.Role;
import com.wms.bean.User;
import com.wms.commons.utils.JsonUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String loginName;

    private String name;

    @JsonIgnore
    private String password;

    private Integer sex;

    private Integer age;

    private Integer userType;

    private Integer status;

    private Date createTime;

    private String phone;

    private List<Role> rolesList;

    private String roleIds;

    private Date outtime;

    private Date createdateStart;
    private Date createdateEnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public List<Role> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Role> rolesList) {
        this.rolesList = rolesList;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
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

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    /**
     * 比较vo和数据库中的用户是否同一个user，采用id比较
     *
     * @param user 用户
     * @return 是否同一个人
     */
    public boolean equalsUser(User user) {
        if (user == null) {
            return false;
        }
        Long userId = user.getId();
        if (id == null || userId == null) {
            return false;
        }
        return id.equals(userId);
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}