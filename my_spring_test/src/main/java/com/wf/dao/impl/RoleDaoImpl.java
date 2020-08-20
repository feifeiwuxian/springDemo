package com.wf.dao.impl;

import com.wf.dao.RoleDao;
import com.wf.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values (?,?,?)", null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUserId(Long id) {
        List<Role> roleList = jdbcTemplate.query("select * from sys_user_role ur, sys_role r where ur.roleId = r.id and ur.userId = ?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roleList;
    }
}
