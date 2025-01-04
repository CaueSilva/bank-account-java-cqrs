package com.banknet.account.query.domain;

import com.banknet.account.common.dto.AccountType;
import com.banknet.cqrs.core.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BankAccount extends BaseEntity {

    @Id
    private String id;
    private String accountHolder;
    private Date creationDate;
    private AccountType accountType;
    private double balance;

    public BankAccount(){}

    public BankAccount(String id, String accountHolder, Date creationDate, AccountType accountType, double balance) {
        this.id = id;
        this.accountHolder = accountHolder;
        this.creationDate = creationDate;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
