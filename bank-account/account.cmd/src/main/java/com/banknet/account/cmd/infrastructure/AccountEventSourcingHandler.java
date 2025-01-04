package com.banknet.account.cmd.infrastructure;

import com.banknet.account.cmd.domain.AccountAggregate;
import com.banknet.cqrs.core.domain.AggregateRoot;
import com.banknet.cqrs.core.handlers.EventSourcingHandler;
import com.banknet.cqrs.core.infrastructure.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class AccountEventSourcingHandler implements EventSourcingHandler<AccountAggregate> {

    @Autowired
    private EventStore eventStore;

    @Autowired
    private AccountEventKafkaProducer accountEventKafkaProducer;

    @Override
    public void save(AggregateRoot aggregate) {
        eventStore.saveEvents(aggregate.getId(), aggregate.getUncommittedChanges(), aggregate.getVersion());
        aggregate.markChangesAsCommitted();
    }

    @Override
    public AccountAggregate getById(String id) {
        var aggregate = new AccountAggregate();
        var events = eventStore.getEvents(id);
        if (events != null && !events.isEmpty()){
            aggregate.replayEvents(events);
            var latestVersion = events.stream().map(x -> x.getVersion()).max(Comparator.naturalOrder());
            aggregate.setVersion(latestVersion.get());
        }
        return aggregate;
    }

    @Override
    public void republishEvents() {
        var aggregateIds = eventStore.getAggregateIds();
        for (var aggregateId: aggregateIds){
            var aggregate = this.getById(aggregateId);
            if (aggregate == null || !aggregate.isActive()) continue;
            var events = eventStore.getEvents(aggregateId);
            for (var event: events){
                accountEventKafkaProducer.produce(event.getClass().getSimpleName(), event);
            }
        }
    }
}
