package com.thoughtworks.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class UserAspect {
    @Pointcut("execution(* com.thoughtworks.repository.UserServiceImpl.postUser(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("Before");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("Afterreturning");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("Afterthrowing");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        joinPoint.proceed();
        System.out.println("around after");
    }


}
