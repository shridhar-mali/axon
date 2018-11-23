package com.axon.controller;

import com.axon.com.axon.command.AccountAddressChangeCommand;
import com.axon.com.axon.command.AccountOpenCommand;
import com.axon.query.repository.AccountViewRepository;
import com.axon.query.view.AccountView;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private AccountViewRepository accountViewRepository;


    @PostMapping("/account/create")
    public String createAccount(@RequestBody AccountRequest accountRequest) {
        return  commandGateway.sendAndWait(new AccountOpenCommand(accountRequest.getName(), accountRequest.getAddress()));
    }

    @PostMapping("/account/update")
    public void updateAccount(@RequestBody AccountUpdateRequest accountUpdateRequest) {
        commandGateway.sendAndWait(new AccountAddressChangeCommand(accountUpdateRequest.getAccountId(), accountUpdateRequest.getAddress()));
    }

    @GetMapping("/account/{accountId}")
    @ResponseBody
    public AccountView fetchAccount(@PathVariable String accountId) {
        return accountViewRepository.fetch(accountId);
    }
}
