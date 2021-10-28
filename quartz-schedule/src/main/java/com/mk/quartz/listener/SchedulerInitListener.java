package com.mk.quartz.listener;

import com.mk.quartz.job.base.BaseJob;
import com.mk.quartz.service.QuartzJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/8/22 14:39
 * @Version V1.0
 **/

@Component
public class SchedulerInitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private QuartzJobService quartzJobService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        try {
            String[] beanNames = applicationContext.getBeanNamesForType(BaseJob.class);
            for (String beanName : beanNames) {
                quartzJobService.addJob(applicationContext.getBean(beanName, BaseJob.class).buildJobModel());
            }
            quartzJobService.start();
        } catch (Exception e) {

        }
    }
}
