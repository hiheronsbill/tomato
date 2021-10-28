package com.meike.mongodb.controller;

import org.springframework.stereotype.Component;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/13 16:29
 * @Version V1.0
 **/


@Component
public class AccessTestAop implements AccessTest{


    @Override
    public void testNoArgs() {

        System.out.println("public");

        testDefault();

    }


    protected void testProtected() {
        System.out.println("protected");
    }

    void testDefault() {
        System.out.println("default");
    }

    private void testPrivate() {
        System.out.println("private");
    }

}
