package com.wf.test;

import com.wf.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyBatisTest {
    // 删除
    @Test
    public void test4() throws IOException {


        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获取session工厂对象

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作 参数： nameSpace + 名称

        int row = sqlSession.delete("userMapper.delete",7);

        System.out.println(row);

        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    // 修改
    @Test
    public void test3() throws IOException {

        User user = new User();
        user.setId(6);
        user.setUsername("lucy");
        user.setPassword("123");

        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获取session工厂对象

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作 参数： nameSpace + 名称

        int row = sqlSession.update("userMapper.update",user);

        System.out.println(row);

        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    // 插入
    @Test
    public void test2() throws IOException {

        User user = new User();
        user.setUsername("tom");
        user.setPassword("123456");

        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获取session工厂对象

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作 参数： nameSpace + 名称

        int row = sqlSession.insert("userMapper.insert",user);

        System.out.println(row);

        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    // 查询
    @Test
    public void test1() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获取session工厂对象

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作 参数： nameSpace + 名称

        List<User> userList = sqlSession.selectList("userMapper.findAll");

        System.out.println(userList);

        // 释放资源
        sqlSession.close();
    }
}
