package com.edu.babymonitoringappj2ee.repository;

import com.edu.babymonitoringappj2ee.model.Account;

import java.util.Optional;

public interface AccountRepository {

    void save(Account account);

    Optional<Account> findById(int id);

    Optional<Account> update(int accountId, Account account);

    boolean delete(int accountId);
}
