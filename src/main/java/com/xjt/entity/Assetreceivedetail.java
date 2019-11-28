package com.xjt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-18
 */
public class Assetreceivedetail {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 物资领用表id
     */
    private String assetReceiveId;

    /**
     * 物资表id
     */
    private String assetReceiveMaterials;

    /**
     * 领用物资数量
     */
    private Integer assetReceiveCount;

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

    public String getAssetReceiveId() {
        return assetReceiveId;
    }

    public void setAssetReceiveId(String assetReceiveId) {
        this.assetReceiveId = assetReceiveId == null ? null : assetReceiveId.trim();
    }

    public String getAssetReceiveMaterials() {
        return assetReceiveMaterials;
    }

    public void setAssetReceiveMaterials(String assetReceiveMaterials) {
        this.assetReceiveMaterials = assetReceiveMaterials == null ? null : assetReceiveMaterials.trim();
    }

    public Integer getAssetReceiveCount() {
        return assetReceiveCount;
    }

    public void setAssetReceiveCount(Integer assetReceiveCount) {
        this.assetReceiveCount = assetReceiveCount;
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