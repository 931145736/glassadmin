package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassNameModuleshowfieldsReqDto
 * @Description
 * @Author
 * @Date2019/11/6 14:36
 * @Version V1.0
 **/
@ApiModel
public class ModuleshowfieldsReqDto extends BaseReqDto {

    /**
     * 模块名称
     */
    @ApiModelProperty("moduleid")
    private String moduleid;

    /**
     * 字段编号
     */
    @ApiModelProperty("fieldid")
    private String fieldid;

    /**
     * 字段名称
     */
    @ApiModelProperty("fieldname")
    private String fieldname;

    private List<String> filedNames;
    /**
     * 排序
     */
    @ApiModelProperty("orderindex")
    private Short orderindex;

   //字段id集合
    private List<String> fieldids;

    private List<FieldReqDto> fieldReqDtos;

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

    public String getFieldid() {
        return fieldid;
    }

    public void setFieldid(String fieldid) {
        this.fieldid = fieldid;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public List<String> getFiledNames() {
        return filedNames;
    }

    public void setFiledNames(List<String> filedNames) {
        this.filedNames = filedNames;
    }

    public Short getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Short orderindex) {
        this.orderindex = orderindex;
    }

    public List<String> getFieldids() {
        return fieldids;
    }

    public void setFieldids(List<String> fieldids) {
        this.fieldids = fieldids;
    }

    public List<FieldReqDto> getFieldReqDtos() {
        return fieldReqDtos;
    }

    public void setFieldReqDtos(List<FieldReqDto> fieldReqDtos) {
        this.fieldReqDtos = fieldReqDtos;
    }
}
