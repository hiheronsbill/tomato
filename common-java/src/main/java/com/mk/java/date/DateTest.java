package com.mk.java.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/13 11:40
 * @Version V1.0
 **/
public class DateTest {

    public static void main(String[] args) {


        Date date = new Date();

        System.out.println(date.getTime());
        System.out.println(date.getDay());

        System.out.println("----------------------------");

        LocalDate now = LocalDate.now();
        System.out.println(now);

        System.out.println(now.minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00")));

    }
}
