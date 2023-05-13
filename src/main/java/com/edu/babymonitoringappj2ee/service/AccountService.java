package com.edu.babymonitoringappj2ee.service;

import com.edu.babymonitoringappj2ee.dto.AccountDto;

public interface AccountService {

    AccountDto saveAccount(AccountDto account);

    AccountDto readAccount(int accountId);

    AccountDto updateAccount(int accountId, AccountDto account);

    boolean deleteAccount(int accountId);
}
