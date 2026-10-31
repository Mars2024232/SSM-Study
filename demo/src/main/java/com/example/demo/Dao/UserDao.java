package com.example.demo.Dao;

import org.springframework.stereotype.Repository;

@Repository//把Userdao注册到Spring容器中,成为一个bean
public class UserDao {
    public void query() {
        System.out.println("Dao:查询用户数据");
    }
}
