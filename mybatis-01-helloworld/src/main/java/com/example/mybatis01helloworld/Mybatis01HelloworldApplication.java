package com.example.mybatis01helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
* 步骤:
* 1.导入MyBatis依赖
* 2.配置数据源信息
* 3.编写JavaBean对应数据库表模型
* 4.以前
*  1.Dao接口--->Dao实现类
*  2.Mapper接口--->Mapper.xml文件(Mybatisx插件自动化生成Mapper.xml文件)
* 5.告诉MyBatis去哪里找Mapper接口 (application.yml文件)
*
* #{} :预编译方式
* ${} : 动态SQL ,SQL注入问题,使用时需要谨慎
*
* */
@EnableTransactionManagement
@SpringBootApplication
public class Mybatis01HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mybatis01HelloworldApplication.class, args);
    }

}
