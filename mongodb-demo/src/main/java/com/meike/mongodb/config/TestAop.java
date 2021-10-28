package com.meike.mongodb.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/14 13:37
 * @Version V1.0
 **/
@Component
@Aspect
public class TestAop {


    @Pointcut("execution(* com.meike.mongodb.controller.AccessTestAop.*(..))")
    public void testAccess(){}




    @Around("testAccess()")
    public void AccessAround(ProceedingJoinPoint joinPoint){
        try {
            joinPoint.proceed();
        }catch (Throwable e){

        }

    }


}
