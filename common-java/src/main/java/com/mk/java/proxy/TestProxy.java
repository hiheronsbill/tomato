package com.mk.java.proxy;

import java.lang.reflect.Proxy;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/25 11:24
 * @Version V1.0
 **/
public class TestProxy {


    public static void main(String[] args) {

        HelloServicesImpl hello = new HelloServicesImpl();
        ProxyHandler proxyHandler = new ProxyHandler(hello);

        HelloService helloService = (HelloService)Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(),proxyHandler);

        helloService.print("aaaa");

        System.out.println("----------------------");

        helloService.sayHello("bbbbb");


    }


}
