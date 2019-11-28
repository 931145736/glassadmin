package com.xjt.dto;

import com.xjt.entity.Assetapplydetail;

import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-15
 */
public class AssetapplyReqDto extends BaseReqDto{
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
    /***
    *@Description 申请的物资信息
    * * @param null
    *@Return
    *@Author Administrator
    *@Date 2019/11/18
    *@Time
    */
    private List<Assetapplydetail> assetapplydetails;

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

    public List<Assetapplydetail> getAssetapplydetails() {
        return assetapplydetails;
    }

    public void setAssetapplydetails(List<Assetapplydetail> assetapplydetails) {
        this.assetapplydetails = assetapplydetails;
    }
}