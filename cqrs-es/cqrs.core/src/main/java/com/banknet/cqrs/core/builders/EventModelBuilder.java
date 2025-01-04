package com.banknet.cqrs.core.builders;

import com.banknet.cqrs.core.events.BaseEvent;
import com.banknet.cqrs.core.events.EventModel;

import java.util.Date;

public class EventModelBuilder {

    private Date timeStamp;
    private String aggregateIdentifier;
    private String aggregateType;
    private int version;
    private String eventType;
    private BaseEvent eventData;

    public EventModelBuilder(){}

    public EventModelBuilder withTimeStamp(Date timeStamp){
        this.timeStamp = timeStamp;
        return this;
    }

    public EventModelBuilder withAggregateIdentifier(String aggregateIdentifier){
        this.aggregateIdentifier = aggregateIdentifier;
        return this;
    }

    public EventModelBuilder withAggregateType(String aggregateType){
        this.aggregateType = aggregateType;
        return this;
    }

    public EventModelBuilder withVersion(int version){
        this.version = version;
        return this;
    }

    public EventModelBuilder withEventType(String eventType){
        this.eventType = eventType;
        return this;
    }

    public EventModelBuilder withBaseEvent(BaseEvent eventData){
        this.eventData = eventData;
        return this;
    }

    public EventModel build(){
        return new EventModel(null, this.timeStamp, this.aggregateIdentifier, this.aggregateType, this.version, this.eventType, this.eventData);
    }

}
