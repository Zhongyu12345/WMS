package com.wms.bean;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import java.util.List;

/**
 * adjust 调整入库/出库单
 */
public class Adjust {

    @TableId(type = IdType.AUTO)
    @TableField(value = "j_id")
    private Integer jId;

    @TableField(value = "j_name")
    private String jName;

    @TableField(value = "j_SKUmodel")
    private String jSkumodel;

    @TableField(value = "j_num")
    private Double jNum;

    @TableField(value = "j_names")
    private String jNames;

    @TableField(value = "j_cause")
    private String jCause;

    @TableField(value = "j_time")
    private Date jTime;

    @TableField(value = "j_whid")
    private String jWhid;

    @TableField(value = "j_volum")
    private Double jVolum;

    private Date createdateStart;

    private Date createdateEnd;

    private List<Godown> godowns;

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName == null ? null : jName.trim();
    }

    public String getjSkumodel() {
        return jSkumodel;
    }

    public void setjSkumodel(String jSkumodel) {
        this.jSkumodel = jSkumodel == null ? null : jSkumodel.trim();
    }

    public Double getjNum() {
        return jNum;
    }

    public void setjNum(Double jNum) {
        this.jNum = jNum;
    }

    public String getjNames() {
        return jNames;
    }

    public void setjNames(String jNames) {
        this.jNames = jNames == null ? null : jNames.trim();
    }

    public String getjCause() {
        return jCause;
    }

    public void setjCause(String jCause) {
        this.jCause = jCause == null ? null : jCause.trim();
    }

    public Date getjTime() {
        return jTime;
    }

    public void setjTime(Date jTime) {
        this.jTime = jTime;
    }

    public String getjWhid() {
        return jWhid;
    }

    public void setjWhid(String jWhid) {
        this.jWhid = jWhid == null ? null : jWhid.trim();
    }

    public Double getjVolum() {
        return jVolum;
    }

    public void setjVolum(Double jVolum) {
        this.jVolum = jVolum;
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

    public List<Godown> getGodowns() {
        return godowns;
    }

    public void setGodowns(List<Godown> godowns) {
        this.godowns = godowns;
    }
}