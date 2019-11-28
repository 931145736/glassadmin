package com.xjt.entity;

/**
 * 渠道参数设置表
 * 
 * @author wcyong
 * 
 * @date 2019-11-05
 */
public class Channeloptions  {
	  /**
     * 参数类型
     */
    private String optiontype;

    /**
     * 渠道ID
     */
    private String channelId;

    /**
     * 参数名称
     */
    private String cname;
    /**
     * 参数值
     */
    private String cdata;


    public String getOptiontype() {
        return optiontype;
    }

    public void setOptiontype(String optiontype) {
        this.optiontype = optiontype == null ? null : optiontype.trim();
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCdata() {
        return cdata;
    }

    public void setCdata(String cdata) {
        this.cdata = cdata == null ? null : cdata.trim();
    }
}