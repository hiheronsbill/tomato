package com.mk.java.override;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/25 10:22
 * @Version V1.0
 **/
public class Father {

    public void say(String word) {
        print(word);
    }

    private void print(String str) {
        System.out.println("father-" + str);
    }

}
