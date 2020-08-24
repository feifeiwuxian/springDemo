package com.wf.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.Date;
import java.util.List;

public class MapperTest {

    @Test
    // 分页
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //设置分页相关参数   当前页+每页显示的条数
        PageHelper.startPage(1,3);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        //获得与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("当前页" + pageInfo.getPageNum());
        System.out.println("每页显示条数" + pageInfo.getPageSize());
        System.out.println("总条数" + pageInfo.getTotal());
        System.out.println("总页数" + pageInfo.getPages());
        System.out.println("上一页" + pageInfo.getPrePage());
        System.out.println("下一页" + pageInfo.getNextPage());
        System.out.println("是否是第一页" + pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页" + pageInfo.isIsLastPage());

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    // 模拟查询
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.findById(6);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    // 模拟ids
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 创建User
        User user = new User();
        user.setUsername("ceshi2");
        user.setPassword("123456");
        user.setBirthday(new Date());

        mapper.save(user);

        sqlSession.commit();
        sqlSession.close();

    }
}
