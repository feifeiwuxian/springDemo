package com.wf.service;

import com.wf.domain.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);
    List<Account> findAll();
}
