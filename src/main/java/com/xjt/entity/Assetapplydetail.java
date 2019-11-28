package com.xjt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-18
 */
public class Assetapplydetail {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 物资申领表id
     */
    private String assetApplyId;

    /**
     * 物资id
     */
    private String assetApplyMaterials;

    /**
     * 申领的数量
     */
    private Integer assetApplyCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetApplyId() {
        return assetApplyId;
    }

    public void setAssetApplyId(String assetApplyId) {
        this.assetApplyId = assetApplyId == null ? null : assetApplyId.trim();
    }

    public String getAssetApplyMaterials() {
        return assetApplyMaterials;
    }

    public void setAssetApplyMaterials(String assetApplyMaterials) {
        this.assetApplyMaterials = assetApplyMaterials == null ? null : assetApplyMaterials.trim();
    }

    public Integer getAssetApplyCount() {
        return assetApplyCount;
    }

    public void setAssetApplyCount(Integer assetApplyCount) {
        this.assetApplyCount = assetApplyCount;
    }
}