package com.banknet.cqrs.core.messages;

public abstract class Message {

    private String id;

    public Message(){

    }

    public Message(String id) {
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

}
