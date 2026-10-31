package com.example.springmvcrestfulcrud.dao.impl;

import com.example.springmvcrestfulcrud.bean.Employee;
import com.example.springmvcrestfulcrud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoimpl implements EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee getEmployeeById(Long id) {
        String sql = "select * from users where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    @Override
    public void addEmp(Employee users) {
        String sql = "insert into users(name, age, email, gender, address, salary) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                users.getName(), users.getAge(), users.getEmail(),
                users.getGender(), users.getAddress(), users.getSalary());
    }

    @Override
    public void updateEmp(Employee users) {
        String sql = "update users set name=?, age=?, email=?, gender=?, address=?, salary=? where id=?";
        jdbcTemplate.update(sql,
                users.getName(), users.getAge(), users.getEmail(),
                users.getGender(), users.getAddress(), users.getSalary(),
                users.getId());
    }

    @Override
    public void deleteEmpById(Long id) {
        String sql = "delete from users where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "select * from users";
        List<Employee> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        return employees;
    }
}
