package com.mk.java.override;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/25 10:23
 * @Version V1.0
 **/
public class Son extends Father{

    public void print(String str) {
        System.out.println("son-" + str);
    }


    public static void main(String[] args) {
        Father father = new Son();
        father.say("hello");
    }
}
