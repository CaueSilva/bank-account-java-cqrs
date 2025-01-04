package com.banknet.cqrs.core.events;

import com.banknet.cqrs.core.messages.Message;

public abstract class BaseEvent extends Message {

    private int version;

    public BaseEvent(){}

    public BaseEvent(int version){
        this.version = version;
    }

    public BaseEvent(String id){
        super(id);
    }

    public int getVersion(){
        return this.version;
    }

    public void setVersion(int version){
        this.version = version;
    }

}
