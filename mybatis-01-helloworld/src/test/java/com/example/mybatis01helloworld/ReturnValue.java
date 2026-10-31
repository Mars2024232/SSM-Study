package com.example.mybatis01helloworld;

import com.example.mybatis01helloworld.mapper.EmpReturnValueMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
/*
* 和数据库对不上的字段封装为null
* 如何解决?
* 1.使用列别名
* 2.使用驼峰自动命名映射
* 3.使用resultMap(自定义结果集)
*
* */
@SpringBootTest
public class ReturnValue {
    @Autowired
    EmpReturnValueMapper empReturnValueMapper;
    @Test
    void test() {
        Long l = empReturnValueMapper.countEmp();
        System.out.println(l);
    }
}
