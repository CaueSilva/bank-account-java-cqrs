package com.banknet.cqrs.core.infrastructure;

import com.banknet.cqrs.core.domain.BaseEntity;
import com.banknet.cqrs.core.queries.BaseQuery;
import com.banknet.cqrs.core.queries.QueryHandlerMethod;

import java.util.List;

public interface QueryDispatcher {
    <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);
    <U extends BaseEntity> List<U> send(BaseQuery query);
}
