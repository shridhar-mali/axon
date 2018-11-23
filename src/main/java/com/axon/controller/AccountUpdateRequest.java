package com.axon.controller;

public class AccountUpdateRequest {

    private String accountId;

    private String address;

    public AccountUpdateRequest() {
    }

    public AccountUpdateRequest(String accountId, String address) {
        this.accountId = accountId;
        this.address = address;
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
