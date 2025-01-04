package com.banknet.account.cmd.api.dto;

import com.banknet.account.common.dto.BaseResponse;

public class OpenAccountResponse extends BaseResponse {
    private String id;

    public OpenAccountResponse(){}

    public OpenAccountResponse(String message, String id){
        super(message);
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

}
