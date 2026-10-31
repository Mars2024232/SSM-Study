package com.example.mybatis01helloworld;


import com.example.mybatis01helloworld.bean.Customer;
import com.example.mybatis01helloworld.bean.Order;
import com.example.mybatis01helloworld.mapper.CustomerMapper;
import com.example.mybatis01helloworld.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JoinQueryTest {
    @Autowired
    OrderMapper orderMapper; // Autowired the OrderMapper interface to inject the OrderMapper bean into the test class.
@Autowired
    CustomerMapper customerMapper; // Autowired the CustomerMapper interface to inject the CustomerMapper bean into the test class.
    @Test
    void test01() {
        Order order = orderMapper.getOrderByIdWithCustomer(1L);
        System.out.println("order = " + order);
    }
    @Test
    void test02() {
        Customer customer = customerMapper.getCustomerByIdWithOrder(1L);
        System.out.println("customer = " + customer);
}
}

