package com.meike.mongodb.entity;

import java.lang.reflect.Field;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/14 16:10
 * @Version V1.0
 **/
public class TestReflect {


    public static void main(String[] args) {


        Employee employee = new Employee();


        try {
            Field tenantCode = employee.getClass().getSuperclass().getDeclaredField("tenantCode");
            tenantCode.setAccessible(true);
            String o = (String)tenantCode.get(employee);
            System.out.println(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
