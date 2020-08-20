package com.wf.ano;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前MyAspect是一个切面类
public class MyAspect {


    @Before("MyAspect.myPoint()")
    public void before() {
        System.out.println("前置增强");
    }

    public void after() {
        System.out.println("后置增强");
    }

    @Pointcut("execution(* com.wf.ano.*.*(..))")
    public void myPoint(){

    }
}
