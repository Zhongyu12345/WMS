package com.wms.bean;

import java.util.List;

public class Children {
    private Long id;
    private String text;
    private String state = "open";// open,closed
    private boolean checked = false;
    private Object attributes;
    private List<Children> childrenes;
    private String iconCls;
    private String pid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public List<Children> getChildrenes() {
        return childrenes;
    }

    public void setChildrenes(List<Children> childrenes) {
        this.childrenes = childrenes;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
