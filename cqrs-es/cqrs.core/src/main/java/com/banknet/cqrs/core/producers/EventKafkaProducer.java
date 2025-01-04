package com.banknet.cqrs.core.producers;

import com.banknet.cqrs.core.events.BaseEvent;

public interface EventKafkaProducer {

    void produce(String topic, BaseEvent baseEvent);

}
