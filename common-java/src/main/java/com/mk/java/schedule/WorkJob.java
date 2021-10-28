package com.mk.java.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/8/26 10:12
 * @Version V1.0
 **/

@Component
public class WorkJob {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private List<Integer> index = Arrays.asList(8 * 1000, 3 * 1000, 6 * 1000, 2 * 1000, 2 * 1000);

    private AtomicInteger count = new AtomicInteger();

//    @Scheduled(cron = "0/5 * * * * ?")
    public void work() throws InterruptedException {
        if (count.get() < 5) {
            Integer sleep = index.get(count.get());
            logger.info("第{}个任务开始执行，执行时间为{}ms", count.get(), sleep);
            Thread.sleep(sleep);
            count.getAndIncrement();
        }
    }


}
