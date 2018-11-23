package com.axon.command;

public class AccountOpenCommand {

    private String name;

    private String address;

    public AccountOpenCommand(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
