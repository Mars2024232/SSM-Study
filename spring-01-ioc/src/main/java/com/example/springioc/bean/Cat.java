package com.example.springioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@PropertySource("classpath:cat.properties")//表示从类路径下获取配置文件
@Component//表示这是一个Spring管理的组件
@Data
public class Cat {
    @Value("${cat.name:Tom}")//表示从配置文件中获取cat.name的值，如果不存在则使用默认值Tom
    private String name;
    @Value("${cat.age:18}")//表示从配置文件中获取cat.age的值，如果不存在则使用默认值18
    private int age;
}
