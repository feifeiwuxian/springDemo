package com.wf.test;

import com.wf.dao.UserMapper;
import com.wf.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 模拟条件user
        User condition = new User();
//        condition.setId(1);
//        condition.setUsername("zhangsan");
//        condition.setPassword("123");



        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);


    }

    @Test
    // 模拟ids
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 模拟条件user
        User condition = new User();
//        condition.setId(1);
//        condition.setUsername("zhangsan");
//        condition.setPassword("123");

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        List<User> userList = mapper.findByIds(list);
        System.out.println(userList);


    }
}
