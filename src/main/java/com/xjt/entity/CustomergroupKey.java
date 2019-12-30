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
    private Integer deleteFlag;

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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}