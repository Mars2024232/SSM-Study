package com.example.spring02aop.service.impl;

import com.example.spring02aop.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceimpl implements UserService {
    @Override
    public void save() {
        System.out.println("业务:保存用户");
    }

    @Override
    public void getUserHaha(int i, int j) {
        System.out.println("业务:获取用户");
    }

    @Override
    public void updateUser(Object o) {
        System.out.println("HRHR有MyAn");
    }


}
