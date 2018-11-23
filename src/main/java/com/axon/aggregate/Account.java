package com.axon.aggregate;

import com.axon.event.AccountAddressChangeEvent;
import com.axon.event.AccountOpenedEvent;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

public class Account extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String accountId;

    private String name;

    private String address;

    public Account() {
    }

    public Account(String accountId, String name, String address) {
        apply(new AccountOpenedEvent(accountId, name, address));
    }

    public void changeAddress(String accountId, String address) {
        apply(new AccountAddressChangeEvent(accountId, address));
    }

    @EventSourcingHandler
    public void on(AccountOpenedEvent accountOpenedEvent) {
        this.accountId = accountOpenedEvent.getAccountId();
        this.name = accountOpenedEvent.getName();
        this.address = accountOpenedEvent.getAddress();
    }

    @EventSourcingHandler
    public void on(AccountAddressChangeEvent accountAddressChangeEvent) {
        this.accountId = accountAddressChangeEvent.getAccountId();
        this.address = accountAddressChangeEvent.getAddress();
    }


}
