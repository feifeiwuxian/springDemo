package com.wf.dao;

import com.wf.domain.Order;
import com.wf.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
//    @Select("select *,o.id oid from orders o, user u where o.uid = u.id")
//    @Results({
//            @Result(column = "oid", property = "id"),
//            @Result(column = "ordertime", property = "ordertime"),
//            @Result(column = "total", property = "total"),
//            @Result(column = "uid", property = "user.id"),
//            @Result(column = "username", property = "user.username"),
//            @Result(column = "password", property = "user.password"),
//    })
    @Select("select *,o.id oid from orders o, user u where o.uid = u.id")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    column = "uid", // 根据哪个字段去查user表数据
                    property = "user",
                    javaType = User.class,
                    one = @One(select = "com.wf.dao.UserMapper.findById")
            ),
    })
    public List<Order> findAll();

    @Select("select * from orders where uid = #{uid}")
    public List<Order> findByUid(int uid);

}
