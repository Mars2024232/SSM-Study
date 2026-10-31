package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//注册把UserService注册到Spring容器中,成为一个bean
public class UserService {
    @Autowired//注入,去容器中找Userdao类型的Bean,赋值给成员变量
    UserDao userDao;
    public void queryUser() {
        System.out.println("Service:查询用户数据");
        userDao.query();
    }
}
