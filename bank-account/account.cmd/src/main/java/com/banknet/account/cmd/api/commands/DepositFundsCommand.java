package com.banknet.account.cmd.api.commands;

import com.banknet.cqrs.core.commands.BaseCommand;

public class DepositFundsCommand extends BaseCommand {

    private double amount;

    public DepositFundsCommand(){}

    public DepositFundsCommand(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
