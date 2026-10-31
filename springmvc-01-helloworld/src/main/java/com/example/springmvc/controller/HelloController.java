package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//ResponseBody
//Controller
//告诉Spring这是一个控制器
@RestController//前后分离开发就用
public class HelloController {
    /*
    * 路径位置通配匹配符:多个优先精确匹配
    *    *:匹配任意多个字符
    *   **:匹配任意多层路径
    *    ?:匹配任意单个字符
    *
    *  精确程度排名: 完全匹配>?>*>**
    * */

    @RequestMapping("/hello")
    @ResponseBody//把返回值放到响应体里面,每次请求进来执行目标方法
public String handle(){
        System.out.println("handle()方法执行了");
    return "Hello Spring MVC 你好";//默认认为返回值就是跳转到一个页面
}
@RequestMapping("/hell?")
    public String handl01(){
        System.out.println("handle01()方法执行了");
        return "handle01";//默认认为返回值就是跳转到一个页面
    }
    @RequestMapping("/hell*")
    public String handl02(){
        System.out.println("handle02()方法执行了");
        return "handle02";//默认认为返回值就是跳转到一个页面
    }

}
