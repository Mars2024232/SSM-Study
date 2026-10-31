package com.example.springmvcrestfulcrud.service.impl;

import com.example.springmvcrestfulcrud.bean.Employee;
import com.example.springmvcrestfulcrud.dao.EmployeeDao;
import com.example.springmvcrestfulcrud.service.EmployeeService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service//要求Controller和Service层的类必须使用@Component注解
@Component
public class EmployeeServiceimpl implements EmployeeService {
@Autowired
EmployeeDao employeeDao;//包装一下

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employeeById = employeeDao.getEmployeeById(id);

        return employeeById;
    }

    @Override
    public void deleteEmployeeById(Long id) {
employeeDao.deleteEmpById(id);

    }

    @Override
    public void updateEmployee(Employee employee) {
        //防空处理,考虑到service是被controller调用的,
        //controller传过来的某些属性可能为空,所以这里需要进行判断
        //1去数据库查询一下employee原来的值,
        //2.把页面带来的值覆盖,没带的属性保持原来的值额
        Long id = (long) employee.getId();
        if (id == null) {
            return; //如果id为空,直接返回
        }
        Employee employeeById = employeeDao.getEmployeeById(id);
        if (StringUtils.isEmpty(employee.getName())) {
            //把数据库中的name覆盖
            employeeById.setName(employee.getName());
        }
        if (StringUtils.isEmpty(employee.getEmail())) {
            //把数据库中的email覆盖
            employeeById.setEmail(employee.getEmail());
        }
        if (StringUtils.isEmpty(employee.getAddress())) {
            //把数据库中的address覆盖
            employeeById.setAddress(employee.getAddress());
        }
        if (StringUtils.isEmpty(employee.getGender())) {
            //把数据库中的gender覆盖
            employeeById.setGender(employee.getGender());
        }
        if (employee.getAge() != null) {
            //把数据库中的age覆盖
            employeeById.setAge(employee.getAge());
        }
        if (employee.getSalary() != null) {
            //把数据库中的salary覆盖
            employeeById.setSalary(employee.getSalary());
        }
        //更新数据库
        employeeDao.updateEmp(employeeById);
    }

    @Override
    public void saveEmployee(Employee employee) {
employeeDao.addEmp(employee);
    }

    //查询所有
    @Override
    public Iterable<Employee> getAllEmployees() {
        employeeDao.getAllEmployees();
        return null;
    }
}
