package org.springframework.data.mongodb.core;

import com.meike.mongodb.util.TenantHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/15 16:49
 * @Version V1.0
 **/

@Component
@Aspect
@Order(1)
public class MongoAllAop {

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.*(..))")
    public void judgeTenantCode() {
    }

    @Around("judgeTenantCode()")
    public Object judgeTenantCodeAround(ProceedingJoinPoint joinPoint) {
        if (StringUtils.isEmpty(TenantHolder.currentTenant())) {

        }
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        Method[] methods = MongoTemplateAop.class.getMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }


        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
