package com.xjt.entity;

import com.xjt.dto.BaseReqDto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassNameOrderEntity  统一订单实体
 * @Description
 * @Author
 * @Date2019/11/12 15:12
 * @Version V1.0
 **/
public class OrderEntity extends BaseReqDto {

    private String orderId;//订单id
    private String supplyName;//供货商名称
    private Integer quantity; //数量
    private BigDecimal amount; //金额
    private String goodsNo; //货号
    private String goodsName; //货品名称
    private String warehouseName; //仓库名称
    private Date orderDate; //订单日期
    private BigDecimal astigmia; // 屈光度
    private BigDecimal dioptre; //散光度
    private BigDecimal discount; //折扣
    private BigDecimal price; //单价
    private String colorName; //货品颜色
    /**
     * 是否审核 0 否 1 是
     */
    private Integer posted;

    /**
     * 审核人
     */
    private String postUser;

    /**
     * 审核日期
     */
    private Date postedDate;
    /**
     * 输入日期
     */
    private Date inputDate;
    /***
    *@Description 单据类型
    * * @param null
    *@Return
    *@Author Administrator
    *@Date 2019/11/13
    *@Time
    */
    private Integer orderType;

    private Date productDate;//生产日期
    private Integer validityDaies;//有效期限
    private String batchNumber;//批次号

    private String manualId;//手工单号
    private String startTime; //开始时间
    private String endTime;//结束时间

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
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



    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getAstigmia() {
        return astigmia;
    }

    public void setAstigmia(BigDecimal astigmia) {
        this.astigmia = astigmia;
    }

    public BigDecimal getDioptre() {
        return dioptre;
    }

    public void setDioptre(BigDecimal dioptre) {
        this.dioptre = dioptre;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getPosted() {
        return posted;
    }

    public void setPosted(Integer posted) {
        this.posted = posted;
    }

    public String getPostUser() {
        return postUser;
    }

    public void setPostUser(String postUser) {
        this.postUser = postUser;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public Integer getValidityDaies() {
        return validityDaies;
    }

    public void setValidityDaies(Integer validityDaies) {
        this.validityDaies = validityDaies;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getManualId() {
        return manualId;
    }

    public void setManualId(String manualId) {
        this.manualId = manualId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
