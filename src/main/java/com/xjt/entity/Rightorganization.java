package com.xjt.entity;

import java.math.BigDecimal;

/**
 * 组织架构表
 * 
 * @author wcyong
 * 
 * @date 2019-11-06
 */
public class Rightorganization {
    /**
     * 机构编号（GUID）
     */
    private String id;

    /**
     * 上级编号
     */
    private String parentid;

    /**
     * 级数
     */
    private Integer depth;

    /**
     * 机构名称
     */
    private String organization;

    /**
     * 排序
     */
    private BigDecimal orderindex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public BigDecimal getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(BigDecimal orderindex) {
        this.orderindex = orderindex;
    }
}