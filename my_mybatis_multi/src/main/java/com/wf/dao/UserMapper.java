package com.wf.dao;

import com.wf.domain.User;

import java.util.List;

public interface UserMapper {


    public List<User> findUserAndRoleAll();

    public List<User> findAll();

}
