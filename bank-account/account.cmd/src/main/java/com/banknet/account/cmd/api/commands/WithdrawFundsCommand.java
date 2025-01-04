package com.banknet.account.cmd.api.commands;

import com.banknet.cqrs.core.commands.BaseCommand;

public class WithdrawFundsCommand extends BaseCommand {

    private double amount;

    public WithdrawFundsCommand(){}

    public WithdrawFundsCommand(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
