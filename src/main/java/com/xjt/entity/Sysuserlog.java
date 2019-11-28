package com.xjt.entity;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-21
 */
public class Sysuserlog {
    /**
     * 自增主键
     */
    private Integer logId;
    private String logUserName;

    /**
     * 用户名
     */
    private String logUser;

    /**
     * 用户操作
     */
    private String logOperatiion;

    /**
     * 操作的方法名
     */
    private String logMethod;

    /**
     * 方法的参数
     */
    private String logParams;

    private String logUrl;

    /**
     * 用户ip
     */
    private String logUserIp;

    /**
     * 操作时间
     */
    private Date logDate;

    private Integer deleteFlag;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogUserName() {
        return logUserName;
    }

    public void setLogUserName(String logUserName) {
        this.logUserName = logUserName;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser == null ? null : logUser.trim();
    }

    public String getLogOperatiion() {
        return logOperatiion;
    }

    public void setLogOperatiion(String logOperatiion) {
        this.logOperatiion = logOperatiion == null ? null : logOperatiion.trim();
    }

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod == null ? null : logMethod.trim();
    }

    public String getLogParams() {
        return logParams;
    }

    public void setLogParams(String logParams) {
        this.logParams = logParams == null ? null : logParams.trim();
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getLogUserIp() {
        return logUserIp;
    }

    public void setLogUserIp(String logUserIp) {
        this.logUserIp = logUserIp == null ? null : logUserIp.trim();
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}