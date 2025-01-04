package com.banknet.account.query.infrastructure.handlers;

import com.banknet.account.common.events.AccountClosedEvent;
import com.banknet.account.common.events.AccountOpenedEvent;
import com.banknet.account.common.events.FundsDepositedEvent;
import com.banknet.account.common.events.FundsWithdrawnEvent;
import com.banknet.account.query.builders.BankAccountBuilder;
import com.banknet.account.query.domain.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountEventHandler implements EventHandler {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void on(AccountOpenedEvent event) {
         var bankAccount = new BankAccountBuilder()
                 .withId(event.getId())
                 .withAccountHolder(event.getAccountHolder())
                 .withCreationDate(event.getCreatedDate())
                 .withAccountType(event.getAccountType())
                 .withBalance(event.getOpeningBalance())
                 .build();
         accountRepository.save(bankAccount);
    }

    @Override
    public void on(FundsDepositedEvent event) {
        var bankAccount = accountRepository.findById(event.getId());
        if(bankAccount.isEmpty()){
            return;
        }
        var currentBalance = bankAccount.get().getBalance();
        var latestBalance = currentBalance + event.getAmount();
        bankAccount.get().setBalance(latestBalance);
        accountRepository.save(bankAccount.get());
    }

    @Override
    public void on(FundsWithdrawnEvent event) {
        var bankAccount = accountRepository.findById(event.getId());
        if(bankAccount.isEmpty()){
            return;
        }
        var currentBalance = bankAccount.get().getBalance();
        var latestBalance = currentBalance - event.getAmount();
        bankAccount.get().setBalance(latestBalance);
        accountRepository.save(bankAccount.get());
    }

    @Override
    public void on(AccountClosedEvent event) {
        accountRepository.deleteById(event.getId());
    }
}
