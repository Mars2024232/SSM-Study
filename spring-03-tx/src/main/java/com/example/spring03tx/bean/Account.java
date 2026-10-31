package com.example.spring03tx.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
  private Integer id;
  private String name;
  private Integer age;
  private BigDecimal balance;

}
