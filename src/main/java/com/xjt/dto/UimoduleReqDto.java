package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 菜单结构表
 * 
 * @author wcyong
 * 
 * @date 2019-11-08
 */
@ApiModel
public class UimoduleReqDto extends BaseReqDto {
    /**
     * 菜单id
     */
    @ApiModelProperty("菜单id")
    private String id;

    /**
     * 父菜单id
     */
    @ApiModelProperty("父菜单id")
    private String parentid;
    private String path;

    private Integer depth;

    /**
     * 菜单编号
     */
    @ApiModelProperty("菜单编号")
    private String moduleid;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String modulename;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 是否显示
     */
    @ApiModelProperty("是否显示")
    private Boolean isvisible;

    /**
     * 是否模块
     */
    @ApiModelProperty("是否模块")
    private Boolean ismoduel;

    /**
     * 提示
     */
    @ApiModelProperty("提示")
    private String tooltip;

    /**
     * 文件名称
     */
    @ApiModelProperty("文件名称")
    private String filename;

    /**
     * 文件路径
     */
    @ApiModelProperty("文件路径")
    private String fullfilename;

    /**
     * 参数
     */
    @ApiModelProperty("参数")
    private String parameter;

    /**
     * 图标Key
     */
    @ApiModelProperty("图标Key")
    private String imagekey;

    /**
     * 备用
     */
    private String column1;

    /***
    *@Description 可以查看的菜单id
    * * @param null
    *@Return
    *@Author Administrator
    *@Date 2019/11/8
    *@Time
    */
    @ApiModelProperty("可以查看的菜单id")
    private List<String> ids;

    private List<String> parentIds;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Boolean getIsvisible() {
        return isvisible;
    }

    public void setIsvisible(Boolean isvisible) {
        this.isvisible = isvisible;
    }

    public Boolean getIsmoduel() {
        return ismoduel;
    }

    public void setIsmoduel(Boolean ismoduel) {
        this.ismoduel = ismoduel;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip == null ? null : tooltip.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFullfilename() {
        return fullfilename;
    }

    public void setFullfilename(String fullfilename) {
        this.fullfilename = fullfilename == null ? null : fullfilename.trim();
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    public String getImagekey() {
        return imagekey;
    }

    public void setImagekey(String imagekey) {
        this.imagekey = imagekey == null ? null : imagekey.trim();
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1 == null ? null : column1.trim();
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getParentIds() {
        return parentIds;
    }

    public void setParentIds(List<String> parentIds) {
        this.parentIds = parentIds;
    }
}