package com.banknet.account.query.infrastructure.consumers;

import com.banknet.account.common.events.AccountClosedEvent;
import com.banknet.account.common.events.AccountOpenedEvent;
import com.banknet.account.common.events.FundsDepositedEvent;
import com.banknet.account.common.events.FundsWithdrawnEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventKafkaConsumer {
    void consume(@Payload AccountOpenedEvent event, Acknowledgment ack);
    void consume(@Payload FundsDepositedEvent event, Acknowledgment ack);
    void consume(@Payload FundsWithdrawnEvent event, Acknowledgment ack);
    void consume(@Payload AccountClosedEvent event, Acknowledgment ack);
}
