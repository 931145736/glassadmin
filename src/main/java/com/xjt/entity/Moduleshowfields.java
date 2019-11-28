package com.xjt.entity;

/**
 * 可以显示的字段列表
 * 
 * @author wcyong
 * 
 * @date 2019-11-06
 */
public class Moduleshowfields  {
    /**
     * 模块名称
     */
    private String moduleid;

    /**
     * 字段编号
     */
    private String fieldid;

    /**
     * 字段名称
     */
    private String fieldname;
    /**
     * 排序
     */
    private Short orderindex;

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

    public String getFieldid() {
        return fieldid;
    }

    public void setFieldid(String fieldid) {
        this.fieldid = fieldid;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public Short getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Short orderindex) {
        this.orderindex = orderindex;
    }
}