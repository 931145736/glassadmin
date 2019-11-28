package com.xjt.entity;

/**
 * 渠道参数设置选项集合表
 * 
 * @author wcyong
 * 
 * @date 2019-11-05
 */
public class Channeloptionsset {
    /**
     * 参数ID
     */
    private String primaryid;

    /**
     * 参数类型
     */
    private String optiontype;

    /**
     * 上级参数ID
     */
    private Integer parentid;

    /**
     * 深度
     */
    private Short depth;

    /**
     * 参数名称
     */
    private String cname;

    /**
     * 显示名称
     */
    private String caption;

    /**
     * 参数值
     */
    private String cdata;

    /**
     * 组件类型
     */
    private String controltype;

    /**
     * 暂无
     */
    private String tag;

    /**
     * 描述
     */
    private String description;

    /**
     * 数据类型
     */
    private String datatype;

    /**
     * 暂无
     */
    private String conditionexpression;

    /**
     * 暂无
     */
    private String conditionmessage;

    /**
     * 暂无
     */
    private String inikeyname;

    /**
     * 暂无
     */
    private String inikeygroup;

    /**
     * 暂无
     */
    private String inikeyfile;

    /**
     * 是否显示
     */
    private Integer isvisible;

    /**
     * 暂无
     */
    private byte[] softexplain;

    private Integer id;

    public String getPrimaryid() {
        return primaryid;
    }

    public void setPrimaryid(String primaryid) {
        this.primaryid = primaryid == null ? null : primaryid.trim();
    }

    public String getOptiontype() {
        return optiontype;
    }

    public void setOptiontype(String optiontype) {
        this.optiontype = optiontype == null ? null : optiontype.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Short getDepth() {
        return depth;
    }

    public void setDepth(Short depth) {
        this.depth = depth;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    public String getCdata() {
        return cdata;
    }

    public void setCdata(String cdata) {
        this.cdata = cdata == null ? null : cdata.trim();
    }

    public String getControltype() {
        return controltype;
    }

    public void setControltype(String controltype) {
        this.controltype = controltype == null ? null : controltype.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype == null ? null : datatype.trim();
    }

    public String getConditionexpression() {
        return conditionexpression;
    }

    public void setConditionexpression(String conditionexpression) {
        this.conditionexpression = conditionexpression == null ? null : conditionexpression.trim();
    }

    public String getConditionmessage() {
        return conditionmessage;
    }

    public void setConditionmessage(String conditionmessage) {
        this.conditionmessage = conditionmessage == null ? null : conditionmessage.trim();
    }

    public String getInikeyname() {
        return inikeyname;
    }

    public void setInikeyname(String inikeyname) {
        this.inikeyname = inikeyname == null ? null : inikeyname.trim();
    }

    public String getInikeygroup() {
        return inikeygroup;
    }

    public void setInikeygroup(String inikeygroup) {
        this.inikeygroup = inikeygroup == null ? null : inikeygroup.trim();
    }

    public String getInikeyfile() {
        return inikeyfile;
    }

    public void setInikeyfile(String inikeyfile) {
        this.inikeyfile = inikeyfile == null ? null : inikeyfile.trim();
    }

    public Integer getIsvisible() {
        return isvisible;
    }

    public void setIsvisible(Integer isvisible) {
        this.isvisible = isvisible;
    }

    public byte[] getSoftexplain() {
        return softexplain;
    }

    public void setSoftexplain(byte[] softexplain) {
        this.softexplain = softexplain;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}