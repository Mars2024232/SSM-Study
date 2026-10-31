package com.example.springioc.config;

import com.example.springioc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration//告诉Spring这是一个配置类
public class PersonConfig {
    @Scope
    /*@Scope调整组件的作用域
    1.@Scope("singleton")://默认值,单例的
    2.@Scope("prototype")://多例的
    @Lazy//延迟加载
    3.@Scope("request")://请求范围
    4.@Scope("session")://会话范围
    5.@Scope("application")://应用范围
    6.@Scope("websocket")://WebSocket范围*/
    @Bean("zhangsan")
    public Person person() {
        Person person = new Person();
        person.setName("张三");
        person.setAge(18);
        return person;
    }
    @Bean("lisi")
    public Person person2() {
        Person person = new Person();
        person.setName("李四");
        person.setAge(18);
        return person;
    }
}
