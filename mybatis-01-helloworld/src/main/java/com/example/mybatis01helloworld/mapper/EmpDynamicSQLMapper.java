package com.example.mybatis01helloworld.mapper;


import com.example.mybatis01helloworld.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

//测试动态SQL
@Mapper
public interface EmpDynamicSQLMapper {
//1.按照员工的名字和薪资查询员工
    List<Emp> QueryEmpByEmpNameAndSalary(
            @Param("name") String name,
            @Param("salary") BigDecimal salary);

    void updateEmp(Emp emp);

    //trim:字符串截串.去空白

    //foreach:按id集合批量查询
    List<Emp> getEmpByIdIn(@Param("ids") List<Long> ids);

    //foreach:批量更新
    void updateEmps(@Param("emps") List<Emp> emps);
}
