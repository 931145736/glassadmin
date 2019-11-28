package com.xjt.dto;

/**
 * @ClassNameChanneloptionsReqDto
 * @Description
 * @Author
 * @Date2019/11/5 9:53
 * @Version V1.0
 **/
public class ChanneloptionsReqDto extends BaseReqDto {

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
        this.optiontype = optiontype;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdata() {
        return cdata;
    }

    public void setCdata(String cdata) {
        this.cdata = cdata;
    }
}
