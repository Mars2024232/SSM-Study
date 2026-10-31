package com.example.springioc.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class User implements InitializingBean , DisposableBean {
    private String name;
    private  String password;
    private Car car;
  @Autowired
    public void SetCar(){
        System.out.println("user-自动注入");
        this.car = car;
    }
    public User() {
        System.out.println("User 构造方法");
    }
    @PostConstruct//构造器之后
    public void postConstructMethod() {
        System.out.println(" user-postConstructMethod");
    }
    @PreDestroy//
    public void preDestrory(){
        System.out.println("user-preDestrory");
    }
    public void initUser(){
        System.out.println("user-@Bean 初始化");
    }
    public void destroyUser(){
        System.out.println("user-@Bean 销毁");
    }

   //属性设置之后进行调用
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("user-afterPropertiesSet");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("user-destroy");
    }
}
