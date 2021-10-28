package com.mk.quartz.service.impl;

import com.mk.quartz.config.QuartzJobModel;
import com.mk.quartz.service.QuartzJobService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc quartzJob任务管理服务
 * @Author zhxy
 * @Date 2021/8/22 23:13
 * @Version V1.0
 **/
@Service
public class QuartzJobServiceImpl implements QuartzJobService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzJobServiceImpl.class);

    @Autowired
    private Scheduler scheduler;

    @Override
    public void addJob(QuartzJobModel jobModel) {
        try {
            //1 构建job信息
            Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(jobModel.getJobClass());
            JobDetail jobDetail = JobBuilder.newJob(jobClass)
                    .withIdentity(jobModel.getJobName(), jobModel.getJobGroup())
                    .build();
            //2 表达式调度构建器(即任务执行的时机)
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobModel.getCron());
            //3 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(jobModel.getTriggerName(), jobModel.getTriggerGroup())
                    .withSchedule(scheduleBuilder)
                    .build();
            //4 获得JobDataMap，写入数据
            if (jobModel.getParams() != null) {
                trigger.getJobDataMap().putAll(jobModel.getParams());
            }
            //5 加入调度器执行
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            LOGGER.error("创建任务失败", e);
        }
    }

    @Override
    public void pauseJob(QuartzJobModel jobModel) {
        try {
            scheduler.pauseJob(JobKey.jobKey(jobModel.getJobName(), jobModel.getJobGroup()));
        } catch (SchedulerException e) {
            LOGGER.error("暂停任务失败", e);
        }
    }

    @Override
    public void resumeJob(QuartzJobModel jobModel) {
        try {
            scheduler.resumeJob(JobKey.jobKey(jobModel.getJobName(), jobModel.getJobGroup()));
        } catch (SchedulerException e) {
            LOGGER.error("恢复任务失败", e);
        }
    }

    @Override
    public void updateJob(QuartzJobModel jobModel) {
        try {
            //1 获取原job的trigger
            TriggerKey triggerKey = TriggerKey.triggerKey(jobModel.getTriggerName(), jobModel.getTriggerGroup());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (jobModel.getCron() != null) {
                //2 按新的cron表达式重新构建trigger
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobModel.getCron());
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            }
            //3 设置附加参数
            if (jobModel.getParams() != null) {
                trigger.getJobDataMap().putAll(jobModel.getParams());
            }
            //4 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (Exception e) {
            LOGGER.error("更新任务失败", e);
        }
    }

    @Override
    public void deleteJob(QuartzJobModel jobModel) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobModel.getTriggerName(), jobModel.getTriggerGroup());
            //暂停、移除、删除
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(JobKey.jobKey(jobModel.getJobName(), jobModel.getJobGroup()));
        } catch (Exception e) {
            LOGGER.error("删除任务失败", e);
        }
    }

    @Override
    public void start() {
        try {
            scheduler.start();
        } catch (Exception e){
            LOGGER.error("调度器启动失败", e);
        }
    }
}
