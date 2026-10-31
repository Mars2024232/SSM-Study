package com.example.mybatis01helloworld.bean;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private Long id;
    private String customerName;
    private String phone;

    private List<Order> orders;
}
