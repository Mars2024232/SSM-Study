package com.example.springmvc.controller;

import com.example.springmvc.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class RequestTestController {
/*  要求:变量名和参数名必须一致
*   请求参数:username="zhangsan" password=12334564987 agreement=on
*    1.没有携带的,包装类型自动封装为NULL,基础类型为默认值
*    2.携带:自动封装
*
* @return
* */
    @RequestMapping("/handle01")
    public String handle01(String username,
                           String password,
                           String cellphone,
                           boolean agreement){
        System.out.println(username);
        System.out.println(password);
        System.out.println(cellphone);
        System.out.println(agreement);
        return "ok";
}

/*
* @RequestParam("username") String name
* 将username参数封装到name中
* 1.用RequestParam取出的参数,默认一定要有值,
* 1).required = false设置非必须携带
* 2)defaultValue="123546"  设置默认值,非必要可以不带
* */
    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String name,
                           @RequestParam(value = "password",defaultValue="123546") String pwd,
                           @RequestParam("cellphone") String phone,
                           @RequestParam(value = "agreement",required = false) boolean ok){
        System.out.println(name);
        System.out.println(pwd);
        System.out.println(phone);
        System.out.println(ok);
        return "ok";
    }
/*
* 如果目标方法是一个pojo,springMVC会自动把参数和pojo属性进行匹配
* 效果:
*   1.pojo的所有属性值全部来自请求参数
*   2.如果请求参数没带,直接封装为null
* */
    @RequestMapping("/handle03")
    public String handle03(Person person){
        System.out.println(new Person());
        return "ok";
    }
    /*获取请求头*/
@RequestMapping("/handle04")
    public String handle04(@RequestHeader("host") String host){
    System.out.println(host);
    return "ok";
}
/*获取cookie的值*/
@RequestMapping("/handle05")
public String handle05( @CookieValue("haha") String haha){
    System.out.println(haha);
    return "ok";
}
/*@RequestBody 获取请求体的Json对象,自动转换为person对象
  测试接受Json数据
  1.发出
*/

@RequestMapping("/handle07")
    public String handle07(@RequestBody Person person){
    return "ok";
}
/*Multipartfile专门封装文件
* 接受文件请求
*
* */
    @RequestMapping("/handle08")
public String handle08(Person person,
      @RequestParam("headImg") MultipartFile file,
       @RequestParam("lifeImg ")MultipartFile[] life) throws IOException {
        //1.获取原始文件名
         String originalFilename = file.getOriginalFilename();
        //2.获取文件大小
        long size = file.getSize();
        //3.获取文件流
        InputStream inputStream = file.getInputStream();
        //4.文件保存
        file.transferTo(new File("D"));

        for (int i = life.length - 1; i >= 0; i--) {

        }

        System.out.println(person);
        return "ok";
    }
    /*
    * HttpENtity:封装请求头,请求体,把整个请求拿来
    * 泛型:<String>,请求体类型
    * */
    @RequestMapping("/handle09")
    public String handle09(HttpEntity<String> httpEntity){
        httpEntity.getHeaders();
        httpEntity.getBody();
        return "";
    }
    @RequestMapping
    public String handle10(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletRequest.getCookies();
        return "";
    }

}
