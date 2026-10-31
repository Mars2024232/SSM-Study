package com.example.springioc.config;

import com.example.springioc.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean(initMethod = "initUser", destroyMethod = "destroyUser")//允许你在初始化时调用方法和销毁时调用
public User user(){
    return new User();
}
}
