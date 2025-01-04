package com.banknet.account.common.events;

import com.banknet.cqrs.core.events.BaseEvent;

public class FundsDepositedEvent extends BaseEvent {
    private double amount;

    public FundsDepositedEvent(){}

    public FundsDepositedEvent(String id, double amount){
        super(id);
        this.amount = amount;
    }

    public double getAmount(){ return this.amount; }
}
