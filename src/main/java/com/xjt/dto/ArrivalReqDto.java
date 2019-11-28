package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 到货通知单
 * 
 * @author wcyong
 * 
 * @date 2019-11-07
 */
@ApiModel
public class ArrivalReqDto extends BaseReqDto {
    /**
     * 单号  采购到货通知单
     */
    @ApiModelProperty("单号  采购到货通知单")
    private String arrivalid;

    /**
     * 仓库
     */
    @ApiModelProperty("仓库")
    private String warehouseNo;

    /**
     * 日期
     */
    @ApiModelProperty("日期")
    private Date estiDate;

    /**
     * 操作员
     */
    @ApiModelProperty("操作员")
    private String operator;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 采购单ID
     */
    @ApiModelProperty("采购单ID")
    private String purchaseId;

    /**
     * 是否完成 0 否  1 是
     */
    @ApiModelProperty("是否完成 0 否  1 是")
    private Integer flag;

    /**
     * 供应商
     */
    @ApiModelProperty("供应商")
    private String supplyNo;

    /**
     * 是否审核 0 否 1 是
     */
    @ApiModelProperty("是否审核 0 否 1 是")
    private Integer posted;

    /**
     * 审核人
     */
    @ApiModelProperty("审核人")
    private String postuser;

    /**
     * 审核日期
     */
    @ApiModelProperty("审核日期")
    private Date posteddate;

    /**
     * 修改日期
     */
    @ApiModelProperty("")
    private Date modiDate;

    /**
     * 录入日期
     */
    @ApiModelProperty("录入日期 yyyy-MM-dd")
    private String inputDateStr;
    private Date inputDate;

    /**
     * 手工单号
     */
    @ApiModelProperty("手工单号")
    private String manualId;

    /**
     * 接收方式
     */
    @ApiModelProperty("接收方式")
    private String receiptmode;

    private String goodstype;

    /**
     * 渠道编号
     */
    @ApiModelProperty("渠道编号")
    private String customerId;

    /**
     * 单据类型1厂家到货通知2渠道采购到货通知
     */
    @ApiModelProperty("单据类型1厂家到货通知2渠道采购到货通知")
    private Integer ctype;

    /**
     * 暂无
     */
    private String sendware;

    /**
     * 暂无
     */
    private String prepdistributeaid;

    /**
     * 暂无
     */
    private Integer distributemode;

    /**
     * 暂无
     */
    private Integer boxflag;

    /**
     * 暂无
     */
    private Integer cpFlag;

    /**
     * 暂无
     */
    private Date preassigngoodsDate;

    /**
     * 暂无
     */
    private Integer buildboxflag;

    /**
     * 暂无
     */
    private String deliveryid;

    private List<ArrivalgoodsReqDto> arrivalgoodsList;

    public String getArrivalid() {
        return arrivalid;
    }

    public void setArrivalid(String arrivalid) {
        this.arrivalid = arrivalid == null ? null : arrivalid.trim();
    }

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo == null ? null : warehouseNo.trim();
    }

    public Date getEstiDate() {
        return estiDate;
    }

    public void setEstiDate(Date estiDate) {
        this.estiDate = estiDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId == null ? null : purchaseId.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo == null ? null : supplyNo.trim();
    }

    public Integer getPosted() {
        return posted;
    }

    public void setPosted(Integer posted) {
        this.posted = posted;
    }

    public String getPostuser() {
        return postuser;
    }

    public void setPostuser(String postuser) {
        this.postuser = postuser == null ? null : postuser.trim();
    }

    public Date getPosteddate() {
        return posteddate;
    }

    public void setPosteddate(Date posteddate) {
        this.posteddate = posteddate;
    }

    public Date getModiDate() {
        return modiDate;
    }

    public void setModiDate(Date modiDate) {
        this.modiDate = modiDate;
    }

    public String getInputDateStr() {
        return inputDateStr;
    }

    public void setInputDateStr(String inputDateStr) {
        this.inputDateStr = inputDateStr;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getManualId() {
        return manualId;
    }

    public void setManualId(String manualId) {
        this.manualId = manualId == null ? null : manualId.trim();
    }

    public String getReceiptmode() {
        return receiptmode;
    }

    public void setReceiptmode(String receiptmode) {
        this.receiptmode = receiptmode == null ? null : receiptmode.trim();
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype == null ? null : goodstype.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public String getSendware() {
        return sendware;
    }

    public void setSendware(String sendware) {
        this.sendware = sendware == null ? null : sendware.trim();
    }

    public String getPrepdistributeaid() {
        return prepdistributeaid;
    }

    public void setPrepdistributeaid(String prepdistributeaid) {
        this.prepdistributeaid = prepdistributeaid == null ? null : prepdistributeaid.trim();
    }

    public Integer getDistributemode() {
        return distributemode;
    }

    public void setDistributemode(Integer distributemode) {
        this.distributemode = distributemode;
    }

    public Integer getBoxflag() {
        return boxflag;
    }

    public void setBoxflag(Integer boxflag) {
        this.boxflag = boxflag;
    }

    public Integer getCpFlag() {
        return cpFlag;
    }

    public void setCpFlag(Integer cpFlag) {
        this.cpFlag = cpFlag;
    }

    public Date getPreassigngoodsDate() {
        return preassigngoodsDate;
    }

    public void setPreassigngoodsDate(Date preassigngoodsDate) {
        this.preassigngoodsDate = preassigngoodsDate;
    }

    public Integer getBuildboxflag() {
        return buildboxflag;
    }

    public void setBuildboxflag(Integer buildboxflag) {
        this.buildboxflag = buildboxflag;
    }

    public String getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(String deliveryid) {
        this.deliveryid = deliveryid == null ? null : deliveryid.trim();
    }

    public List<ArrivalgoodsReqDto> getArrivalgoodsList() {
        return arrivalgoodsList;
    }

    public void setArrivalgoodsList(List<ArrivalgoodsReqDto> arrivalgoodsList) {
        this.arrivalgoodsList = arrivalgoodsList;
    }
}