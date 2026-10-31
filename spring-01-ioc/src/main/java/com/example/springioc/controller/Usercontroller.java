package com.example.springioc.controller;

import com.example.springioc.bean.Person;
import com.example.springioc.service.Uersservice;
import jakarta.annotation.Priority;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Data
@ToString
@Controller
public class Usercontroller {
    /*自动装配流程
    * 1.按照类型找到这个组件,
    *   1.0有且找到一个直接注入,名字无所谓
    *   1.1 如果找到多个,再按照名称进行匹配
    *
    * */
    @Autowired//自动装配 ,原理Spring调用容器的 getbean
    private Uersservice uersservice;

    @Autowired
    @Qualifier("zhangsan")//多个同类型bean时,指定要注入哪个名字的bean
    private Person person;
    @Autowired
    private List<Person> personList;//集合注入,把这个类型的所有组件都注入进去
    @Autowired
    private Map<String,Person> personMap;//集合注入,把这个类型的所有组件都注入进去

    @Autowired
    @Qualifier("zhangsan")//精确指定,指定要注入的bean的名字
    @Priority(1)//指定优先级,数字越小优先级越高
    private Person person1;

    private org.springframework.context.ApplicationContext applicationContext;
}
