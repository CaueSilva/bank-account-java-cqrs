package com.banknet.account.query.api.queries;

import com.banknet.cqrs.core.queries.BaseQuery;

public class FindAccountByHolderQuery extends BaseQuery {

    private String accountHolder;

    public FindAccountByHolderQuery(){}

    public FindAccountByHolderQuery(String holder) {
        this.accountHolder = holder;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
