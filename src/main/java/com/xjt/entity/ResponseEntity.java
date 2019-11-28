package com.xjt.entity;

public class ResponseEntity {

    private  String ReturnType;

    private String Message;

    private String token;
    private String userId;

    public String getReturnType() {
        return ReturnType;
    }

    public void setReturnType(String returnType) {
        ReturnType = returnType;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
