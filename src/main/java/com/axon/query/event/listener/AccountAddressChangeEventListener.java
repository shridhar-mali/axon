package com.axon.query.event.listener;

import com.axon.event.AccountAddressChangeEvent;
import com.axon.query.repository.AccountViewRepository;
import com.axon.query.view.AccountView;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountAddressChangeEventListener {

    @Autowired
    private AccountViewRepository accountViewRepository;

    @EventHandler
    public void on(AccountAddressChangeEvent accountAddressChangeEvent) {
        AccountView accountView = accountViewRepository.fetch(accountAddressChangeEvent.getAccountId());
        AccountView newAccountView = new AccountView(accountView.getAccountId(), accountView.getName(), accountAddressChangeEvent.getAddress());
        accountViewRepository.add(newAccountView);
    }
}
