package com.xjt.dto;

import java.math.BigDecimal;

/**
 * @ClassNamePurchasedetailReqDto
 * @Description
 * @Author
 * @Date2019/11/7 9:07
 * @Version V1.0
 **/
public class PurchasedetailReqDto extends BaseReqDto {


    private Integer autoid;

    private String purchasegoodsid;

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
     * 单价
     */
    private BigDecimal price;

    /**
     * 折扣
     */
    private BigDecimal discount;

    public Integer getAutoid() {
        return autoid;
    }

    public void setAutoid(Integer autoid) {
        this.autoid = autoid;
    }

    public String getPurchasegoodsid() {
        return purchasegoodsid;
    }

    public void setPurchasegoodsid(String purchasegoodsid) {
        this.purchasegoodsid = purchasegoodsid;
    }

    public String getColorid() {
        return colorid;
    }

    public void setColorid(String colorid) {
        this.colorid = colorid;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
