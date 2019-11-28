package com.xjt.entity;

/**
 * 颜色膜层表
 * 
 * @author wcyong
 * 
 * @date 2019-11-01
 */
public class Dictcolor {
    private Integer colorid;

    /**
     * 颜色、膜层
     */
    private String colorname;

    public Integer getColorid() {
        return colorid;
    }

    public void setColorid(Integer colorid) {
        this.colorid = colorid;
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname == null ? null : colorname.trim();
    }
}