package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 统一请求数据 分页参数
 */
@ApiModel
public class BaseReqDto {

    @ApiModelProperty("当前页")
    private Integer pageNo; // 当前页
    @ApiModelProperty("每页大小")
    private Integer pageSize; // 每页大小
    @ApiModelProperty("表名称")
    private String tableName; // 表名称
    @ApiModelProperty("查询列")
    private String selections; // 查询列
    @ApiModelProperty("查询条件")
    private String condition; // 查询条件
    @ApiModelProperty("排序列")
    private String sortColumn; // 排序列
    @ApiModelProperty("排序类型 asc desc")
    private String sortType; // 排序类型 asc desc
    @ApiModelProperty("")
    private Integer start;
    @ApiModelProperty("总记录数")
    private Integer totalNum; // 总记录数
    @ApiModelProperty("总页码数")
    private Integer totalPage; // 总页码数
    @ApiModelProperty("当前页数据")
    private List<Object[]> datas; // 当前页数据

    private Integer pageStart;
    private Integer db;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSelections() {
        return selections;
    }

    public void setSelections(String selections) {
        this.selections = selections;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<Object[]> getDatas() {
        return datas;
    }

    public void setDatas(List<Object[]> datas) {
        this.datas = datas;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getDb() {
        return db;
    }

    public void setDb(Integer db) {
        this.db = db;
    }
}
