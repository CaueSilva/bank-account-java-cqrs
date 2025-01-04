package com.banknet.account.query.builders;

import com.banknet.account.common.dto.AccountType;
import com.banknet.account.query.domain.BankAccount;

import java.util.Date;

public class BankAccountBuilder {

    private String id;
    private String accountHolder;
    private Date creationDate;
    private AccountType accountType;
    private double balance;

    public BankAccountBuilder(){}

    public BankAccountBuilder withId(String id){
        this.id = id;
        return this;
    }

    public BankAccountBuilder withAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
        return this;
    }

    public BankAccountBuilder withCreationDate(Date creationDate){
        this.creationDate = creationDate;
        return this;
    }

    public BankAccountBuilder withAccountType(AccountType accountType){
        this.accountType = accountType;
        return this;
    }

    public BankAccountBuilder withBalance(double balance){
        this.balance = balance;
        return this;
    }

    public BankAccount build(){
        return new BankAccount(this.id, this.accountHolder, this.creationDate, this.accountType, this.balance);
    }

}
