package com.example.spring03tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*

* 操作数据库
* 1.导入包,是spring-data-jdbc ,mysql-connector-java
* 2.配置数据库连接信息:在application,propertise
* 3.可以直接使用JdbcTemplate(封装了jdbc增删改查)
* */
@EnableTransactionManagement//开启基于注解的事务管理
@SpringBootApplication
public class Spring03TxApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring03TxApplication.class, args);
    }

}
