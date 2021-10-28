package com.mk.quartz.config;

import org.quartz.Scheduler;
import org.quartz.spi.JobFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Arrays;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/8/22 14:30
 * @Version V1.0
 **/

@Configuration
public class QuartzConfig {

    /**
     * 创建jobFactory
     *
     * @return
     */
    @Bean
    public JobFactory jobFactory() {
        return new AutowireJobFactory();
    }

    /**
     * 创建scheduler工厂bean
     *
     * @param jobFactory
     * @return
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, DataSource dataSource) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setDataSource(dataSource);
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setStartupDelay(10);  // QuartzScheduler 延时启动，应用启动完后 QuartzScheduler 再启动
        schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true);   // 这样当spring关闭时，会等待所有已经启动的quartz job结束后spring才能完全shutdown。

        return schedulerFactoryBean;
    }

    /**
     * 创建自定义调度器
     *
     * @param schedulerFactoryBean
     * @return
     */
    @Bean("scheduler")
    public Scheduler quartzScheduler(SchedulerFactoryBean schedulerFactoryBean) {
        return schedulerFactoryBean.getScheduler();
    }

}
