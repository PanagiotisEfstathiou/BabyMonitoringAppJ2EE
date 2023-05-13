package com.edu.babymonitoringappj2ee.dto;

import com.edu.babymonitoringappj2ee.model.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDto {
    private int id;
    private String name;
    public AccountDto(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Account createAccount(){
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        return account;
    }

    public AccountDto(Account account){
        id = account.getId();
        name = account.getName();
    }
}
