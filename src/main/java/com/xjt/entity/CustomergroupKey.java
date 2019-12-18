package com.xjt.entity;

public class CustomergroupKey {
    /**
     * 渠道编号
     */
    private String customerId;

    /**
     * 分组名称
     */
    private String customergroup;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getCustomergroup() {
        return customergroup;
    }

    public void setCustomergroup(String customergroup) {
        this.customergroup = customergroup == null ? null : customergroup.trim();
    }
}