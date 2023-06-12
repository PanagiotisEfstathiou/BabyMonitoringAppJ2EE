package com.edu.babymonitoringappj2ee.resources;

import com.edu.babymonitoringappj2ee.dto.AccountDto;
import com.edu.babymonitoringappj2ee.service.AccountService;
import jakarta.ws.rs.*;

@Path("/account")
public class AccountResource {
    private AccountDto accountDto = new AccountDto();
    private AccountService accountService;

    @GET
    @Path("/ping")
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @POST
    @Path("/register")
    @Consumes("application/json")
    public AccountDto accountDto(AccountDto accountDto) {
        return accountService.saveAccount(accountDto);
    }

    @POST
    @Path("/login")
    @Consumes("application/json")
    public Boolean login(AccountDto accountDto) {
        return accountService.readAccount(accountDto.getId());
    }


}
