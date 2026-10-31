package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class requestMappingLimitController {

    /*
     * 请求方式
     * GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE;
     * PostMan
     * */
    @RequestMapping(value = "/test01", method = RequestMethod.POST)
    public String test01() {
        return "hello world";
    }

    /*
     * 请求参数params={"username","age"}
     * 1).username,表示请求必须包括username参数
     * 2)age=18,表示请求参数必须包含age=18的参数
     * 3)gender!=1
     * */
    @RequestMapping(value = "/test02", params = {"age=18", "username", "gender!=1"})
    public String test02() {
        return "test02";
    }

    /*
     * 请求头: headers="haha
     * 1)表示请求头中必须有haha
     * 2)
     * "*/
    @RequestMapping(value = "/test03", headers = "haha")
    public String test03() {
        return "test03";
    }

    /*请求内容类型,consunms={application/json} consunem:消费了什么数据
     * media Type
     * 表示浏览器必须携带json格式的数据
     *
     * */
    @RequestMapping(value = "/test04", consumes = "application/json-")
    public String test04() {
        return "test04";
    }
/*指定浏览器响应什么类型数据*/
    @RequestMapping(value = "/test05", produces = "text/html;charset=utf-8")
    public String test05() {
        return "<h1>你好</h1>";
    }
}
