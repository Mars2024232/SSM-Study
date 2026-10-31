package com.example.mybatis01helloworld.service;

import com.example.mybatis01helloworld.bean.Emp;
import com.example.mybatis01helloworld.mapper.EmpDynamicSQLMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    EmpDynamicSQLMapper empDynamicSQLMapper;
@Transactional
    void updateEmps(List<Emp> emps) {
    empDynamicSQLMapper.updateEmps(emps);
    }
}
