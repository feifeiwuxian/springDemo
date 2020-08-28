package com.wf.test;

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
import java.util.List;

public class MapperTest2 {
    private OrderMapper mapper;
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);

        mapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void test1Save()  {

        List<Order> all = mapper.findAll();
        for (Order order : all) {
            System.out.println(order);

        }

    }

    @After
    public void after() {
        sqlSession.close();
        System.out.println("结束");
    }
}
