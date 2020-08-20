package com.wf.controller;

import com.wf.config.SpringConfiguration;
import com.wf.dao.UserDao;
import com.wf.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        UserDao user = (UserDao) app.getBean("userDao");
//        user.save();

        UserService userService = app.getBean(UserService.class);
        userService.save();
        ((AnnotationConfigApplicationContext) app).close();



    }
}
