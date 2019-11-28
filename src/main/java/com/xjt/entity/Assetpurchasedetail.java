package com.xjt.entity;

import java.math.BigDecimal;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-18
 */
public class Assetpurchasedetail {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 采购表主键
     */
    private String assetPurchaseId;

    /**
     * 物资表id
     */
    private String assetPurchaseMaterials;

    /**
     * 物资型号
     */
    private String assetPurchaseVersion;

    /**
     * 物资单价
     */
    private BigDecimal assetPurchaseUnitprice;

    /**
     * 采购数量
     */
    private Integer assetPurchaseCount;

    /**
     * 是否有效 0 否 1 是
     */
    private Integer deleteFlag;

    private String assetName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetPurchaseId() {
        return assetPurchaseId;
    }

    public void setAssetPurchaseId(String assetPurchaseId) {
        this.assetPurchaseId = assetPurchaseId == null ? null : assetPurchaseId.trim();
    }

    public String getAssetPurchaseMaterials() {
        return assetPurchaseMaterials;
    }

    public void setAssetPurchaseMaterials(String assetPurchaseMaterials) {
        this.assetPurchaseMaterials = assetPurchaseMaterials == null ? null : assetPurchaseMaterials.trim();
    }

    public String getAssetPurchaseVersion() {
        return assetPurchaseVersion;
    }

    public void setAssetPurchaseVersion(String assetPurchaseVersion) {
        this.assetPurchaseVersion = assetPurchaseVersion == null ? null : assetPurchaseVersion.trim();
    }

    public BigDecimal getAssetPurchaseUnitprice() {
        return assetPurchaseUnitprice;
    }

    public void setAssetPurchaseUnitprice(BigDecimal assetPurchaseUnitprice) {
        this.assetPurchaseUnitprice = assetPurchaseUnitprice;
    }

    public Integer getAssetPurchaseCount() {
        return assetPurchaseCount;
    }

    public void setAssetPurchaseCount(Integer assetPurchaseCount) {
        this.assetPurchaseCount = assetPurchaseCount;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
}