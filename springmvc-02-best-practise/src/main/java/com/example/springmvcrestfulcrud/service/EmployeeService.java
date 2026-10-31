package com.example.springmvcrestfulcrud.service;

import com.example.springmvcrestfulcrud.bean.Employee;

public interface EmployeeService {
//根据id查询员工信息
    Employee getEmployeeById(Long id);
//根据id删除员工信息
    void deleteEmployeeById(Long id);
//更新员工信息
    void updateEmployee(Employee employee);
//保存员工信息
    void saveEmployee(Employee employee);
//查询所有员工信息
    Iterable<Employee> getAllEmployees();
}

