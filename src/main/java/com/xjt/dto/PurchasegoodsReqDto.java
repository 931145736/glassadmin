package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassNamePurchasegoodsReqDto
 * @Description
 * @Author
 * @Date2019/11/7 9:07
 * @Version V1.0
 **/
@ApiModel
public class PurchasegoodsReqDto extends BaseReqDto {

    /**
     *  采购单 货品表
     */
    private String purchasegoodsid;

    /**
     * 采购单号
     */
    private String purchaseId;

    /**
     * 货号
     */
    private String goodsNo;

    /**
     * 仓库
     */
    private String warehouseNo;

    /**
     * 发货日期
     */
    @ApiModelProperty("发货日期 yyyy-MM-dd")
    private String deliverDateStr;
    private Date deliverDate;


    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 税率
     */
    private BigDecimal taxrate;

    /**
     * 批次号
     */
    private String batchnumber;

    /**
     * 生产日期
     */
    private Date manuDate;

    /**
     * 有效期至
     */
    private Date expiryDate;

    private BigDecimal materialprice;

    private BigDecimal currencyprice;

    /***
    *@Description 一个货品会有多个明细
    * * @param
    *@Return java.lang.String
    *@Author Administrator
    *@Date 2019/11/7
    *@Time
    */
    private List<PurchasedetailReqDto> purchasedetailList;

    public String getPurchasegoodsid() {
        return purchasegoodsid;
    }

    public void setPurchasegoodsid(String purchasegoodsid) {
        this.purchasegoodsid = purchasegoodsid;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public String getDeliverDateStr() {
        return deliverDateStr;
    }

    public void setDeliverDateStr(String deliverDateStr) {
        this.deliverDateStr = deliverDateStr;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public String getBatchnumber() {
        return batchnumber;
    }

    public void setBatchnumber(String batchnumber) {
        this.batchnumber = batchnumber;
    }

    public Date getManuDate() {
        return manuDate;
    }

    public void setManuDate(Date manuDate) {
        this.manuDate = manuDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
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

    public List<PurchasedetailReqDto> getPurchasedetailList() {
        return purchasedetailList;
    }

    public void setPurchasedetailList(List<PurchasedetailReqDto> purchasedetailList) {
        this.purchasedetailList = purchasedetailList;
    }
}
