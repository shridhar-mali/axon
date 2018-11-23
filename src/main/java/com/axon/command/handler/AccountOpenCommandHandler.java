package com.axon.com.axon.command.com.axon.command.handler;

import com.axon.aggregate.Account;
import com.axon.com.axon.command.AccountOpenCommand;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountOpenCommandHandler {

    @Autowired
    private Repository<Account> repository;

    @CommandHandler
    public String handle(AccountOpenCommand accountOpenCommand) {
        String accountId = UUID.randomUUID().toString();
        repository.add(new Account(accountId, accountOpenCommand.getName(), accountOpenCommand.getAddress()));
        return  accountId;
    }
}
