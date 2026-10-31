package com.example.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* 效果:其实是springboot做的
* 1.Tomcat不用整合
* 2.Servlet开发变得简单,不用实现任何接口
* 3.自动解决了乱码问题
* */

@SpringBootApplication
public class Springmvc01HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springmvc01HelloworldApplication.class, args);
    }

}
