package com.example.mybatis01helloworld;

import com.example.mybatis01helloworld.bean.Emp;
import com.example.mybatis01helloworld.mapper.EmpParamMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ParamTest {
    @Autowired
    EmpParamMapper empParamMapper;

    @Test
    public void testGetEmploy() {
        Emp emp = empParamMapper.getEmploy(1L);
        System.out.println(emp);
    }
    @Test
    public void testGetEmploy02() {
        Emp emp = empParamMapper.getEmployByIdAndName(1L, "张三");
        System.out.println(emp);
    }
}
