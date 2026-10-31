package com.example.mybatis01helloworld.mapper;

import com.example.mybatis01helloworld.bean.Customer;
import com.example.mybatis01helloworld.bean.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderCustomerStepMapper {
    //需求:按照id查客户
    //1.查询客户
    Customer getCustomerById(Long id);
    //2.查询订单
    List<Order> getOrdersByCustomerId(Long id);
    //这里假设有一个OrderCustomerStepMapper接口，用于查询订单和客户
    //3.封装客户和订单



    //分布:自动查询客户和订单
    Customer getCustomerByIdAndStep(Long id);

    //分布查询,自动做两步按照id查询订单,以及下单的客户
    Order getOrderByCustomerIdAndStep(Long id);

}
