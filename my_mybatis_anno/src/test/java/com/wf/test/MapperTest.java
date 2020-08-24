package com.wf.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.dao.OrderMapper;
import com.wf.dao.UserMapper;
import com.wf.domain.Order;
import com.wf.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperTest {
    private UserMapper mapper;
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);

        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void test1Save()  {

        User user = new User();
        user.setUsername("tome");
        user.setPassword("abc");
        mapper.save(user);

    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(9);
        user.setUsername("lucy");
        user.setPassword("123");
        mapper.update(user);
    }

    @Test
    public void testDelete(){
        mapper.delete(9);
    }

    @Test
    public void testFindById(){
        User user = mapper.findById(2);
        System.out.println(user);
    }

    @Test
    public void testFindAll(){
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @After
    public void after() {
        sqlSession.close();
        System.out.println("结束");
    }
}
