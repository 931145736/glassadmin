package com.xjt.dto;

import java.math.BigDecimal;

/**
 * 厂家来货明细单
 * 
 * @author wcyong
 * 
 * @date 2019-11-07
 */
public class PureceiptdetailReqDto extends BaseReqDto {
    /**
     * 厂家来货明细表
     */
    private Integer autoid;

    private String pureceiptgoodsid;

    /**
     * 颜色
     */
    private String colorid;

    /**
     * 曲光度
     */
    private BigDecimal dioptre;

    /**
     * 散光度
     */
    private BigDecimal astigmia;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 价格
     */
    private BigDecimal unitprice;

    /**
     * 结算价
     */
    private BigDecimal balanceprice;

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 不含税价
     */
    private BigDecimal nottaxprice;

    /**
     * 税率
     */
    private BigDecimal taxrate;

    /**
     * 成本价type=2时使用
     */
    private BigDecimal costprice;

    /**
     * 公司成本价
     */
    private BigDecimal companycostprice;

    /**
     * 调出方价格
     */
    private BigDecimal loadoutprice;

    /**
     * 调出方折扣
     */
    private BigDecimal loadoutdiscount;

    public Integer getAutoid() {
        return autoid;
    }

    public void setAutoid(Integer autoid) {
        this.autoid = autoid;
    }

    public String getPureceiptgoodsid() {
        return pureceiptgoodsid;
    }

    public void setPureceiptgoodsid(String pureceiptgoodsid) {
        this.pureceiptgoodsid = pureceiptgoodsid == null ? null : pureceiptgoodsid.trim();
    }

    public String getColorid() {
        return colorid;
    }

    public void setColorid(String colorid) {
        this.colorid = colorid == null ? null : colorid.trim();
    }

    public BigDecimal getDioptre() {
        return dioptre;
    }

    public void setDioptre(BigDecimal dioptre) {
        this.dioptre = dioptre;
    }

    public BigDecimal getAstigmia() {
        return astigmia;
    }

    public void setAstigmia(BigDecimal astigmia) {
        this.astigmia = astigmia;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public BigDecimal getBalanceprice() {
        return balanceprice;
    }

    public void setBalanceprice(BigDecimal balanceprice) {
        this.balanceprice = balanceprice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getNottaxprice() {
        return nottaxprice;
    }

    public void setNottaxprice(BigDecimal nottaxprice) {
        this.nottaxprice = nottaxprice;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }

    public BigDecimal getCompanycostprice() {
        return companycostprice;
    }

    public void setCompanycostprice(BigDecimal companycostprice) {
        this.companycostprice = companycostprice;
    }

    public BigDecimal getLoadoutprice() {
        return loadoutprice;
    }

    public void setLoadoutprice(BigDecimal loadoutprice) {
        this.loadoutprice = loadoutprice;
    }

    public BigDecimal getLoadoutdiscount() {
        return loadoutdiscount;
    }

    public void setLoadoutdiscount(BigDecimal loadoutdiscount) {
        this.loadoutdiscount = loadoutdiscount;
    }
}