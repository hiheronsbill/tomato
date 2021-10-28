package com.mk.java.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/8/17 19:36
 * @Version V1.0
 **/
public class TestLambda {



    @Test
    public void testMap(){


        String[] ids = new String[]{"1234","weterg","sgrgfhh"};

        String str = "sfsdgsdgg,asdgsgd,sdgsdgdg";

        List<String> collect = Arrays.stream(str.split(",")).map(s -> convert(s)).collect(Collectors.toList());
        System.out.println(collect);


    }


    private String convert(String str){
        return str + "-11111111";
    }


}
