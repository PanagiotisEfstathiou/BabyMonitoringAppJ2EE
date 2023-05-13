package com.edu.babymonitoringappj2ee.service.impl;

import com.edu.babymonitoringappj2ee.dto.AccountDto;
import com.edu.babymonitoringappj2ee.model.Account;
import com.edu.babymonitoringappj2ee.repository.AccountRepository;
import com.edu.babymonitoringappj2ee.service.AccountService;

import javax.inject.Inject;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    @Inject
    private AccountRepository accountRepository ;

    @Override
    public AccountDto saveAccount(AccountDto account) {
        Account account1 = account.createAccount();
        accountRepository.save(account1);
        return new AccountDto(account1);
    }

    @Override
    public AccountDto readAccount(int accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent())
            return new AccountDto(account.get());
        else
            return null;
    }

    @Override
    public AccountDto updateAccount(int accountId, AccountDto account) {
        Account account1 = account.createAccount();
        return new AccountDto (accountRepository.update(accountId, account1).get());
    }

    @Override
    public boolean deleteAccount(int accountId) {
        return accountRepository.delete(accountId);
    }
}
