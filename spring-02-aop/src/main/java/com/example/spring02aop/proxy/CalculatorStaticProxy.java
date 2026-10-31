package com.example.spring02aop.proxy;

import com.example.spring02aop.calculator.MathCalculator;
import lombok.Data;

@Data
/*
* 静态代理
*  定义:代理对象,是目标对象的接口的子类型,代理对象本身不是目标对象,而是将目标对象作为自己的属性,定义期间就决定好了关系
*  优点:同一种类型的对象可以直接代理
*  缺点:代理对象和目标对象耦合度高,如果目标对象有多个,需要为每个目标对象创建一个代理对象
*
* 动态代理  运行期间才决定代理关系(拦截器拦截所有)
*    定义:目标对象在执行时,才会被动态拦截,插入指定逻辑
* 优点:代理对象和目标对象解耦合,目标对象有多个,只需要创建一个代理对象
* */
public class CalculatorStaticProxy implements MathCalculator {
    private MathCalculator target; // 目标对象
    public CalculatorStaticProxy(MathCalculator mc) {
        target = mc; // 调用目标对象的方法
    }

    @Override
    public int add(int a, int b) {
        System.out.println("日志add开始:参数列表为:" + a + "," + b );
        int result = target.add(a, b);
        System.out.println("日志add结束:结果为:" + result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("日志sub开始:参数列表为:" + a + "," + b );
        int result = target.sub(a, b);
        System.out.println("日志sub结束:结果为:" + result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("日志mul开始:参数列表为:" + a + "," + b );
        int result = target.mul(a, b);
        System.out.println("日志mul结束:结果为:" + result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("日志div开始:参数列表为:" + a + "," + b );
        int result = target.div(a, b);
        System.out.println("日志div结束:结果为:" + result);
        return result;
    }
}
