package com.example.spring02aop.log;

public class LogUtil {
    public static void logStart(String name ,Object[] args) {
        System.out.println("[日志]" + name + "开始");
    }
    public static void logEnd(String name) {
        System.out.println("方法结束");
    }
    //异常
    public static void logException(String name,Exception e) {
        System.out.println("[日志]" + name + "发生异常" + e.getMessage());
    }
    //返回值
    public static void logReturn(String name,Object result) {
        System.out.println("[日志]" + name + "结果为:" + result);
    }
}
