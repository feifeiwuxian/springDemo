package com.wf.service.impl;

import com.wf.dao.UserDao;
import com.wf.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("userSevice")
//@Scope("prototype")
//@Scope("singleton")
public class UserServiceImpl implements UserService {

    // @Autowired // 单独这一个的时候根据类型注入，相当于getBean(class)
    // @Qualifier("userDao") // 使用注解时候不需要set方法（xml的时候必须有set方法）。结合@Autowired指定id注入
    @Resource(name ="userDao") // 相当于@Autowired+@Qulifier
    private UserDao userDao;
    public void save() {
//        System.out.println(driver);
        userDao.save();
        System.out.println("userService running");
    }

    @PostConstruct
    public void init(){
        System.out.println("userService对象的初始化");
    }

    @PreDestroy
    public void destory(){
        System.out.println("userService对象的销毁");
    }
}
