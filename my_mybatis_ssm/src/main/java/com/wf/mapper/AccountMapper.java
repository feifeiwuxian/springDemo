package com.wf.mapper;

import com.wf.domain.Account;

import java.util.List;

public interface AccountMapper {
    void save(Account account);
    List<Account> findAll();
}
