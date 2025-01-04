package com.banknet.account.query.api.dto;

import com.banknet.account.common.dto.BaseResponse;
import com.banknet.account.query.domain.BankAccount;

import java.util.List;

public class AccountLookupResponse extends BaseResponse {
    private List<BankAccount> accounts;

    public AccountLookupResponse(){}

    public AccountLookupResponse(String message) {
        super(message);
    }

    public AccountLookupResponse(String message, List<BankAccount> accounts) {
        super(message);
        this.accounts = accounts;
    }

    public List<BankAccount> getAccounts() {
        return this.accounts;
    }
}
