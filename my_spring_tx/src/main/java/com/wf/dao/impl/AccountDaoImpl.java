package com.wf.dao.impl;

import com.wf.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void out(String outMan, double money) {
        jdbcTemplate.update("update account set money = money - ? where name = ?", money, outMan);
    }

    public void in(String outMan, double money) {
        jdbcTemplate.update("update account set money = money + ? where name = ?", money, outMan);
    }
}
