package com.ex.seed.aop;

import com.ex.seed.annotations.ActionLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class ServiceLogAspect {


    @Pointcut("@annotation(com.ex.seed.annotations.ActionLog)")
    public void servicePointCut() {}

    @Around("servicePointCut() && @annotation(log)")
    public Object logAround(ProceedingJoinPoint jp, ActionLog log) {
        Object result = null;
        try {
            result = jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }




}
