package com.example.springmvcrestfulcrud;

import com.example.springmvcrestfulcrud.bean.Employee;
import com.example.springmvcrestfulcrud.dao.EmployeeDao;
import com.example.springmvcrestfulcrud.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeDaotest {
    @Autowired
    EmployeeDao employeeDao;
    EmployeeService employeeService;
    @Test
    void EmployeeDao() {
        Employee employeeById = employeeDao.getEmployeeById(1L);
        System.out.println("employeeById = " + employeeById);

    }

    @Test
    //测试EmployeeService
    void EmployeeService() {

    }
}
