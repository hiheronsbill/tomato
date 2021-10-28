package com.mk.quartz.demo;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/8/21 12:18
 * @Version V1.0
 **/
public class QuartzTest {


    public static void main(String[] args) {


        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            scheduler.start();

            scheduler.shutdown();
        } catch (Exception e) {

        }


    }
}
