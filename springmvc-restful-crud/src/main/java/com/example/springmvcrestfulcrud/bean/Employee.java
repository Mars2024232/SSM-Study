package com.example.springmvcrestfulcrud.bean;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonPropertyOrder({"id", "name", "age", "email", "gender", "address", "salary"})
public class Employee {
    private int id;
    private  String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
}
