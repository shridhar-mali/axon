package com.axon.query.repository;

import com.axon.query.view.AccountView;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountViewRepository {

    private Map<String, AccountView>  accounts = new HashMap<>();

    public void add(AccountView accountView) {
        accounts.put(accountView.getAccountId(), accountView);
    }

    public AccountView fetch(String accountId) {
        return  accounts.get(accountId);
    }
}
