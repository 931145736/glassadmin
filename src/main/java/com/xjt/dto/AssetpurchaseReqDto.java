package com.xjt.dto;

import com.xjt.entity.Assetpurchasedetail;

import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-15
 */
public class AssetpurchaseReqDto extends BaseReqDto {
    /**
     * 物资采购表主键
     */
    private String purchaseId;



    /**
     * 采购人
     */
    private String purchasePerson;

    /**
     * 采购时间
     */
    private Date purchaseDate;
    private String purchaseDateStr;

    /**
     * 是否已审核 1 是 0 否
     */
    private Integer isAudit;

    /**
     * 审核者
     */
    private String auditPerson;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 备注
     */
    private String remark;

    private List<Assetpurchasedetail> details;

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId == null ? null : purchaseId.trim();
    }



    public String getPurchasePerson() {
        return purchasePerson;
    }

    public void setPurchasePerson(String purchasePerson) {
        this.purchasePerson = purchasePerson == null ? null : purchasePerson.trim();
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseDateStr() {
        return purchaseDateStr;
    }

    public void setPurchaseDateStr(String purchaseDateStr) {
        this.purchaseDateStr = purchaseDateStr;
    }

    public Integer getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(Integer isAudit) {
        this.isAudit = isAudit;
    }

    public String getAuditPerson() {
        return auditPerson;
    }

    public void setAuditPerson(String auditPerson) {
        this.auditPerson = auditPerson == null ? null : auditPerson.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public List<Assetpurchasedetail> getDetails() {
        return details;
    }

    public void setDetails(List<Assetpurchasedetail> details) {
        this.details = details;
    }
}