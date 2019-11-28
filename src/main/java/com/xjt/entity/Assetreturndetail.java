package com.xjt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-18
 */
public class Assetreturndetail {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 归还表id
     */
    private String assetReturnId;

    /**
     * 物资表id
     */
    private String assetReturnMaterials;

    /**
     * 归还数量
     */
    private Integer assetReturnCount;

    /**
     * 是否有效 0 否 1 是
     */
    private Integer deleteFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetReturnId() {
        return assetReturnId;
    }

    public void setAssetReturnId(String assetReturnId) {
        this.assetReturnId = assetReturnId == null ? null : assetReturnId.trim();
    }

    public String getAssetReturnMaterials() {
        return assetReturnMaterials;
    }

    public void setAssetReturnMaterials(String assetReturnMaterials) {
        this.assetReturnMaterials = assetReturnMaterials == null ? null : assetReturnMaterials.trim();
    }

    public Integer getAssetReturnCount() {
        return assetReturnCount;
    }

    public void setAssetReturnCount(Integer assetReturnCount) {
        this.assetReturnCount = assetReturnCount;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}