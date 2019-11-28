package com.xjt.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 到货通知货号
 * 
 * @author wcyong
 * 
 * @date 2019-11-12
 */
public class Arrivalgoods {
    private String arrivalgoodsid;

    /**
     * 到货通知单号
     */
    private String arrivalid;

    /**
     * 货号
     */
    private String goodsNo;

    /**
     * 等级
     */
    private String grade;

    /**
     * 批次码
     */
    private String batchnumber;

    /**
     * 数量
     */
    private Boolean quantity;

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 渠道编号
     */
    private String customerId;

    /**
     * 生产日期
     */
    private Date manudate;

    /**
     * 有效期限
     */
    private Integer expirydate;

    /**
     * 灭菌批号
     */
    private String sterilizenumber;

    /**
     * 灭菌日期
     */
    private Date sterilizedate;

    /**
     * 外观状态
     */
    private String appearance;

    /**
     * 暂无
     */
    private String cexplain;

    /**
     * 暂无
     */
    private Boolean cartonflag;

    public String getArrivalgoodsid() {
        return arrivalgoodsid;
    }

    public void setArrivalgoodsid(String arrivalgoodsid) {
        this.arrivalgoodsid = arrivalgoodsid == null ? null : arrivalgoodsid.trim();
    }

    public String getArrivalid() {
        return arrivalid;
    }

    public void setArrivalid(String arrivalid) {
        this.arrivalid = arrivalid == null ? null : arrivalid.trim();
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo == null ? null : goodsNo.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getBatchnumber() {
        return batchnumber;
    }

    public void setBatchnumber(String batchnumber) {
        this.batchnumber = batchnumber == null ? null : batchnumber.trim();
    }

    public Boolean getQuantity() {
        return quantity;
    }

    public void setQuantity(Boolean quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public Date getManudate() {
        return manudate;
    }

    public void setManudate(Date manudate) {
        this.manudate = manudate;
    }

    public Integer getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Integer expirydate) {
        this.expirydate = expirydate;
    }

    public String getSterilizenumber() {
        return sterilizenumber;
    }

    public void setSterilizenumber(String sterilizenumber) {
        this.sterilizenumber = sterilizenumber == null ? null : sterilizenumber.trim();
    }

    public Date getSterilizedate() {
        return sterilizedate;
    }

    public void setSterilizedate(Date sterilizedate) {
        this.sterilizedate = sterilizedate;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance == null ? null : appearance.trim();
    }

    public String getCexplain() {
        return cexplain;
    }

    public void setCexplain(String cexplain) {
        this.cexplain = cexplain == null ? null : cexplain.trim();
    }

    public Boolean getCartonflag() {
        return cartonflag;
    }

    public void setCartonflag(Boolean cartonflag) {
        this.cartonflag = cartonflag;
    }
}