package com.xjt.entity;

/**
 * 供应商银行资料
 * 
 * @author wcyong
 * 
 * @date 2019-11-06
 */
public class Supplyaccounts {
    /**
     * 银行编号
     */
    private String id;

    /**
     * 编号
     */
    private String supplyNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo == null ? null : supplyNo.trim();
    }
}