package com.banknet.cqrs.core.events;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "eventStore")
public class EventModel {

    @Id
    private String id;
    private Date timeStamp;
    private String aggregateIdentifier;
    private String aggregateType;
    private int version;
    private String eventType;
    private BaseEvent eventData;

    public EventModel(String id, Date timeStamp, String aggregateIdentifier, String aggregateType, int version, String eventType, BaseEvent eventData) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.aggregateIdentifier = aggregateIdentifier;
        this.aggregateType = aggregateType;
        this.version = version;
        this.eventType = eventType;
        this.eventData = eventData;
    }

    public String getId() {
        return this.id;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public String getAggregateIdentifier() {
        return this.aggregateIdentifier;
    }

    public String getAggregateType() {
        return this.aggregateType;
    }

    public int getVersion() {
        return this.version;
    }

    public String getEventType() {
        return this.eventType;
    }

    public BaseEvent getEventData() {
        return this.eventData;
    }
}
