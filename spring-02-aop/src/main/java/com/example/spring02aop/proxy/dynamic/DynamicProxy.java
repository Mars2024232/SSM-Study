package com.example.spring02aop.proxy.dynamic;

import com.example.spring02aop.log.LogUtil;

import java.lang.reflect.Proxy;


/*

 动态代理,JDK动态代理,强制要求,目标对象必须要有接口,代理的也只是接口规定的方法

 */
public class DynamicProxy {
    public static Object getProxyInstance(Object target) {

      return   Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                 (proxy, method, args) -> {
                     String name = method.getName();
                    //记录开始
                     LogUtil.logStart(name, args);
                     Object result = null;
                     try {
                         result = method.invoke(target, args);
                         //记录返回值
                       LogUtil.logReturn(name, result);
                     }
                     catch (Exception e) {
                         LogUtil.logException(name, e);
                     }
                     finally {
                         LogUtil.logEnd(name  );
                     }
                     return result;
                }
                );
    }
}