package com.mk.java.proxy;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/25 11:20
 * @Version V1.0
 **/
public class HelloServicesImpl implements HelloService{


    @Override
    public String sayHello(String word) {
        print(word);
        return "say";
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

}
