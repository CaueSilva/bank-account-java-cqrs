package com.banknet.cqrs.core.commands;

import com.banknet.cqrs.core.messages.Message;

public abstract class BaseCommand extends Message {

    public BaseCommand(){

    }

    public BaseCommand(String id){
        super(id);
    }
}
