package com.xjt.dto;

import java.util.Date;
import java.util.List;

/**
 * 仓库验收单
 * 
 * @author wcyong
 * 
 * @date 2019-11-07
 */
public class PureceiptReqDto extends BaseReqDto {
    /**
     * 单号  厂家来货单
     */
    private String pureceiptid;

    /**
     * 仓库
     */
    private String warehouseNo;

    /**
     * 日期
     */
    private Date receiptDate;

    /**
     * 修改日期
     */
    private Date modiDate;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 备注
     */
    private String remark;

    /**
     * 来货通知单号
     */
    private String arrivalid;

    /**
     * 单据类型1 = '厂家来货' 2 = '仓库调入' 3 = '仓库收退货'
     */
    private Short type;

    /**
     * 渠道编号type=3 时使用
     */
    private String customerId;

    /**
     * 调入仓库 type2 = '仓库调入'
     */
    private String fmwarehouseNo;

    private String deliveryid;

    /**
     * 退货通知单
     */
    private String renotitceid;

    /**
     * 退货单ID
     */
    private String dealereturnid;

    /**
     * 是否审核
     */
    private Integer posted;

    /**
     * 审核日期
     */
    private Date posteddate;

    /**
     * 审核人
     */
    private String postuser;

    /**
     * 退货类型type=3 时使用
     */
    private String returntype;

    /**
     * 供应商ID
     */
    private String supplyNo;

    /**
     * 采购单号
     */
    private String purchaseId;

    /**
     * 手工单号
     */
    private String manualId;

    /**
     * 录入日期
     */
    private Date inputDate;

    private String mode;

    private Integer waster;

    private String returnmode;

    /**
     * 是否记账
     */
    private Integer jizhang;

    /**
     * 价格类型
     */
    private String pricetype;

    /**
     * 退货地址
     */
    private String addressid;

    /**
     * 接收类型
     */
    private String receiptmode;

    private String goodstype;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 币种
     */
    private String currency;

    private String shopreturncheckid;

    /**
     * 记账人
     */
    private String jizhangoperator;

    /**
     * 记账时间
     */
    private Date jizhangdate;

    /**
     * 操作员
     */
    private String receiptsuserno;

    private List<PureceiptgoodsReqDto> pureceiptgoodsList;

    public String getPureceiptid() {
        return pureceiptid;
    }

    public void setPureceiptid(String pureceiptid) {
        this.pureceiptid = pureceiptid == null ? null : pureceiptid.trim();
    }

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo == null ? null : warehouseNo.trim();
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Date getModiDate() {
        return modiDate;
    }

    public void setModiDate(Date modiDate) {
        this.modiDate = modiDate;
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

    public String getArrivalid() {
        return arrivalid;
    }

    public void setArrivalid(String arrivalid) {
        this.arrivalid = arrivalid == null ? null : arrivalid.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getFmwarehouseNo() {
        return fmwarehouseNo;
    }

    public void setFmwarehouseNo(String fmwarehouseNo) {
        this.fmwarehouseNo = fmwarehouseNo == null ? null : fmwarehouseNo.trim();
    }

    public String getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(String deliveryid) {
        this.deliveryid = deliveryid == null ? null : deliveryid.trim();
    }

    public String getRenotitceid() {
        return renotitceid;
    }

    public void setRenotitceid(String renotitceid) {
        this.renotitceid = renotitceid == null ? null : renotitceid.trim();
    }

    public String getDealereturnid() {
        return dealereturnid;
    }

    public void setDealereturnid(String dealereturnid) {
        this.dealereturnid = dealereturnid == null ? null : dealereturnid.trim();
    }

    public Integer getPosted() {
        return posted;
    }

    public void setPosted(Integer posted) {
        this.posted = posted;
    }

    public Date getPosteddate() {
        return posteddate;
    }

    public void setPosteddate(Date posteddate) {
        this.posteddate = posteddate;
    }

    public String getPostuser() {
        return postuser;
    }

    public void setPostuser(String postuser) {
        this.postuser = postuser == null ? null : postuser.trim();
    }

    public String getReturntype() {
        return returntype;
    }

    public void setReturntype(String returntype) {
        this.returntype = returntype == null ? null : returntype.trim();
    }

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo == null ? null : supplyNo.trim();
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId == null ? null : purchaseId.trim();
    }

    public String getManualId() {
        return manualId;
    }

    public void setManualId(String manualId) {
        this.manualId = manualId == null ? null : manualId.trim();
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public Integer getWaster() {
        return waster;
    }

    public void setWaster(Integer waster) {
        this.waster = waster;
    }

    public String getReturnmode() {
        return returnmode;
    }

    public void setReturnmode(String returnmode) {
        this.returnmode = returnmode == null ? null : returnmode.trim();
    }

    public Integer getJizhang() {
        return jizhang;
    }

    public void setJizhang(Integer jizhang) {
        this.jizhang = jizhang;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype == null ? null : pricetype.trim();
    }

    public String getAddressid() {
        return addressid;
    }

    public void setAddressid(String addressid) {
        this.addressid = addressid == null ? null : addressid.trim();
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getShopreturncheckid() {
        return shopreturncheckid;
    }

    public void setShopreturncheckid(String shopreturncheckid) {
        this.shopreturncheckid = shopreturncheckid == null ? null : shopreturncheckid.trim();
    }

    public String getJizhangoperator() {
        return jizhangoperator;
    }

    public void setJizhangoperator(String jizhangoperator) {
        this.jizhangoperator = jizhangoperator == null ? null : jizhangoperator.trim();
    }

    public Date getJizhangdate() {
        return jizhangdate;
    }

    public void setJizhangdate(Date jizhangdate) {
        this.jizhangdate = jizhangdate;
    }

    public String getReceiptsuserno() {
        return receiptsuserno;
    }

    public void setReceiptsuserno(String receiptsuserno) {
        this.receiptsuserno = receiptsuserno == null ? null : receiptsuserno.trim();
    }

    public List<PureceiptgoodsReqDto> getPureceiptgoodsList() {
        return pureceiptgoodsList;
    }

    public void setPureceiptgoodsList(List<PureceiptgoodsReqDto> pureceiptgoodsList) {
        this.pureceiptgoodsList = pureceiptgoodsList;
    }
}