package com.xjt.entity;

public class CustomeraccountsKey {
    /**
     * 银行编号
     */
    private String id;

    /**
     * 渠道编号
     */
    private String customerId;
    //户名
    private String accountName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}