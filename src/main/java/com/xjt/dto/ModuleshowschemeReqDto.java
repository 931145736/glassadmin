package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassNameModuleshowschemeReqDto
 * @Description
 * @Author
 * @Date2019/11/6 14:48
 * @Version V1.0
 **/
@ApiModel
public class ModuleshowschemeReqDto extends BaseReqDto {

    /**
     * 方案编号
     */
    @ApiModelProperty("schemeid")
    private String schemeid;

    /**
     * 方案名称
     */
    @ApiModelProperty("schemename")
    private String schemename;

    /**
     * 模块名称
     */
    @ApiModelProperty("moduleid")
    private String moduleid;

    /**
     * 排序
     */
    @ApiModelProperty("orderindex")
    private Short orderindex;

    /**
     * 是否默认
     */
    @ApiModelProperty("issystem")
    private Integer issystem;

    public String getSchemeid() {
        return schemeid;
    }

    public void setSchemeid(String schemeid) {
        this.schemeid = schemeid;
    }

    public String getSchemename() {
        return schemename;
    }

    public void setSchemename(String schemename) {
        this.schemename = schemename;
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

    public Short getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Short orderindex) {
        this.orderindex = orderindex;
    }

    public Integer getIssystem() {
        return issystem;
    }

    public void setIssystem(Integer issystem) {
        this.issystem = issystem;
    }
}
