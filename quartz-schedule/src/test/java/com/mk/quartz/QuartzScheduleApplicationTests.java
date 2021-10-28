package com.mk.quartz;

import com.mk.quartz.demo.HelloJob;
import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuartzScheduleApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() throws SchedulerException {

        // 1、定时任务调度对象
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // 2、定义一个工作对象，设置job名称与组名
        JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();

        // 3、定义一个触发器,设置trigger名称与组名，每5秒触发一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?")).build();
//         SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()

        // 4、注册trigger并启动scheduler
        scheduler.scheduleJob(job, trigger);
        // 5、开始定时任务
        scheduler.start();


    }

}
