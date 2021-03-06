package com.xjt.entity;

import java.math.BigDecimal;

/**
 * 该渠道可销售或调出的品牌表

 * 
 * @author wcyong
 * 
 * @date 2019-12-12
 */
public class Customerbrand {
    /**
     * 渠道编号
     */
    private String customerId;

    /**
     * 品牌
     */
    private String brand;
    /**
     * 区域
     */
    private BigDecimal carea;
    private Integer deleteFlag;

    private String brandName;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getCarea() {
        return carea;
    }

    public void setCarea(BigDecimal carea) {
        this.carea = carea;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}