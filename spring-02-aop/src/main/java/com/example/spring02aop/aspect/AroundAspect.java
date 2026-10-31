package com.example.spring02aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AroundAspect {
    @Pointcut("execution(int com.example.spring02aop.calculator.MathCalculator.* (..))")
    public void pointcut(){}

    /*环绕通知固定写法如下
    public Object aroundAdvice(Proceeding pjp)throw Throwable
    Objcect 返回值
    ProceddingJoinPoint 可以继续推进的切点
    */
@Around("pointcut() ")

    public Object aroundAdvice (ProceedingJoinPoint pjd) throws Throwable{
        Object[] args = pjd.getArgs();//获取目标方法参数

        System.out.println("环绕-前置通知 "+ Arrays.toString(args));
        Object proceed=null;

        //接受传参的参数,实现修目标方法执行用的参数
        try {
             proceed = pjd.proceed(args);//继续执行目标方法
        }
        catch (Exception e){
            System.out.println("环绕-异常通知"+e.getMessage());
        }
        System.out.println("环绕-返回通知"+proceed);

        //修改返回值
        System.out.println("环绕-后置通知");
        return proceed;
    }
}
