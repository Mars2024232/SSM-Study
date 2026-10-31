package com.example.springmvcrestfulcrud.dao;

import com.example.springmvcrestfulcrud.bean.Employee;

import java.util.List;

public interface EmployeeDao {
    /*
     * 根据ID查询员工信息
     * */
    Employee getEmployeeById(Long id);
    /*
    * 新增员工
    * */
    void addEmp(Employee employee);
    /*
    * 更改员工信息
    * */
    void updateEmp(Employee employee);
    /*
    * 按照ID删除员工
    * */
    void deleteEmpById(Long id);

    List<Employee> getAllEmployees();
}
