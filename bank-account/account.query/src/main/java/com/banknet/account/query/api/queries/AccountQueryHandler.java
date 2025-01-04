package com.banknet.account.query.api.queries;

import com.banknet.account.query.api.dto.EqualityType;
import com.banknet.account.query.domain.AccountRepository;
import com.banknet.account.query.domain.BankAccount;
import com.banknet.cqrs.core.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountQueryHandler implements QueryHandler{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<BaseEntity> handle(FindAllAccountsQuery query) {
        Iterable<BankAccount> bankAccountIterable = accountRepository.findAll();
        List<BaseEntity> bankAccountList = new ArrayList<>();
        bankAccountIterable.forEach(bankAccountList::add);
        return bankAccountList;
    }

    @Override
    public List<BaseEntity> handle(FindAccountByIdQuery query) {
        var bankAccount = accountRepository.findById(query.getId());
        if (bankAccount.isEmpty()){
            return null;
        }
        List<BaseEntity> bankAccountList = new ArrayList<>();
        bankAccountList.add(bankAccount.get());
        return bankAccountList;
    }

    @Override
    public List<BaseEntity> handle(FindAccountByHolderQuery query) {
        var bankAccount = accountRepository.findByAccountHolder(query.getAccountHolder());
        if (bankAccount.isEmpty()){
            return null;
        }
        List<BaseEntity> bankAccountList = new ArrayList<>();
        bankAccountList.add(bankAccount.get());
        return bankAccountList;
    }

    @Override
    public List<BaseEntity> handle(FindAccountWithBalanceQuery query) {
        return query.getEqualityType() == EqualityType.GREATER_THAN ?
                accountRepository.findByBalanceGreaterThan(query.getBalance()) :
                accountRepository.findByBalanceLessThan(query.getBalance());
    }
}
