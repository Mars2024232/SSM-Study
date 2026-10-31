package com.example.mybatis01helloworld.mapper;

import com.example.mybatis01helloworld.bean.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpReturnValueMapper {
    Long countEmp();
    BigDecimal getEmpSalaryById(Integer id);
    List<Emp> getAll(@Param("ids") List<Integer> ids);
    @MapKey("id")
    Map<Integer, Emp> getEmpInfoById();

}