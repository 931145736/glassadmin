package com.xjt.dto;

import java.util.Date;
import java.util.List;

/**
 * @ClassNamePurchaseReqDto
 * @Description
 * @Author
 * @Date2019/11/7 9:05
 * @Version V1.0
 **/
public class PurchaseReqDto extends BaseReqDto {

    /**
     * 采购单号
     */
    private String purchaseId;

    /**
     * 供应商编号
     */
    private String supplyNo;

    /**
     * 采购日期
     */
    private Date purchDate;

    private String purchDateStr;

    /**
     * 修改日期
     */
    private Date modiDate;

    /**
     * 是否完成
     */
    private Integer flag;

    /**
     * 手工单号
     */
    private String manualId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 是否审核 0 否 1 是
     */
    private Integer posted;

    /**
     * 审核人
     */
    private String postuser;

    /**
     * 审核日期
     */
    private Date posteddate;

    /**
     * 输入日期
     */
    private Date inputDate;

    /**
     * 性质
     */
    private String kind;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 冲减单生成标志
     */
    private String mode;

    /**
     * 币种
     */
    private String currency;

    /**
     * 是否记账 0 否 1 是
     */
    private Integer jizhang;

    /**
     * 记账人
     */
    private String jizhangoperator;

    /**
     * 记账时间
     */
    private Date jizhangdate;

    /**
     * 单据生成时间
     */
    private Date inputTime;

    /**
     * 暂无
     */
    private String masterplanid;

    /**
     * 暂无
     */
    private Integer wareoutplanflag;

    /**
     * 暂无
     */
    private String year;

    /**
     * 暂无
     */
    private String waverange;

    /**
     * 暂无
     */
    private Integer isagentpurchase;

    /**
     * 暂无
     */
    private String agentcustomerno;

    /**
     * 暂无
     */
    private String pricetype;

    /**
     * 暂无
     */
    private Integer msendFlag;

    /**
     * 暂无
     */
    private Integer postedpurchaseprocess;

    /**
     * 暂无
     */
    private Integer processposted;

    /**
     * 暂无
     */
    private Date processposteddate;

    /**
     * 暂无
     */
    private String processpostuser;

    /**
     * 暂无
     */
    private Integer goodsdate;

    /**
     * 暂无
     */
    private Integer cpFlag;

    /**
     * 暂无
     */
    private Integer buildboxflag;

    /**、
     * 采购单对应的多个货品
     * @return
     */
    private List<PurchasegoodsReqDto> purchasegoodsList;

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo;
    }

    public Date getPurchDate() {
        return purchDate;
    }

    public void setPurchDate(Date purchDate) {
        this.purchDate = purchDate;
    }

    public String getPurchDateStr() {
        return purchDateStr;
    }

    public void setPurchDateStr(String purchDateStr) {
        this.purchDateStr = purchDateStr;
    }

    public Date getModiDate() {
        return modiDate;
    }

    public void setModiDate(Date modiDate) {
        this.modiDate = modiDate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getManualId() {
        return manualId;
    }

    public void setManualId(String manualId) {
        this.manualId = manualId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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
        this.postuser = postuser;
    }

    public Date getPosteddate() {
        return posteddate;
    }

    public void setPosteddate(Date posteddate) {
        this.posteddate = posteddate;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getJizhang() {
        return jizhang;
    }

    public void setJizhang(Integer jizhang) {
        this.jizhang = jizhang;
    }

    public String getJizhangoperator() {
        return jizhangoperator;
    }

    public void setJizhangoperator(String jizhangoperator) {
        this.jizhangoperator = jizhangoperator;
    }

    public Date getJizhangdate() {
        return jizhangdate;
    }

    public void setJizhangdate(Date jizhangdate) {
        this.jizhangdate = jizhangdate;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public String getMasterplanid() {
        return masterplanid;
    }

    public void setMasterplanid(String masterplanid) {
        this.masterplanid = masterplanid;
    }

    public Integer getWareoutplanflag() {
        return wareoutplanflag;
    }

    public void setWareoutplanflag(Integer wareoutplanflag) {
        this.wareoutplanflag = wareoutplanflag;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWaverange() {
        return waverange;
    }

    public void setWaverange(String waverange) {
        this.waverange = waverange;
    }

    public Integer getIsagentpurchase() {
        return isagentpurchase;
    }

    public void setIsagentpurchase(Integer isagentpurchase) {
        this.isagentpurchase = isagentpurchase;
    }

    public String getAgentcustomerno() {
        return agentcustomerno;
    }

    public void setAgentcustomerno(String agentcustomerno) {
        this.agentcustomerno = agentcustomerno;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype;
    }

    public Integer getMsendFlag() {
        return msendFlag;
    }

    public void setMsendFlag(Integer msendFlag) {
        this.msendFlag = msendFlag;
    }

    public Integer getPostedpurchaseprocess() {
        return postedpurchaseprocess;
    }

    public void setPostedpurchaseprocess(Integer postedpurchaseprocess) {
        this.postedpurchaseprocess = postedpurchaseprocess;
    }

    public Integer getProcessposted() {
        return processposted;
    }

    public void setProcessposted(Integer processposted) {
        this.processposted = processposted;
    }

    public Date getProcessposteddate() {
        return processposteddate;
    }

    public void setProcessposteddate(Date processposteddate) {
        this.processposteddate = processposteddate;
    }

    public String getProcesspostuser() {
        return processpostuser;
    }

    public void setProcesspostuser(String processpostuser) {
        this.processpostuser = processpostuser;
    }

    public Integer getGoodsdate() {
        return goodsdate;
    }

    public void setGoodsdate(Integer goodsdate) {
        this.goodsdate = goodsdate;
    }

    public Integer getCpFlag() {
        return cpFlag;
    }

    public void setCpFlag(Integer cpFlag) {
        this.cpFlag = cpFlag;
    }

    public Integer getBuildboxflag() {
        return buildboxflag;
    }

    public void setBuildboxflag(Integer buildboxflag) {
        this.buildboxflag = buildboxflag;
    }

    public List<PurchasegoodsReqDto> getPurchasegoodsList() {
        return purchasegoodsList;
    }

    public void setPurchasegoodsList(List<PurchasegoodsReqDto> purchasegoodsList) {
        this.purchasegoodsList = purchasegoodsList;
    }
}
