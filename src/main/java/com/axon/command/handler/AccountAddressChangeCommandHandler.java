package com.axon.command.handler;

        import com.axon.aggregate.Account;
        import com.axon.command.AccountAddressChangeCommand;
        import org.axonframework.commandhandling.annotation.CommandHandler;
        import org.axonframework.repository.Repository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

@Component
public class AccountAddressChangeCommandHandler {

    @Autowired
    private Repository<Account> repository;

    @CommandHandler
    public void handle(AccountAddressChangeCommand accountAddressChangeCommand) {



        Account account = repository.load(accountAddressChangeCommand.getAccountId());
        account.changeAddress(accountAddressChangeCommand.getAccountId(), accountAddressChangeCommand.getAddress());
    }
}
