package com.example.mybatis01helloworld;

import com.example.mybatis01helloworld.bean.Customer;
import com.example.mybatis01helloworld.bean.Order;
import com.example.mybatis01helloworld.mapper.OrderCustomerStepMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StepTest {
@Autowired
    OrderCustomerStepMapper orderCustomerStepMapper;

//使用Mybatis的自动分布查询机制,自动调用

    @Test
    void contextLoads() {
        //按照id查询customer，
        Customer customerById = orderCustomerStepMapper.getCustomerById(1L);
        //按照customer_id查询orders，
        List<Order> ordersByCustomerId = orderCustomerStepMapper.getOrdersByCustomerId(customerById.getId());
        System.out.println(customerById);
        System.out.println(ordersByCustomerId);
    }
}
