package com.xjt.entity;

/**
 * 供应商发货地址
 * 
 * @author wcyong
 * 
 * @date 2019-11-06
 */
public class Supplyaddress {
    /**
     * 供应商编号
     */
    private String supplyNo;

    /**
     * 地址编号
     */
    private String addressid;
    /**
     * 地址
     */
    private String address;


    public String getSupplyNo() {
        return supplyNo;
    }


    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo;
    }


    public String getAddressid() {
        return addressid;
    }


    public void setAddressid(String addressid) {
        this.addressid = addressid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}