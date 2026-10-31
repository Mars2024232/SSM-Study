package com.example.springioc.service;

import com.example.springioc.Dao.UserDao;
import com.example.springioc.bean.Dog;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Data
@ToString
@Service
public class Uersservice {
    @Resource
    //@Resource和@Autowired都是用于依赖注入的，但它们在用法上有一些区别。
    // @Resource是Java EE提供的注解，而@Autowired是Spring框架提供的注解。
    // @Resource默认按照名称进行依赖注入，而@Autowired默认按照类型进行依赖注入。

    private UserDao userDao;
    @Autowired(required = false)//按照类型进行依赖注入，如果找不到对应的bean则不注入
    Dog dog;
    @Resource//按照名称进行依赖注入如果找不到对应的bean则不注入,报错
    Dog dog1;

}
