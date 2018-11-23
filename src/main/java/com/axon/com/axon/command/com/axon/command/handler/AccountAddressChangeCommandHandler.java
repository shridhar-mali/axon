package com.axon.com.axon.command.com.axon.command.handler;

        import com.axon.aggregate.Account;
        import com.axon.com.axon.command.AccountAddressChangeCommand;
        import com.axon.com.axon.command.AccountOpenCommand;
        import com.axon.event.AccountAddressChangeEvent;
        import org.axonframework.commandhandling.annotation.CommandHandler;
        import org.axonframework.repository.Repository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

        import java.util.UUID;

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
