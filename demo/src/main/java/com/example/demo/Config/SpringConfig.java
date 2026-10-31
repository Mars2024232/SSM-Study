package com.example.demo.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//标识这是一个配置类
@ComponentScan(basePackages = "com.example.demo")//指定扫描的包
public class SpringConfig {

}
