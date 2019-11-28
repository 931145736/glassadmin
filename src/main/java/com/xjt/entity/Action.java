package com.xjt.entity;

/**
 * 权限表
 * 
 * @author wcyong
 * 
 * @date 2019-10-24
 */
public class Action {
    /**
     * 主键id
     */
    private String actionid;

    /**
     * 动作名称
     */
    private String actionName;

    /**
     * 动作分栏号(与actioncolumn表关联)
     */
    private String actionColumnId;

    /**
     * 动作名称对应的英文字符串
     */
    private String action;

    private String actionPath;

    /**
     * 是否可见
     */
    private String viewMode;

    /**
     * 是否有效 0 否 1 是
     */
    private Long deleteFlag;

    /**
     * 对应的操作
     */
    private String actionWay;



    public String getActionid() {
        return actionid;
    }

    public void setActionid(String actionid) {
        this.actionid = actionid;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName == null ? null : actionName.trim();
    }

    public String getActionColumnId() {
        return actionColumnId;
    }

    public void setActionColumnId(String actionColumnId) {
        this.actionColumnId = actionColumnId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public String getActionPath() {
        return actionPath;
    }

    public void setActionPath(String actionPath) {
        this.actionPath = actionPath;
    }

    public String getViewMode() {
        return viewMode;
    }

    public void setViewMode(String viewMode) {
        this.viewMode = viewMode == null ? null : viewMode.trim();
    }

    public Long getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Long deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getActionWay() {
        return actionWay;
    }

    public void setActionWay(String actionWay) {
        this.actionWay = actionWay;
    }
}