package com.banknet.account.common.events;

import com.banknet.cqrs.core.events.BaseEvent;

public class FundsWithdrawnEvent extends BaseEvent {

    private double amount;

    public FundsWithdrawnEvent(){}

    public FundsWithdrawnEvent(String id, double amount) {
        super(id);
        this.amount = amount;
    }

    public double getAmount(){
        return this.amount;
    }
}