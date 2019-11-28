package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 到货通知货号
 * 
 * @author wcyong
 * 
 * @date 2019-11-12
 */
@ApiModel
public class ArrivalgoodsReqDto {
    private String arrivalgoodsid;

    /**
     * 到货通知单号
     */
    @ApiModelProperty("到货通知单号")
    private String arrivalid;

    /**
     * 货号
     */
    @ApiModelProperty("货号")
    private String goodsNo;

    /**
     * 等级
     */
    @ApiModelProperty("等级")
    private String grade;

    /**
     * 批次码
     */
    @ApiModelProperty("批次码")
    private String batchnumber;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Boolean quantity;

    /**
     * 折扣
     */
    @ApiModelProperty("折扣")
    private BigDecimal discount;

    /**
     * 金额
     */
    @ApiModelProperty("金额")
    private BigDecimal amount;

    /**
     * 渠道编号
     */
    @ApiModelProperty("渠道编号")
    private String customerId;

    /**
     * 生产日期
     */
    private Date manudate;
    @ApiModelProperty("生产日期")
    private String manudateStr;

    /**
     * 有效期限
     */
    @ApiModelProperty("有效期限")
    private Integer expirydate;

    /**
     * 灭菌批号
     */
    @ApiModelProperty("灭菌批号")
    private String sterilizenumber;

    /**
     * 灭菌日期
     */
    private Date sterilizedate;
    @ApiModelProperty("灭菌日期")
    private String sterilizedateStr;

    /**
     * 外观状态
     */
    @ApiModelProperty("外观状态")
    private String appearance;

    /**
     * 暂无
     */
    private String cexplain;

    /**
     * 暂无
     */
    private Boolean cartonflag;

    private List<ArrivaldetailReqDto> arrivaldetailReqDtoList;

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

    public String getManudateStr() {
        return manudateStr;
    }

    public void setManudateStr(String manudateStr) {
        this.manudateStr = manudateStr;
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

    public String getSterilizedateStr() {
        return sterilizedateStr;
    }

    public void setSterilizedateStr(String sterilizedateStr) {
        this.sterilizedateStr = sterilizedateStr;
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

    public List<ArrivaldetailReqDto> getArrivaldetailReqDtoList() {
        return arrivaldetailReqDtoList;
    }

    public void setArrivaldetailReqDtoList(List<ArrivaldetailReqDto> arrivaldetailReqDtoList) {
        this.arrivaldetailReqDtoList = arrivaldetailReqDtoList;
    }
}