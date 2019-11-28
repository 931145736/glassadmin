package com.xjt.entity;

/**
 * 参数选项填充列表
 * 
 * @author wcyong
 * 
 * @date 2019-11-06
 */
public class Optionscombolist  {

    /**
     * 参数名称
     */
    private String cname;

    /**
     * 显示序号
     */
    private Integer listindex;
    /**
     * 显示名称
     */
    private String listcaption;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getListindex() {
        return listindex;
    }

    public void setListindex(Integer listindex) {
        this.listindex = listindex;
    }

    public String getListcaption() {
        return listcaption;
    }

    public void setListcaption(String listcaption) {
        this.listcaption = listcaption == null ? null : listcaption.trim();
    }
}