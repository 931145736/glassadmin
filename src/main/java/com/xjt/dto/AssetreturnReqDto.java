package com.xjt.dto;

import com.xjt.entity.Assetreturndetail;

import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-15
 */
public class AssetreturnReqDto {
    /**
     * 归还表id
     */
    private String returnId;



    /**
     * 归还者
     */
    private String returnPerson;

    /**
     * 归还时间
     */
    private Date returnDate;

    /**
     * 是否完好 1 是 0 否
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

    private List<Assetreturndetail> assetreturndetails;

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId == null ? null : returnId.trim();
    }



    public String getReturnPerson() {
        return returnPerson;
    }

    public void setReturnPerson(String returnPerson) {
        this.returnPerson = returnPerson == null ? null : returnPerson.trim();
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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

    public List<Assetreturndetail> getAssetreturndetails() {
        return assetreturndetails;
    }

    public void setAssetreturndetails(List<Assetreturndetail> assetreturndetails) {
        this.assetreturndetails = assetreturndetails;
    }
}