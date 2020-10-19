package com.wf.dao;

import com.wf.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert("insert into user values (#{id}, #{username}, #{password}, #{birthday})")
    public void save(User user);
    @Update("update user set username = #{username}, password = #{password} where id = #{id}")
    public void update(User user);
    @Delete("delete from user where id = #{id}")
    public void delete(int id);
    @Select("select * from user where id = #{id}")
    public User findById(int id);
    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "orderList",
                    column = "id", // 根据哪个字段去查
                    javaType = List.class,
                    many = @Many(select = "com.wf.dao.OrderMapper.findByUid")
            )
    }

    )
    public List<User> findUserAndOderAll();

    @Select("SELECT * FROM USER")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.wf.dao.RoleMapper.findByUid")
            )
    })
    List<User> findUserAndRoleAll();
}
