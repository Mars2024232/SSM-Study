package com.example.spring02aop;

import com.example.spring02aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;
/*
* 日志的实现方法
* 1.硬编码:不推荐,耦合(通用逻辑+专用逻辑),希望不耦合
* 2.静态代理,
*   定义:创建一个代理对象,包装这个组件以后业务的执行从代理开始,不直接调用组件
*   特点:定义期间就直接定义好了互相代理的关系
*
* */
@Component
public class MathCaculatoriml implements MathCalculator {
    @Override
    public int add(int a, int b) {
        //System.out.println("日志add开始:参数列表为:" + a + "," + b );
        int result = a + b;
        //System.out.println("日志add结束:结果为:" + result);
        return result;
    }

    @Override
    public int sub(int a, int b) {

        int result = a - b;

        return result;
    }

    @Override
    public int mul(int a, int b) {

        int result = a * b;

        return result;
    }

    @Override
    public int div(int a, int b) {

        int result = a / b;

        return result;
    }
}
