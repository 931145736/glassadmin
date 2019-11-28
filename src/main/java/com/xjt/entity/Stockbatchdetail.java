package com.xjt.entity;

import java.math.BigDecimal;

/**
 * 库存明细表
 * 
 * @author wcyong
 * 
 * @date 2019-11-11
 */
public class Stockbatchdetail {
    /**
     * 自动编号
     */
    private Integer aid;

    /**
     * 库存流水码
     */
    private String stockcode;

    /**
     * 颜色、膜层代码
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

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode == null ? null : stockcode.trim();
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
}