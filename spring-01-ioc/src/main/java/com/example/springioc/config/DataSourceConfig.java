package com.example.springioc.config;

import com.example.springioc.datasource.MyDataSource;
import org.springframework.context.annotation.Profile;

public class DataSourceConfig {
    //利用条件注解,某种条件下只会激活一个组件
    //1.定义环境标识 dev test prod
    //2.激活环境标识
     //明确告诉Spring当前处于什么环境
     //如果没有说,默认是default
    @Profile({"dev","default"})//profile("环境标识") 当某个环境被激活时,才会创建这个组件
    public MyDataSource dev(){
        MyDataSource myDataSource = new MyDataSource();
     return myDataSource;
    }
    @Profile("test")
    public MyDataSource test(){
        MyDataSource myDataSource = new MyDataSource();
        return myDataSource;
    }

    @Profile("prod") public MyDataSource prod(){
        MyDataSource myDataSource = new MyDataSource();
        return myDataSource;
    }
}
