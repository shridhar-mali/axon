package com.axon.query.view;

public class AccountView {

    private String accountId;

    private String name;

    private String address;

    public AccountView(String accountId, String name, String address) {
        this.accountId = accountId;
        this.name = name;
        this.address = address;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}
