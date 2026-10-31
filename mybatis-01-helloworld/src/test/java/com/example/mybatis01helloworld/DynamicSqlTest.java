package com.example.mybatis01helloworld;

import com.example.mybatis01helloworld.bean.Emp;
import com.example.mybatis01helloworld.mapper.EmpDynamicSQLMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DynamicSqlTest {

    @Autowired
    EmpDynamicSQLMapper empDynamicSQLMapper;

    @Test
    public void testQueryEmpByEmpNameAndSalary() {
    empDynamicSQLMapper.QueryEmpByEmpNameAndSalary("John Doe",null); // Example usage
    }
    @Test
    void test02(){
        List<Emp> empByIdIn = empDynamicSQLMapper.getEmpByIdIn(List.of(1L, 2L, 3L));
        empByIdIn.forEach(System.out::println);


    }
}
