package com.thoughtworks.aspect;

import com.thoughtworks.domain.ValueHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class ValueHolderAspect {
    @Autowired
    ValueHolder<String> valueHolder;

    @Before("execution(* com.thoughtworks.repository.ValueHolderInterfaceImpl.beforeValueHolder(..))")
    public void before() {
        valueHolder.setValue(valueHolder.getValue() + "AspectBefore ");
    }

    @After("execution(* com.thoughtworks.repository.ValueHolderInterfaceImpl.afterValueHolder(..))")
    public void after() {
        valueHolder.setValue(valueHolder.getValue() + "AspectAfter ");
    }

    @AfterReturning("execution(* com.thoughtworks.repository.ValueHolderInterfaceImpl.afterReturningValueHolder(..))")
    public void afterReturning() {
        valueHolder.setValue(valueHolder.getValue() + "AspectAfterReturning ");
    }

    @AfterThrowing("execution(* com.thoughtworks.repository.ValueHolderInterfaceImpl.afterThrowingValueHolder(..))")
    public void afterThrowing() {
        valueHolder.setValue(valueHolder.getValue() + "AspectAfterThrowing ");
    }

    @Around("execution(* com.thoughtworks.repository.ValueHolderInterfaceImpl.aroundValueHolder(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        valueHolder.setValue(valueHolder.getValue() + "Aspect Aspect Before ");
        joinPoint.proceed();
        valueHolder.setValue(valueHolder.getValue() + "Aspect Aspect After ");
    }


}
