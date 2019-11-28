package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel
public class MasterReqDto extends BaseReqDto {
    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private String id;

    /**
     * 管理员名称
     */
    @ApiModelProperty("管理员名称")
    private String name;

    /**
     * 管理员密码
     */
    @ApiModelProperty("管理员密码")
    private String password;

    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String trueName;

    /**
     * 性别(0是男，1是女)
     */
    @ApiModelProperty("性别(0是男，1是女)")
    private Long sex;

    /**
     * 生日
     */
    @ApiModelProperty("生日:yyyy-MM-dd hh:mm:ss")
    private String birth;

    private Date birthday;

    /**
     * 所属部门
     */
    @ApiModelProperty("所属部门")
    private String dept;

    /**
     * 职务
     */
    @ApiModelProperty("职务")
    private String position;

    /**
     * 职务说明
     */
    @ApiModelProperty("职务说明")
    private String positionDesc;

    /**
     * 办公室电话
     */
    @ApiModelProperty("办公室电话")
    private String officePhone;

    /**
     * 手机
     */
    @ApiModelProperty("手机")
    private Long mobile;

    /**
     * 家庭电话
     */
    @ApiModelProperty("家庭电话")
    private String homePhone;

    /**
     * 电子邮件
     */
    @ApiModelProperty("电子邮件")
    private String email;

    /**
     * 创建者id
     */
    @ApiModelProperty("创建者id")
    private String masterId;

    /**
     * 创建者名称
     */
    @ApiModelProperty("创建者名称")
    private String masterName;

    /**
     * 创建日期
     */

    private Date createdate;
    @ApiModelProperty("创建时间 yyyy-MM-dd")
    private String createDate;

    /**
     * 是否有效 0 否 1 有
     */
    @ApiModelProperty("是否有效 0 否 1 有")
    private Long deleteFlag;

   @ApiModelProperty("开始时间 yyyy-MM-dd")
   private String startTime;
    private Date startDate;
   @ApiModelProperty("结束时间 yyyy-MM-dd")
   private String endTime;
    private Date endDate;

    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc == null ? null : positionDesc.trim();
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName == null ? null : masterName.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Long deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
