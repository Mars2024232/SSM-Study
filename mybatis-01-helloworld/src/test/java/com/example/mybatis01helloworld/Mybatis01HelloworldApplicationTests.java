package com.example.mybatis01helloworld;

import com.example.mybatis01helloworld.bean.Emp;
import com.example.mybatis01helloworld.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 *
 */
@SpringBootTest
class Mybatis01HelloworldApplicationTests {
    @Autowired
    EmpMapper empMapper;

    @Test
    void contextLoads() {
        Emp empById =
                empMapper.getEmpById(1);
        System.out.println("empById = " + empById);
    }
@Test
    void testcrud() {
        Emp emp = new Emp();
        emp.setEmpName("张三");
        emp.setAge(25);
        emp.setEmpSalary(5000.0);
        empMapper.addEmp(emp);
        Emp empById =
                empMapper.getEmpById(1);
        System.out.println("empById = " + empById);
    }
    @Test
    //测试查询所有
    void testfindAll() {
        List<Emp> allEmps = empMapper.getAllEmps();
        allEmps.forEach(System.out::println); //使用forEach遍历集合并打印每个元素
    }
}
