package com.banknet.account.common.events;

import com.banknet.cqrs.core.events.BaseEvent;

public class AccountClosedEvent extends BaseEvent {

    public AccountClosedEvent(){}

    public AccountClosedEvent(String id){
        super(id);
    }
}
