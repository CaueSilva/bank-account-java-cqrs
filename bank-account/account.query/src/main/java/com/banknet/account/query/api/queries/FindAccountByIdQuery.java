package com.banknet.account.query.api.queries;

import com.banknet.cqrs.core.queries.BaseQuery;


public class FindAccountByIdQuery extends BaseQuery {

    private String id;

    public FindAccountByIdQuery(){}

    public FindAccountByIdQuery(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
