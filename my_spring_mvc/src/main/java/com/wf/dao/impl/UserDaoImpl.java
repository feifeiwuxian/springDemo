package com.wf.dao.impl;

import com.wf.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("userDao running!...");
    }
}
