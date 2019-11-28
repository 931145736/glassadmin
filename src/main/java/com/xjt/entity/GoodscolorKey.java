package com.xjt.entity;

public class GoodscolorKey {
    /**
     * 货品ID(自动生成)
     */
    private String goodsid;

    /**
     * 颜色、膜层
     */
    private String colorid;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public String getColorid() {
        return colorid;
    }

    public void setColorid(String colorid) {
        this.colorid = colorid == null ? null : colorid.trim();
    }
}