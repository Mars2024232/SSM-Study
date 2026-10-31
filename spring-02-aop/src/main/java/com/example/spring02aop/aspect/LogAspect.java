package com.example.spring02aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.Arrays;
@Order(1)//数字越小优先级越高
@Component
@Aspect
//告诉Spring这是一个切面
public class LogAspect{


    @Pointcut("execution(int com.example.spring02aop.calculator.MathCalculator.* (..))")
    public void pointcut(){}
    //告诉spring一下通知方法何时何地运行
    /*
    何时?
    * @Before：目标方法执行之前执行
    * @After：目标方法执行之后执行
    * @AfterReturning：目标方法返回之后执行
    * @AfterThrowing：目标方法抛出异常之后执行
    * @Around：目标方法环绕执行,环绕通知,可以控制目标方法参数,执行结果


    *何地?
    切入点表达式
       execution(方法的全切名)
         全写法:[public] [int]   [com.example.spring02aop.calc.CalcImpl] .add(int i,int j)
        省略写法add(int , int )
        通配符: *
        ..表示任意多个参数
        最省略的方法* *( )


        通知方法的执行顺序:
        1.正常链路 :前置通知 >目标方法 >返回通知 >后置通知
        2.异常链路 :前置通知 >目标方法 >异常通知


        JoinPoint joinPoint:连接点里面包装了方法的所有信息

    */
    @Before("pointcut()")
    public void logstart(JoinPoint joinPoint){
        //拿到方法签名
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("[切面-日志]["+methodName+"]开始...参数:"+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointcut()")
    public void logend(JoinPoint joinPoint){
        System.out.println("[切面-日志]结束...");
    }
    @AfterReturning(value = "pointcut()",returning = "result")
    public void logreturn(JoinPoint joinPoint , Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("[切面-日志]["+signature.getName()+"]返回...结果:"+result);
    }
    @AfterThrowing(value = "pointcut()",throwing = "exception")
    public void logException(JoinPoint joinPoint , Exception exception){
        System.out.println("[切面-日志]["+joinPoint.getSignature().getName()+"]异常...异常信息:"+exception);
    }
   //参数带什么就切
    @Before("args(int,int)")
    void haha(){
        System.out.println("切面日志..哈哈");
    }
    //
    @Before("@args(com.example.spring02aop.Annotation.MyAn&&within(com.example.spring02aop.service.UserService" +
            "))")
    void hehe(){
        System.out.println("切面日志..呵呵");
    }
}
