package com.example.mybatis01helloworld.mapper;

import com.example.mybatis01helloworld.bean.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    //按照id查询订单以及下单的用户信息
     Order getOrderByIdWithCustomer(Long id);
}
