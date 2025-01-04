package com.banknet.account.query.infrastructure.handlers;

import com.banknet.account.common.events.AccountClosedEvent;
import com.banknet.account.common.events.AccountOpenedEvent;
import com.banknet.account.common.events.FundsDepositedEvent;
import com.banknet.account.common.events.FundsWithdrawnEvent;

public interface EventHandler {
    void on(AccountOpenedEvent event);
    void on(FundsDepositedEvent event);
    void on(FundsWithdrawnEvent event);
    void on(AccountClosedEvent event);
}
