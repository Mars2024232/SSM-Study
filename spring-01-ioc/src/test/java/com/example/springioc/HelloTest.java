package com.example.springioc;

import com.example.springioc.Dao.DEliveryDao;
import com.example.springioc.bean.User;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class HelloTest {
    @Autowired
    User user;
    @Autowired
    DEliveryDao dEliveryDao;
    @Test
    void test(){
        System.out.println(user);
        System.out.println(dEliveryDao);
    }
    @Test
    void test02(){
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }
}
