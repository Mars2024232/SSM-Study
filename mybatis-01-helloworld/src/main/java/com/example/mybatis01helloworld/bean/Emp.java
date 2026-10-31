package com.example.mybatis01helloworld.bean;

import lombok.Data;

@Data
public class Emp {
    //开启驼峰命名自动封装映射
    private Integer id;
    private String empName;
    private Integer age;
    private Double empSalary;
}
