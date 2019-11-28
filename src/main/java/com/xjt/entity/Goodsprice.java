package com.xjt.entity;

import java.math.BigDecimal;

/**
 * 货品价格
 * 
 * @author wcyong
 * 
 * @date 2019-11-01
 */
public class Goodsprice {
    /**
     * 对应价格表ID
     */
    private String idx;

    /**
     * 零售价
     */
    private BigDecimal unitprice;

    /**
     * 附加价
     */
    private BigDecimal attachprice;

    /**
     * 价格1
     */
    private BigDecimal price1;

    /**
     * 价格2
     */
    private BigDecimal price2;

    /**
     * 价格3
     */
    private BigDecimal price3;

    /**
     * 价格4
     */
    private BigDecimal price4;

    /**
     * 价格5
     */
    private BigDecimal price5;

    /**
     * 价格6
     */
    private BigDecimal price6;

    /**
     * 价格7
     */
    private BigDecimal price7;

    /**
     * 价格8
     */
    private BigDecimal price8;

    /**
     * 价格9
     */
    private BigDecimal price9;

    /**
     * 价格10
     */
    private BigDecimal price10;

    /**
     * 进货价
     */
    private BigDecimal wholesaleprice;

    /**
     * 货品ID
     */
    private String goodsid;

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx == null ? null : idx.trim();
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public BigDecimal getAttachprice() {
        return attachprice;
    }

    public void setAttachprice(BigDecimal attachprice) {
        this.attachprice = attachprice;
    }

    public BigDecimal getPrice1() {
        return price1;
    }

    public void setPrice1(BigDecimal price1) {
        this.price1 = price1;
    }

    public BigDecimal getPrice2() {
        return price2;
    }

    public void setPrice2(BigDecimal price2) {
        this.price2 = price2;
    }

    public BigDecimal getPrice3() {
        return price3;
    }

    public void setPrice3(BigDecimal price3) {
        this.price3 = price3;
    }

    public BigDecimal getPrice4() {
        return price4;
    }

    public void setPrice4(BigDecimal price4) {
        this.price4 = price4;
    }

    public BigDecimal getPrice5() {
        return price5;
    }

    public void setPrice5(BigDecimal price5) {
        this.price5 = price5;
    }

    public BigDecimal getPrice6() {
        return price6;
    }

    public void setPrice6(BigDecimal price6) {
        this.price6 = price6;
    }

    public BigDecimal getPrice7() {
        return price7;
    }

    public void setPrice7(BigDecimal price7) {
        this.price7 = price7;
    }

    public BigDecimal getPrice8() {
        return price8;
    }

    public void setPrice8(BigDecimal price8) {
        this.price8 = price8;
    }

    public BigDecimal getPrice9() {
        return price9;
    }

    public void setPrice9(BigDecimal price9) {
        this.price9 = price9;
    }

    public BigDecimal getPrice10() {
        return price10;
    }

    public void setPrice10(BigDecimal price10) {
        this.price10 = price10;
    }

    public BigDecimal getWholesaleprice() {
        return wholesaleprice;
    }

    public void setWholesaleprice(BigDecimal wholesaleprice) {
        this.wholesaleprice = wholesaleprice;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }
}