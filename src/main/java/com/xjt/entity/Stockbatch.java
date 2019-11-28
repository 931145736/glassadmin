package com.xjt.entity;

/**
 * 库存批次表
 * 
 * @author wcyong
 * 
 * @date 2019-11-11
 */
public class Stockbatch {
    /**
     * 流水代码
     */
    private String stockcode;

    /**
     * 仓库编码
     */
    private String warehouseNo;

    /**
     * 货号
     */
    private String goodsid;

    /**
     * 批次码
     */
    private String batchnumber;

    /**
     * 合计数量
     */
    private Integer quantity;

    /**
     * 备用
     */
    private String f2;

    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode == null ? null : stockcode.trim();
    }

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo == null ? null : warehouseNo.trim();
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public String getBatchnumber() {
        return batchnumber;
    }

    public void setBatchnumber(String batchnumber) {
        this.batchnumber = batchnumber == null ? null : batchnumber.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2 == null ? null : f2.trim();
    }
}