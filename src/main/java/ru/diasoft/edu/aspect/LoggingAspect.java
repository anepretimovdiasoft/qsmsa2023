package ru.diasoft.edu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution (* ru.diasoft.edu.service.HelloServiceImpl.*(..))")
    public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Логгирование перед вызовом метода : ");
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("Аргументы метода : ");
        System.out.println(Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed();

        System.out.println("Логгирование после вызова метода");
        System.out.println(joinPoint.getSignature().getName());

        System.out.println("Результат работы метода : " + result);

        return result;
    }
}
