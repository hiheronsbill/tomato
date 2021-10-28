package com.mk.java.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/1 13:45
 * @Version V1.0
 **/
public class ConverterNull {

    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();

        list = null;


        System.out.println((List) list);

        String str = "abc";
        str = null;

        System.out.println(((String) str) == null);

    }
}
