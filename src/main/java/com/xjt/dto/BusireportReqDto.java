package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class BusireportReqDto extends BaseReqDto {

    /**
     * 请求类型 1 经营许可，2 生产许可
     */
    @ApiModelProperty("请求类型 1 经营许可，2 生产许可")
    private Integer reportType;

    /**
     * 经营企业许可、备案编号（自动生成）
     */
    @ApiModelProperty("经营企业许可、备案编号")
    private String brid;

    /**
     * 许可证编号
     */
    @ApiModelProperty("许可证编号")
    private String permitno;

    /**
     * 企业名称
     */
    @ApiModelProperty("企业名称")
    private String enterprisename;

    /**
     * 法人
     */
    @ApiModelProperty("法人")
    private String legal;

    /**
     * 负责人
     */
    @ApiModelProperty("负责人")
    private String keyman;

    /**
     * 住所
     */
    @ApiModelProperty("住所")
    private String home;

    /**
     * 经营场所
     */
    @ApiModelProperty("经营场所")
    private String premises;

    /**
     * 经营方式
     */
    @ApiModelProperty("经营方式")
    private String busitype;

    /**
     * 经营范围
     */
    @ApiModelProperty("经营范围")
    private String busiscope;

    /**
     * 库房地址
     */
    @ApiModelProperty("库房地址")
    private String warehouseaddr;

    /**
     * 发证部门
     */
    @ApiModelProperty("发证部门")
    private String issuedepartment;

    /**
     * 发证日期
     */
    private Date issuedate;
    @ApiModelProperty("发证日期")
    private String issuedateStr;

    /**
     * 有效期限
     */
    private Date expirydate;
    @ApiModelProperty("有效期限")
    private String expirydateStr;

    /**
     * 备案编号
     */
    @ApiModelProperty("备案编号")
    private String reportno;

    /**
     * 备案日期
     */
    private Date reportdate;
    @ApiModelProperty("备案日期")
    private String reportdateStr;

    /**
     * 备案部门
     */
    @ApiModelProperty("备案部门")
    private String reportdepartment;

    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private String supplyNo;

    /**
     * 扩展字段1
     */
    private String columnEx1;

    /**
     * 扩展字段2
     */
    private String columnEx2;

    /**
     * 扩展字段3
     */
    private String columnEx3;

    /**
     * 到期时间
     */
    private Date docdate;
    @ApiModelProperty("到期时间")
    private String docdateStr;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updatetimestamp;

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public String getBrid() {
        return brid;
    }

    public void setBrid(String brid) {
        this.brid = brid == null ? null : brid.trim();
    }

    public String getPermitno() {
        return permitno;
    }

    public void setPermitno(String permitno) {
        this.permitno = permitno == null ? null : permitno.trim();
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename == null ? null : enterprisename.trim();
    }

    public String getLegal() {
        return legal;
    }

    public void setLegal(String legal) {
        this.legal = legal == null ? null : legal.trim();
    }

    public String getKeyman() {
        return keyman;
    }

    public void setKeyman(String keyman) {
        this.keyman = keyman == null ? null : keyman.trim();
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home == null ? null : home.trim();
    }

    public String getPremises() {
        return premises;
    }

    public void setPremises(String premises) {
        this.premises = premises == null ? null : premises.trim();
    }

    public String getBusitype() {
        return busitype;
    }

    public void setBusitype(String busitype) {
        this.busitype = busitype == null ? null : busitype.trim();
    }

    public String getBusiscope() {
        return busiscope;
    }

    public void setBusiscope(String busiscope) {
        this.busiscope = busiscope == null ? null : busiscope.trim();
    }

    public String getWarehouseaddr() {
        return warehouseaddr;
    }

    public void setWarehouseaddr(String warehouseaddr) {
        this.warehouseaddr = warehouseaddr == null ? null : warehouseaddr.trim();
    }

    public String getIssuedepartment() {
        return issuedepartment;
    }

    public void setIssuedepartment(String issuedepartment) {
        this.issuedepartment = issuedepartment == null ? null : issuedepartment.trim();
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public String getReportno() {
        return reportno;
    }

    public void setReportno(String reportno) {
        this.reportno = reportno == null ? null : reportno.trim();
    }

    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    public String getReportdepartment() {
        return reportdepartment;
    }

    public void setReportdepartment(String reportdepartment) {
        this.reportdepartment = reportdepartment == null ? null : reportdepartment.trim();
    }

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo == null ? null : supplyNo.trim();
    }

    public String getColumnEx1() {
        return columnEx1;
    }

    public void setColumnEx1(String columnEx1) {
        this.columnEx1 = columnEx1 == null ? null : columnEx1.trim();
    }

    public String getColumnEx2() {
        return columnEx2;
    }

    public void setColumnEx2(String columnEx2) {
        this.columnEx2 = columnEx2 == null ? null : columnEx2.trim();
    }

    public String getColumnEx3() {
        return columnEx3;
    }

    public void setColumnEx3(String columnEx3) {
        this.columnEx3 = columnEx3 == null ? null : columnEx3.trim();
    }

    public Date getDocdate() {
        return docdate;
    }

    public void setDocdate(Date docdate) {
        this.docdate = docdate;
    }

    public Date getUpdatetimestamp() {
        return updatetimestamp;
    }

    public void setUpdatetimestamp(Date updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    public String getIssuedateStr() {
        return issuedateStr;
    }

    public void setIssuedateStr(String issuedateStr) {
        this.issuedateStr = issuedateStr;
    }

    public String getExpirydateStr() {
        return expirydateStr;
    }

    public void setExpirydateStr(String expirydateStr) {
        this.expirydateStr = expirydateStr;
    }

    public String getReportdateStr() {
        return reportdateStr;
    }

    public void setReportdateStr(String reportdateStr) {
        this.reportdateStr = reportdateStr;
    }

    public String getDocdateStr() {
        return docdateStr;
    }

    public void setDocdateStr(String docdateStr) {
        this.docdateStr = docdateStr;
    }
}
