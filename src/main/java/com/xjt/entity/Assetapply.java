package com.xjt.entity;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-15
 */
public class Assetapply {
    /**
     * 物资申领表主键
     */
    private String applyId;


    /**
     * 申领者类型 1 门店，2 仓库，3 个人
     */
    private Integer applyType;

    /**
     * 申领人
     */
    private String applyPerson;

    /**
     * 申领时间
     */
    private Date applyDate;

    /**
     * 是否同意 1 是 0 否
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
    private String assetName;
    private String assetVersion;
    private Integer assetApplyCount;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }



    public Integer getApplyType() {
        return applyType;
    }

    public void setApplyType(Integer applyType) {
        this.applyType = applyType;
    }

    public String getApplyPerson() {
        return applyPerson;
    }

    public void setApplyPerson(String applyPerson) {
        this.applyPerson = applyPerson == null ? null : applyPerson.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetVersion() {
        return assetVersion;
    }

    public void setAssetVersion(String assetVersion) {
        this.assetVersion = assetVersion;
    }

    public Integer getAssetApplyCount() {
        return assetApplyCount;
    }

    public void setAssetApplyCount(Integer assetApplyCount) {
        this.assetApplyCount = assetApplyCount;
    }
}