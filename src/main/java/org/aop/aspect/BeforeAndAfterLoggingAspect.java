package org.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class BeforeAndAfterLoggingAspect {

    @Before("execution(* org.aop.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] argObj = joinPoint.getArgs();
        String args = Arrays.toString(argObj);
        String methodName = signature.toShortString();
        log.info("Вызван метод: {}", methodName);
        log.info("Аргументы: {}", args);
    }

    @AfterReturning(pointcut = "execution(int org.aop.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, int result) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.toShortString();
        log.info("Метод завершил работу: {}", methodName);
        log.info("С результатом: {}", result);
    }

    @AfterThrowing(pointcut = "within(org.aop.service.*)", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().toShortString();
        String exceptionStr = ex.getMessage();
        log.error("Exception thrown in {} with {}", methodName, exceptionStr);
    }
}
