package com.example.spring02aop;

import com.example.spring02aop.calculator.MathCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spring02AopApplicationTests {

    //设计模式,依赖接口而非实现

    @Autowired
    MathCalculator mathCalculator;
    @Test
    void contextLoads() {
        int div = mathCalculator.div(1, 1);
        System.out.println("div = " + div);
    }

}
