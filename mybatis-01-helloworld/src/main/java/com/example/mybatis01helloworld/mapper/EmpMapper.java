package com.example.mybatis01helloworld.mapper;

import com.example.mybatis01helloworld.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//告诉spring mybatis，这个接口是mybatis操作数据库的接口
public interface EmpMapper {
    //按照id查询
    Emp getEmpById(Integer id);

    //查询所有员工
    List<Emp> getAllEmps();

    //添加员工
    void addEmp(Emp emp);

    //删除员工
    void deleteEmp(Integer id);

    //修改员工
    void updateEmp(Emp emp);
}
