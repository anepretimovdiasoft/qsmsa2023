package ru.diasoft.edu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution (* ru.diasoft.edu.service.HelloServiceImpl.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(
                "Логгирование перед вызовом метода : " + joinPoint.getSignature().getName()
        );
    }

    @After("execution (* ru.diasoft.edu.service.HelloServiceImpl.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(
                "Логгирование после вызова метода : " + joinPoint.getSignature().getName()
        );
    }

    @AfterReturning(
            pointcut = "execution (* ru.diasoft.edu.service.HelloServiceImpl.*(..))",
            returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println(
                "Логгирование после возврата значения из : " + joinPoint.getSignature().getName()
        );
        System.out.println("Метод вернул : " + result);
    }

    @AfterThrowing(
            pointcut = "execution (* ru.diasoft.edu.service.HelloServiceImpl.*(..))",
            throwing = "error"
    )
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println(
                "Логгирование выброса исключения методом : " + joinPoint.getSignature().getName()
        );
        System.out.println("Возникшее исключение : " + error);
    }
}
