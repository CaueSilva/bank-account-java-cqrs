package com.banknet.account.cmd.infrastructure;

import com.banknet.cqrs.core.events.BaseEvent;
import com.banknet.cqrs.core.producers.EventKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountEventKafkaProducer implements EventKafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void produce(String topic, BaseEvent baseEvent) {
        this.kafkaTemplate.send(topic, baseEvent);
    }
}
