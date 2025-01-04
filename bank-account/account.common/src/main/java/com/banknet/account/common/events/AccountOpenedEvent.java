package com.banknet.account.common.events;

import com.banknet.account.common.dto.AccountType;
import com.banknet.cqrs.core.events.BaseEvent;
import java.util.Date;

public class AccountOpenedEvent extends BaseEvent {

    private String accountHolder;
    private AccountType accountType;
    private Date createdDate;
    private double openingBalance;

    public AccountOpenedEvent(){}

    public AccountOpenedEvent(String accountHolder, AccountType accountType, Date createdDate, double openingBalance) {
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.createdDate = createdDate;
        this.openingBalance = openingBalance;
    }

    public AccountOpenedEvent(String id, String accountHolder, AccountType accountType, Date createdDate, double openingBalance) {
        super(id);
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.createdDate = createdDate;
        this.openingBalance = openingBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

}
