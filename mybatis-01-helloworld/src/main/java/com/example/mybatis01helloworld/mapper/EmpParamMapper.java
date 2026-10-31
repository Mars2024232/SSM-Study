package com.example.mybatis01helloworld.mapper;

import com.example.mybatis01helloworld.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper//告诉spring mybatis，这个接口是mybatis操作数据库的接口
public interface EmpParamMapper {
    Emp getEmploy(Long id);

    List<Emp> getEmploy02(@Param("ids") List<Long> ids);

    void addEmploy(Emp e);

    void addEmploy2(Map<String, Object> m);


    /*==========以上是按照单个参数查询测试==========*/

    Emp getEmployByIdAndName(@Param("id") Long id, @Param("name") String name);
}