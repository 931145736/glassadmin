package com.xjt.entity;

/**
 * 模块显示方案
 * 
 * @author wcyong
 * 
 * @date 2019-11-06
 */
public class Moduleshowscheme {
    /**
     * 方案编号
     */
    private String schemeid;

    /**
     * 方案名称
     */
    private String schemename;

    /**
     * 模块名称
     */
    private String moduleid;

    /**
     * 排序
     */
    private Short orderindex;

    /**
     * 是否默认
     */
    private Integer issystem;

    public String getSchemeid() {
        return schemeid;
    }

    public void setSchemeid(String schemeid) {
        this.schemeid = schemeid == null ? null : schemeid.trim();
    }

    public String getSchemename() {
        return schemename;
    }

    public void setSchemename(String schemename) {
        this.schemename = schemename == null ? null : schemename.trim();
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    public Short getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Short orderindex) {
        this.orderindex = orderindex;
    }

    public Integer getIssystem() {
        return issystem;
    }

    public void setIssystem(Integer issystem) {
        this.issystem = issystem;
    }
}