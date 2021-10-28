package com.mk.java.enmu;

import java.util.Arrays;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/18 14:33
 * @Version V1.0
 **/
public class TestEnum {


    public static void main(String[] args) {

        Student student = new Student();
        student.setName("11");
//        student.setCustomBillSource(CustomBillSource.CLOUD_INVOICE_STATEMENT);


        CustomBillSource[] values = CustomBillSource.values();
        if(Arrays.asList(CustomBillSource.values()).contains(student.getCustomBillSource())){
            System.out.println(" i  have ..");
        }

    }
}
