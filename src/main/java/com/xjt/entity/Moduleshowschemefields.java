package com.xjt.entity;

/**
 * 显示方案引用的字段列表
 * 
 * @author wcyong
 * 
 * @date 2019-11-06
 */
public class Moduleshowschemefields {
    /**
     * 方案编号
     */
    private String schemeid;

    /**
     * 字段编号
     */
    private String fieldid;

    /**
     * 排序
     */
    private Short orderindex;

    public String getSchemeid() {
        return schemeid;
    }

    public void setSchemeid(String schemeid) {
        this.schemeid = schemeid;
    }

    public String getFieldid() {
        return fieldid;
    }

    public void setFieldid(String fieldid) {
        this.fieldid = fieldid;
    }

    public Short getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Short orderindex) {
        this.orderindex = orderindex;
    }
}