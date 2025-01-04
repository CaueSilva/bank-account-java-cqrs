package com.banknet.account.cmd.infrastructure;

import com.banknet.account.cmd.domain.AccountAggregate;
import com.banknet.account.cmd.domain.EventStoreRepository;
import com.banknet.cqrs.core.builders.EventModelBuilder;
import com.banknet.cqrs.core.events.BaseEvent;
import com.banknet.cqrs.core.events.EventModel;
import com.banknet.cqrs.core.exceptions.AggregateNotFoundException;
import com.banknet.cqrs.core.exceptions.ConcurrencyException;
import com.banknet.cqrs.core.infrastructure.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountEventStore implements EventStore {

    @Autowired
    private EventStoreRepository eventStoreRepository;

    @Autowired
    private AccountEventKafkaProducer accountEventKafkaProducer;

    @Override
    public void saveEvents(String aggregateId, Iterable<BaseEvent> events, int expectedVersion) {
        var eventStream = eventStoreRepository.findByAggregateIdentifier(aggregateId);
        if (expectedVersion != -1 && eventStream.get(eventStream.size() - 1).getVersion() != expectedVersion){
            throw new ConcurrencyException();
        }
        var version = expectedVersion;
        for (var event : events){
            version++;
            event.setVersion(version);
            var eventModel = new EventModelBuilder()
                    .withTimeStamp(new Date())
                    .withAggregateIdentifier(aggregateId)
                    .withAggregateType(AccountAggregate.class.getTypeName())
                    .withVersion(version)
                    .withEventType(event.getClass().getTypeName())
                    .withBaseEvent(event)
                    .build();
            var persistedEvent = eventStoreRepository.save(eventModel);
            if (!persistedEvent.getId().isEmpty()){
                accountEventKafkaProducer.produce(event.getClass().getSimpleName(), event);
            }
        }
    }

    @Override
    public List<BaseEvent> getEvents(String aggregateId) {
        var eventStream = eventStoreRepository.findByAggregateIdentifier(aggregateId);
        if (eventStream == null || eventStream.isEmpty()){
            throw new AggregateNotFoundException("Incorrect Account ID provided.");
        }
        return eventStream.stream().map(x -> x.getEventData()).collect(Collectors.toList());
    }

    @Override
    public List<String> getAggregateIds() {
        var eventStream = eventStoreRepository.findAll();
        if (eventStream.isEmpty()){
            throw new IllegalStateException("Could not retrieve event stream from the event store.");
        }
        return eventStream.stream().map(EventModel::getAggregateIdentifier).distinct().collect(Collectors.toList());
    }
}
