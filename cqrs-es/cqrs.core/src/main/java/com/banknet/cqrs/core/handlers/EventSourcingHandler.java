package com.banknet.cqrs.core.handlers;

import com.banknet.cqrs.core.domain.AggregateRoot;

public interface EventSourcingHandler<T>{

    void save(AggregateRoot aggregate);
    T getById(String id);

    void republishEvents();
}
