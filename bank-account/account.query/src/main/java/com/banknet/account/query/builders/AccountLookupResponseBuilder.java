package com.banknet.account.query.builders;

import com.banknet.account.query.api.dto.AccountLookupResponse;
import com.banknet.account.query.domain.BankAccount;

import java.util.List;

public class AccountLookupResponseBuilder {
    private String message;

    private List<BankAccount> accounts;

    public AccountLookupResponseBuilder(){}

    public AccountLookupResponseBuilder withMessage(String message){
        this.message = message;
        return this;
    }

    public AccountLookupResponseBuilder withAccounts(List<BankAccount> accounts){
        this.accounts = accounts;
        return this;
    }

    public AccountLookupResponse build(){
        return new AccountLookupResponse(this.message, this.accounts);
    }
}
