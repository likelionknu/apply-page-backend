package com.springboot.applypage.common;

public enum CommonResponse {

    SUCCESS(0,"Success"), FAIL(-1,"Fail");

    int code;
    String message;

    CommonResponse(int code, String message){
        this.code=code;
        this.message=message;
    }

    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }

}
