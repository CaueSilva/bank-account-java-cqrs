package com.banknet.account.common.builders;

import com.banknet.account.common.events.FundsDepositedEvent;
import com.banknet.account.common.events.FundsWithdrawnEvent;

public class FundsWithdrawnEventBuilder {

    private String id;

    private double amount;

    public FundsWithdrawnEventBuilder(){

    }

    public FundsWithdrawnEventBuilder withId(String id){
        this.id = id;
        return this;
    }

    public FundsWithdrawnEventBuilder withAmount(double amount){
        this.amount = amount;
        return this;
    }

    public FundsWithdrawnEvent build(){
        return new FundsWithdrawnEvent(this.id, this.amount);
    }

}
