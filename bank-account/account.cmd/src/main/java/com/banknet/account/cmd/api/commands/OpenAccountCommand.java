package com.banknet.account.cmd.api.commands;

import com.banknet.account.common.dto.AccountType;
import com.banknet.cqrs.core.commands.BaseCommand;


public class OpenAccountCommand extends BaseCommand {

    private String accountHolder;
    private AccountType accountType;
    private double openingBalance;

    public OpenAccountCommand(){}

    public OpenAccountCommand(String accountHolder, AccountType accountType, double openingBalance) {
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.openingBalance = openingBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }
}
