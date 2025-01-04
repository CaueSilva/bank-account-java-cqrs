package com.banknet.account.cmd.domain;

import com.banknet.account.cmd.api.commands.OpenAccountCommand;
import com.banknet.account.common.builders.AccountClosedEventBuilder;
import com.banknet.account.common.builders.AccountOpenedEventBuilder;
import com.banknet.account.common.builders.FundsDepositedEventBuilder;
import com.banknet.account.common.builders.FundsWithdrawnEventBuilder;
import com.banknet.account.common.events.AccountClosedEvent;
import com.banknet.account.common.events.AccountOpenedEvent;
import com.banknet.account.common.events.FundsDepositedEvent;
import com.banknet.account.common.events.FundsWithdrawnEvent;
import com.banknet.cqrs.core.domain.AggregateRoot;

import java.util.Date;

public class AccountAggregate extends AggregateRoot {

    private Boolean active;
    private double balance;

    public AccountAggregate(){}

    public AccountAggregate(OpenAccountCommand command){
        raiseEvent(new AccountOpenedEventBuilder()
                .withId(command.getId())
                .withAccountHolder(command.getAccountHolder())
                .withCreatedDate(new Date())
                .withAccountType(command.getAccountType())
                .withOpeningBalance(command.getOpeningBalance())
                .build()
        );
    }

    public void apply(AccountOpenedEvent event){
        this.id = event.getId();
        this.active = true;
        this.balance = event.getOpeningBalance();
    }

    public void depositFunds(double amount){
        if (!this.active) {
            throw new IllegalStateException("Funds cannot be deposited into a closed account.");
        }
        if (amount <= 0) {
            throw new IllegalStateException("The deposit amount must be greater than 0!");
        }
        raiseEvent(new FundsDepositedEventBuilder()
                .withId(this.id)
                .withAmount(amount)
                .build());
    }

    public void apply(FundsDepositedEvent event){
        this.id = event.getId();
        this.balance += event.getAmount();
    }

    public void withdrawFunds(double amount){
        if (!this.active){
            throw new IllegalStateException("Funds cannot be withdraw from a closed account.");
        }
        if (amount > this.balance) {
            throw new IllegalStateException("The withdraw amount must be less than the account balance!");
        }
        raiseEvent(new FundsWithdrawnEventBuilder()
                .withId(this.id)
                .withAmount(amount)
                .build());
    }

    public void apply(FundsWithdrawnEvent event){
        this.id = event.getId();
        this.balance -= event.getAmount();
    }

    public void closeAccount(){
        if (!this.active){
            throw new IllegalStateException("Account already closed.");
        }
        raiseEvent(new AccountClosedEventBuilder()
                .withId(this.id)
                .build());
    }

    public void apply(AccountClosedEvent event){
        this.id = event.getId();
        this.active = false;
    }

    public Boolean isActive(){
        return this.active;
    }
}
