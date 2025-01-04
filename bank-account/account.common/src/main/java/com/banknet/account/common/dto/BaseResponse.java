package com.banknet.account.common.dto;

public class BaseResponse {

    private String message;

    public BaseResponse(){

    }

    public BaseResponse(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
