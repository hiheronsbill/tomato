package com.mk.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/25 11:21
 * @Version V1.0
 **/
public class ProxyHandler implements InvocationHandler {


    private HelloService helloService;

    public ProxyHandler(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        if (method.getName().equals("sayHello")) {
            System.out.println("proxy sayHello");
        }

        if (method.getName().equals("print")) {
            System.out.println("proxy print");
        }

        return method.invoke(helloService, args);
    }
}
