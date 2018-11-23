package com.axon.event.listener;

import com.axon.event.AccountOpenedEvent;
import com.axon.query.repository.AccountViewRepository;
import com.axon.query.view.AccountView;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountOpenedEventListener {

    @Autowired
    private AccountViewRepository accountViewRepository;

    @EventHandler
    public void on(AccountOpenedEvent accountOpenedEvent) {
        AccountView accountView = new AccountView(accountOpenedEvent.getAccountId(), accountOpenedEvent.getName(), accountOpenedEvent.getAddress());
        accountViewRepository.add(accountView);
    }
}
