package com.banknet.account.common.builders;

import com.banknet.account.common.events.FundsDepositedEvent;

public class FundsDepositedEventBuilder {

    private String id;

    private double amount;

    public FundsDepositedEventBuilder(){

    }

    public FundsDepositedEventBuilder withId(String id){
        this.id = id;
        return this;
    }

    public FundsDepositedEventBuilder withAmount(double amount){
        this.amount = amount;
        return this;
    }

    public FundsDepositedEvent build(){
        return new FundsDepositedEvent(this.id, this.amount);
    }

}
