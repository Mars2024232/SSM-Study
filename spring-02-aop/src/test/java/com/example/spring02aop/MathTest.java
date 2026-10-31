package com.example.spring02aop;

import com.example.spring02aop.calculator.MathCalculator;
import com.example.spring02aop.proxy.CalculatorStaticProxy;
import com.example.spring02aop.proxy.dynamic.DynamicProxy;
import com.example.spring02aop.service.UserService;
import com.example.spring02aop.service.impl.UserServiceimpl;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import static com.example.spring02aop.proxy.dynamic.DynamicProxy.getProxyInstance;

/**
 *
 */
public class MathTest {
    @Test
    void test01() {
        //真正有用的人,目标对象
        MathCaculatoriml mathCaculatoriml = new MathCaculatoriml();
        mathCaculatoriml.div(1, 2);
        System.out.println("===================");
        //1.创建代理对象
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new MathCaculatoriml());
        int div = proxy.div(1, 2);
        System.out.println("div = " + div);
        System.out.println("===================");
    }

    @Test
    void test02() {
        //1.原生对象
        MathCalculator target = new MathCaculatoriml();
        target.add(1, 2);

        //2.动态代理(Java 原生支持)
        /*
         * proxy:代理对象
         * method:准备调用目标对象方法
         * args:方法参数
         */
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("参数 = " + Arrays.toString(args));
                Object invoke = method.invoke(target, args);
                System.out.println("结果 = " + invoke);
                return invoke;
            }
        };

        /*ClassLoader loader,    目标对象的类加载器
          Class<?>[] interfaces, 目标对象的接口
          InvocationHandler h     代理对象的调用处理器
        */
        //3.创建动态代理对象
        MathCalculator calc = (MathCalculator) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);

        //4.通过代理对象调用方法,才会触发 handler.invoke
        int result = calc.add(1, 2);
        System.out.println("result = " + result);
    }


    @Test
    void test03() {
        MathCalculator proxyInstance = (MathCalculator) getProxyInstance(new MathCaculatoriml());
        proxyInstance.add(1, 2);
        UserService proxyInstance1 = (UserService)DynamicProxy.getProxyInstance(new UserServiceimpl());
        proxyInstance1.save();
    }
}
