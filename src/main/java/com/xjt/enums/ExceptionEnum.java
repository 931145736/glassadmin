package com.xjt.enums;

/**
 * @ClassNameExceptionEnum
 * @Description
 * @Author
 * @Date2019/11/21 15:12
 * @Version V1.0
 **/
public enum  ExceptionEnum {
    SYSTEM_EXCEPTION("系统繁忙，请稍后重试"),
    NOT_LOGIN("您还没有登录"),
    REGISTER_REPETITONG("重复注册"),
    CUSTOMER_EXCEPTION("自定义异常");
    ExceptionEnum(String msg){
        this.msg = msg;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
