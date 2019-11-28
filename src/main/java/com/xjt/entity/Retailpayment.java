package com.xjt.entity;

import java.math.BigDecimal;

/**
 * 零售付款表
 * 
 * @author wcyong
 * 
 * @date 2019-11-05
 */
public class Retailpayment  {
	 /**
     * 编号
     */
    private String paymentid;

    /**
     * 说明
     */
    private String paymentname;

    /**
     * 默认
     */
    private Integer setdefault;


    /**
     * 是否找零
     */
    private Integer returnchange;

    /**
     * 汇率
     */
    private BigDecimal exchangerate;

    /**
     * 手续费
     */
    private BigDecimal handlingcharge;

    /**
     * 不积分
     */
    private Integer nointegral;

    /**
     * 不计收入
     */
    private Integer notincome;

    /**
     * 不参与促销
     */
    private Integer nospromo;

    /**
     * 代用券
     */
    private Integer istokencoil;

    /**
     * 是否抵减金额
     */
    private Integer isnotcalincome;

    /**
     * 是否抵减积分
     */
    private Integer isaddvalue;

    private Integer isintegral;

    private Integer isrestoredpprice;

    private Integer bankcard;

    private Integer issubscriptioncf;

    private Integer paymentplatformid;

    private Integer notincludebalanceprice;

    /**
     * 排序
     */
    private Integer sortid;

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getPaymentname() {
        return paymentname;
    }

    public void setPaymentname(String paymentname) {
        this.paymentname = paymentname;
    }

    public Integer getSetdefault() {
        return setdefault;
    }

    public void setSetdefault(Integer setdefault) {
        this.setdefault = setdefault;
    }

    public Integer getReturnchange() {
        return returnchange;
    }

    public void setReturnchange(Integer returnchange) {
        this.returnchange = returnchange;
    }

    public BigDecimal getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(BigDecimal exchangerate) {
        this.exchangerate = exchangerate;
    }

    public BigDecimal getHandlingcharge() {
        return handlingcharge;
    }

    public void setHandlingcharge(BigDecimal handlingcharge) {
        this.handlingcharge = handlingcharge;
    }

    public Integer getNointegral() {
        return nointegral;
    }

    public void setNointegral(Integer nointegral) {
        this.nointegral = nointegral;
    }

    public Integer getNotincome() {
        return notincome;
    }

    public void setNotincome(Integer notincome) {
        this.notincome = notincome;
    }

    public Integer getNospromo() {
        return nospromo;
    }

    public void setNospromo(Integer nospromo) {
        this.nospromo = nospromo;
    }

    public Integer getIstokencoil() {
        return istokencoil;
    }

    public void setIstokencoil(Integer istokencoil) {
        this.istokencoil = istokencoil;
    }

    public Integer getIsnotcalincome() {
        return isnotcalincome;
    }

    public void setIsnotcalincome(Integer isnotcalincome) {
        this.isnotcalincome = isnotcalincome;
    }

    public Integer getIsaddvalue() {
        return isaddvalue;
    }

    public void setIsaddvalue(Integer isaddvalue) {
        this.isaddvalue = isaddvalue;
    }

    public Integer getIsintegral() {
        return isintegral;
    }

    public void setIsintegral(Integer isintegral) {
        this.isintegral = isintegral;
    }

    public Integer getIsrestoredpprice() {
        return isrestoredpprice;
    }

    public void setIsrestoredpprice(Integer isrestoredpprice) {
        this.isrestoredpprice = isrestoredpprice;
    }

    public Integer getBankcard() {
        return bankcard;
    }

    public void setBankcard(Integer bankcard) {
        this.bankcard = bankcard;
    }

    public Integer getIssubscriptioncf() {
        return issubscriptioncf;
    }

    public void setIssubscriptioncf(Integer issubscriptioncf) {
        this.issubscriptioncf = issubscriptioncf;
    }

    public Integer getPaymentplatformid() {
        return paymentplatformid;
    }

    public void setPaymentplatformid(Integer paymentplatformid) {
        this.paymentplatformid = paymentplatformid;
    }

    public Integer getNotincludebalanceprice() {
        return notincludebalanceprice;
    }

    public void setNotincludebalanceprice(Integer notincludebalanceprice) {
        this.notincludebalanceprice = notincludebalanceprice;
    }

    public Integer getSortid() {
        return sortid;
    }

    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }
}