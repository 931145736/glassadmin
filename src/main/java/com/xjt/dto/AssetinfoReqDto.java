package com.xjt.dto;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-15
 */
public class AssetinfoReqDto extends BaseReqDto {
    /**
     * 物资信息表主键
     */
    private String assetId;

    /**
     * 物资名称
     */
    private String assetName;

    /**
     * 库存数量
     */
    private Integer assetCount;

    /**
     * 物资规格
     */
    private String assetVersion;

    /**
     * 是否损耗品
     */
    private Integer isLoss;

    /**
     * 录入者
     */
    private String inputPerson;

    /**
     * 录入时间
     */
    private Date inputDate;

    /**
     * 备注
     */
    private String remark;

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId == null ? null : assetId.trim();
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName == null ? null : assetName.trim();
    }

    public Integer getAssetCount() {
        return assetCount;
    }

    public void setAssetCount(Integer assetCount) {
        this.assetCount = assetCount;
    }

    public String getAssetVersion() {
        return assetVersion;
    }

    public void setAssetVersion(String assetVersion) {
        this.assetVersion = assetVersion == null ? null : assetVersion.trim();
    }

    public Integer getIsLoss() {
        return isLoss;
    }

    public void setIsLoss(Integer isLoss) {
        this.isLoss = isLoss;
    }

    public String getInputPerson() {
        return inputPerson;
    }

    public void setInputPerson(String inputPerson) {
        this.inputPerson = inputPerson == null ? null : inputPerson.trim();
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}