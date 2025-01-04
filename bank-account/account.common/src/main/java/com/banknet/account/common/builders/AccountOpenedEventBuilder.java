package com.banknet.account.common.builders;

import com.banknet.account.common.dto.AccountType;
import com.banknet.account.common.events.AccountOpenedEvent;

import java.util.Date;

public class AccountOpenedEventBuilder {

    private String id;
    private String accountHolder;
    private AccountType accountType;
    private Date createdDate;
    private double openingBalance;

    public AccountOpenedEventBuilder(){}

    public AccountOpenedEventBuilder withId(String id){
        this.id = id;
        return this;
    }

    public AccountOpenedEventBuilder withAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
        return this;
    }

    public AccountOpenedEventBuilder withAccountType(AccountType accountType){
        this.accountType = accountType;
        return this;
    }

    public AccountOpenedEventBuilder withCreatedDate(Date createdDate){
        this.createdDate = createdDate;
        return this;
    }

    public AccountOpenedEventBuilder withOpeningBalance(double openingBalance){
        this.openingBalance = openingBalance;
        return this;
    }

    public AccountOpenedEvent build(){
        return new AccountOpenedEvent(this.id, this.accountHolder, this.accountType, this.createdDate, this.openingBalance);
    }

}
