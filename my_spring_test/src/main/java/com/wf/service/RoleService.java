package com.wf.service;

import com.wf.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> list();

    void save(Role role);
}
