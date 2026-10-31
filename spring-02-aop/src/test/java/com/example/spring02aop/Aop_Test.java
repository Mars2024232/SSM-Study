package com.example.spring02aop;

import com.example.spring02aop.calculator.MathCalculator;
import com.example.spring02aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//1.Aop的底层原理,Spring会为每个被切面切入的组件创建一个代理对象(无视接口)
//2.代理对象中保存了切面类里面所有通知方法构成的增强器链
//3.当被代理对象的方法被调用时,代理对象会先调用增强器链中的方法,再调用被代理对象的方法
@SpringBootTest
public class Aop_Test {
    @Autowired//容器中是他的代理对象
    MathCalculator mathCalculator;
    @Autowired
    UserService userService;
    @Test
    void test01() {
    System.out.println(mathCalculator);//实现类
        mathCalculator.add(0,0);
       /* userService.getUserHaha(1, 2);
        userService.updateUser(new Object());*/
    }
}
