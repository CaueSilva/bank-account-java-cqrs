package com.banknet.account.query.api.queries;

import com.banknet.account.query.api.dto.EqualityType;
import com.banknet.cqrs.core.queries.BaseQuery;

public class FindAccountWithBalanceQuery extends BaseQuery {
    private EqualityType equalityType;
    private double balance;

    public FindAccountWithBalanceQuery(){}

    public FindAccountWithBalanceQuery(EqualityType equalityType, double balance) {
        this.equalityType = equalityType;
        this.balance = balance;
    }

    public EqualityType getEqualityType() {
        return equalityType;
    }

    public double getBalance() {
        return balance;
    }
}
