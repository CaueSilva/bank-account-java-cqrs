package com.banknet.account.common.builders;

import com.banknet.account.common.events.AccountClosedEvent;

public class AccountClosedEventBuilder {

    private String id;

    public AccountClosedEventBuilder(){}

    public AccountClosedEventBuilder withId(String id){
        this.id = id;
        return this;
    }

    public AccountClosedEvent build(){
        return new AccountClosedEvent(this.id);
    }
}
