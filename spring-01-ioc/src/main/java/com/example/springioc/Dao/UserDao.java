package com.example.springioc.Dao;

import com.example.springioc.bean.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    Dog haha;
    //Spring自动去容器中找到构造器所需要的所有参数的组件值
    /*public UserDao(Dog dog) {
        System.out.println("UserDao的有参构造器");
    this.haha = dog;
    }*/

    @Autowired//Spring自动去容器中找到set方法所需要的所有参数的组件值
    public void setDog(@Qualifier("dog") Dog haha) {
        this.haha = haha;
    }
    public class DogValue{
        /*
        * value注解可以写在属性上，也可以写在set方法上
        * 1.@Value("自面值")
        * 2.@Value("${key}") 从配置文件中获取值
        * 3.@Value("#{表达式}")
        * */
        @Value("haha")//Spring会自动将属性值设置进来
        private String name;
        @Value("#{T(java.util.UUID).randomUUID ().toString()}")//Spring会自动将属性值设置进来
        private String uuid;
        @Value("${dog.age}")
        private int age;

    }
}
