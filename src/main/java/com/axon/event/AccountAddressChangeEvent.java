package com.axon.event;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class AccountAddressChangeEvent {
    private final String accountId;
    private final String address;


    public AccountAddressChangeEvent() {
        this(null, null);
    }

    public AccountAddressChangeEvent(String accountId, String address) {
        this.accountId = accountId;
        this.address = address;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAddress() {
        return address;
    }
}
