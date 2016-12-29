package com.wms.bean;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;
import java.util.List;

/**
 * allotout 调拨出库单
 */
public class Allotout {

    @TableId(type = IdType.AUTO)
    @TableField(value = "ao_id")
    private Integer aoId;

    //货物名称
    @TableField(value = "ao_name")
    private String aoName;

    //货物型号
    @TableField(value = "ao_SKUmodel")
    private String aoSkumodel;

    //调拨数量
    @TableField(value = "ao_num")
    private Integer aoNum;

    //仓库编号
    @TableField(value = "ao_whid")
    private String aoWhid;

    //调拨单号
    @TableField(value = "ao_sippingNO")
    private String aoSippingno;

    //调拨时间
    @TableField(value = "ao_time")
    private Date aoTime;

    //货物体积
    @TableField(value = "ao_volume")
    private Double aoVolume;

    private List<Godown> godowns;

    public Integer getAoId() {
        return aoId;
    }

    public void setAoId(Integer aoId) {
        this.aoId = aoId;
    }

    public String getAoName() {
        return aoName;
    }

    public void setAoName(String aoName) {
        this.aoName = aoName == null ? null : aoName.trim();
    }

    public String getAoSkumodel() {
        return aoSkumodel;
    }

    public void setAoSkumodel(String aoSkumodel) {
        this.aoSkumodel = aoSkumodel == null ? null : aoSkumodel.trim();
    }

    public Integer getAoNum() {
        return aoNum;
    }

    public void setAoNum(Integer aoNum) {
        this.aoNum = aoNum;
    }

    public String getAoWhid() {
        return aoWhid;
    }

    public void setAoWhid(String aoWhid) {
        this.aoWhid = aoWhid == null ? null : aoWhid.trim();
    }

    public String getAoSippingno() {
        return aoSippingno;
    }

    public void setAoSippingno(String aoSippingno) {
        this.aoSippingno = aoSippingno == null ? null : aoSippingno.trim();
    }

    public Date getAoTime() {
        return aoTime;
    }

    public void setAoTime(Date aoTime) {
        this.aoTime = aoTime;
    }

    public Double getAoVolume() {
        return aoVolume;
    }

    public void setAoVolume(Double aoVolume) {
        this.aoVolume = aoVolume;
    }

    public List<Godown> getGodowns() {
        return godowns;
    }

    public void setGodowns(List<Godown> godowns) {
        this.godowns = godowns;
    }

    @Override
    public String toString() {
        return "Allotout{" +
                "aoId=" + aoId +
                ", aoName='" + aoName + '\'' +
                ", aoSkumodel='" + aoSkumodel + '\'' +
                ", aoNum=" + aoNum +
                ", aoWhid='" + aoWhid + '\'' +
                ", aoSippingno='" + aoSippingno + '\'' +
                ", aoTime=" + aoTime +
                ", aoVolume=" + aoVolume +
                ", godowns=" + godowns +
                '}';
    }
}