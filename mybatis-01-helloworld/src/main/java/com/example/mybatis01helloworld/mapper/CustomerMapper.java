package com.example.mybatis01helloworld.mapper;

import com.example.mybatis01helloworld.bean.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    Customer getCustomerByIdWithOrder(Long id);

}
