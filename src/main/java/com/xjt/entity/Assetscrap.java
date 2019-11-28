package com.xjt.entity;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-15
 */
public class Assetscrap {
    /**
     * 报废表id
     */
    private String scrapId;

    /**
     * 报废物资id（管理物资表主键）
     */
    private String scrapAsset;

    /**
     * 报废者类型 1 仓库，2 门店，3 个人
     */
    private Integer scrapType;

    /**
     * 报废者id
     */
    private String scrapPerson;

    /**
     * 报废数量
     */
    private Integer scrapCount;

    /**
     * 报废时间
     */
    private Date scrapDate;

    /**
     * 是否同意报废 1 是 0 否
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

    public String getScrapId() {
        return scrapId;
    }

    public void setScrapId(String scrapId) {
        this.scrapId = scrapId == null ? null : scrapId.trim();
    }

    public String getScrapAsset() {
        return scrapAsset;
    }

    public void setScrapAsset(String scrapAsset) {
        this.scrapAsset = scrapAsset == null ? null : scrapAsset.trim();
    }

    public Integer getScrapType() {
        return scrapType;
    }

    public void setScrapType(Integer scrapType) {
        this.scrapType = scrapType;
    }

    public String getScrapPerson() {
        return scrapPerson;
    }

    public void setScrapPerson(String scrapPerson) {
        this.scrapPerson = scrapPerson == null ? null : scrapPerson.trim();
    }

    public Integer getScrapCount() {
        return scrapCount;
    }

    public void setScrapCount(Integer scrapCount) {
        this.scrapCount = scrapCount;
    }

    public Date getScrapDate() {
        return scrapDate;
    }

    public void setScrapDate(Date scrapDate) {
        this.scrapDate = scrapDate;
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
}