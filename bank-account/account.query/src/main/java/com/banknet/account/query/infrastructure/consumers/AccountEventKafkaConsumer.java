package com.banknet.account.query.infrastructure.consumers;

import com.banknet.account.common.events.AccountClosedEvent;
import com.banknet.account.common.events.AccountOpenedEvent;
import com.banknet.account.common.events.FundsDepositedEvent;
import com.banknet.account.common.events.FundsWithdrawnEvent;
import com.banknet.account.query.infrastructure.handlers.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class AccountEventKafkaConsumer implements EventKafkaConsumer{

    @Autowired
    private EventHandler eventHandler;

    @KafkaListener(topics ="AccountOpenedEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(AccountOpenedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics ="FundsDepositedEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(FundsDepositedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics ="FundsWithdrawnEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(FundsWithdrawnEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics ="AccountClosedEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(AccountClosedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }
}
