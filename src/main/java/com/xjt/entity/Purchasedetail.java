package com.xjt.entity;

import java.math.BigDecimal;

/**
 * 采购货品明细
 * 
 * @author wcyong
 * 
 * @date 2019-11-07
 */
public class Purchasedetail {
    private Integer autoid;

    private String purchasegoodsid;

    /**
     * 颜色
     */
    private String colorid;

    /**
     * 曲光度
     */
    private BigDecimal dioptre;

    /**
     * 散光度
     */
    private BigDecimal astigmia;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 折扣
     */
    private BigDecimal discount;

    public Integer getAutoid() {
        return autoid;
    }

    public void setAutoid(Integer autoid) {
        this.autoid = autoid;
    }

    public String getPurchasegoodsid() {
        return purchasegoodsid;
    }

    public void setPurchasegoodsid(String purchasegoodsid) {
        this.purchasegoodsid = purchasegoodsid == null ? null : purchasegoodsid.trim();
    }

    public String getColorid() {
        return colorid;
    }

    public void setColorid(String colorid) {
        this.colorid = colorid == null ? null : colorid.trim();
    }

    public BigDecimal getDioptre() {
        return dioptre;
    }

    public void setDioptre(BigDecimal dioptre) {
        this.dioptre = dioptre;
    }

    public BigDecimal getAstigmia() {
        return astigmia;
    }

    public void setAstigmia(BigDecimal astigmia) {
        this.astigmia = astigmia;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}