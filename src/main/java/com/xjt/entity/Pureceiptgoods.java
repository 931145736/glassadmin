package com.xjt.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 厂家来货货品单
 * 
 * @author wcyong
 * 
 * @date 2019-11-07
 */
public class Pureceiptgoods {
    /**
     * 厂家来货货品表
     */
    private String pureceiptgoodsid;

    /**
     * 单号
     */
    private String pureceiptid;

    /**
     * 货号
     */
    private String goodsNo;

    /**
     * 等级
     */
    private String grade;

    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 批次码
     */
    private String batchnumber;

    /**
     * 生产日期
     */
    private Date manudate;

    /**
     * 有效期至
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

    private String marketgoodsNo;

    /**
     * 说明描述
     */
    private String cexplain;



    private String explain;

    private BigDecimal materialprice;

    private BigDecimal currencyprice;

    private BigDecimal lowerbalanceprice;

    private BigDecimal foldonfold;

    private BigDecimal buisnottax;

    private BigDecimal realbalance;

    private BigDecimal realbalancenottax;

    public String getPureceiptgoodsid() {
        return pureceiptgoodsid;
    }

    public void setPureceiptgoodsid(String pureceiptgoodsid) {
        this.pureceiptgoodsid = pureceiptgoodsid == null ? null : pureceiptgoodsid.trim();
    }

    public String getPureceiptid() {
        return pureceiptid;
    }

    public void setPureceiptid(String pureceiptid) {
        this.pureceiptid = pureceiptid == null ? null : pureceiptid.trim();
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMarketgoodsNo() {
        return marketgoodsNo;
    }

    public void setMarketgoodsNo(String marketgoodsNo) {
        this.marketgoodsNo = marketgoodsNo == null ? null : marketgoodsNo.trim();
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

    public BigDecimal getMaterialprice() {
        return materialprice;
    }

    public void setMaterialprice(BigDecimal materialprice) {
        this.materialprice = materialprice;
    }

    public BigDecimal getCurrencyprice() {
        return currencyprice;
    }

    public void setCurrencyprice(BigDecimal currencyprice) {
        this.currencyprice = currencyprice;
    }

    public BigDecimal getLowerbalanceprice() {
        return lowerbalanceprice;
    }

    public void setLowerbalanceprice(BigDecimal lowerbalanceprice) {
        this.lowerbalanceprice = lowerbalanceprice;
    }

    public BigDecimal getFoldonfold() {
        return foldonfold;
    }

    public void setFoldonfold(BigDecimal foldonfold) {
        this.foldonfold = foldonfold;
    }

    public BigDecimal getBuisnottax() {
        return buisnottax;
    }

    public void setBuisnottax(BigDecimal buisnottax) {
        this.buisnottax = buisnottax;
    }

    public BigDecimal getRealbalance() {
        return realbalance;
    }

    public void setRealbalance(BigDecimal realbalance) {
        this.realbalance = realbalance;
    }

    public BigDecimal getRealbalancenottax() {
        return realbalancenottax;
    }

    public void setRealbalancenottax(BigDecimal realbalancenottax) {
        this.realbalancenottax = realbalancenottax;
    }

    public String getBatchnumber() {
        return batchnumber;
    }

    public void setBatchnumber(String batchnumber) {
        this.batchnumber = batchnumber;
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
        this.sterilizenumber = sterilizenumber;
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
        this.appearance = appearance;
    }

    public String getCexplain() {
        return cexplain;
    }

    public void setCexplain(String cexplain) {
        this.cexplain = cexplain;
    }
}