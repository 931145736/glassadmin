package com.xjt.dto;

import java.util.List;

/**
 * 系统全局参数表
 * 
 * @author wcyong
 * 
 * @date 2019-11-08
 */
public class OptionssetReqDto extends BaseReqDto {
    private String id;

    private String parentid;

    /**
     * 深度
     */
    private Integer depth;

    /**
     * 参数名
     */
    private String name;

    /**
     * 显示名称
     */
    private String caption;

    /**
     * 参数值
     */
    private String data;

    /**
     * 参数选项框类型
     */
    private String controltype;

    /**
     * 标志
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
     * 条件表达式
     */
    private String conditionexpression;

    /**
     * 条件消息
     */
    private String conditionmessage;

    /**
     * Ini配置文件Key
     */
    private String inikeyname;

    /**
     * Ini配置文件Group
     */
    private String inikeygroup;

    /**
     * Ini配置文件名称
     */
    private String inikeyfile;

    /**
     * 是否显示
     */
    private Boolean isvisible;

    /**
     * 备用
     */
    private String column17;

    /**
     * 备用
     */
    private String column18;
    /***
    *@Description 参数备选值
    * * @param null
    *@Return
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */

    private List<String> alternatives;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
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

    public Boolean getIsvisible() {
        return isvisible;
    }

    public void setIsvisible(Boolean isvisible) {
        this.isvisible = isvisible;
    }

    public String getColumn17() {
        return column17;
    }

    public void setColumn17(String column17) {
        this.column17 = column17 == null ? null : column17.trim();
    }

    public String getColumn18() {
        return column18;
    }

    public void setColumn18(String column18) {
        this.column18 = column18 == null ? null : column18.trim();
    }

    public List<String> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<String> alternatives) {
        this.alternatives = alternatives;
    }
}