package com.xjt.exception;

/**
 * @ClassNameMyException
 * @Description
 * @Author
 * @Date2019/11/21 11:09
 * @Version V1.0
 **/
public class MyException extends RuntimeException {
    /**
     * 异常信息
     */
    private String errorMsg;
    /**
     * 错误码
     */
    private Integer code;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    private MyException(Integer code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    /**
     * 抛出逻辑异常
     *
     * @param errorMsg
     * @return
     */
    public static MyException le(Integer code,String errorMsg) {
        return new MyException(code,errorMsg);
    }
}
