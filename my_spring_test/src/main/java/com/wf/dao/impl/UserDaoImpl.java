package com.wf.dao.impl;

import com.wf.dao.UserDao;
import com.wf.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public Long save(User user) {

        // 创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                // 使用原始jdbc生成有个PreparedStatement组件
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setObject(2, user.getUsername());
                preparedStatement.setObject(3, user.getEmail());
                preparedStatement.setObject(4, user.getPassword());
                preparedStatement.setObject(5, user.getPhoneNum());

                return preparedStatement;
            }
        };

        // 创建KeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator,keyHolder);

        // 获得生成的主键
        long userId = keyHolder.getKey().longValue();


//        int row = jdbcTemplate.update("insert into sys_user values (?,?,?,?,?)", null, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
        return userId; // 返回当前保存用户的id,该id是数据库自动生成的
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values (?, ?)", userId, roleId);
        }
    }

    @Override
    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId = ?", userId);
    }

    @Override
    public void del(Long userId) {
        jdbcTemplate.update("delete from sys_user where id = ?", userId);
    }
}
