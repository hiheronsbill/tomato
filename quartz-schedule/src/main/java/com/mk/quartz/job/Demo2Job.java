package com.mk.quartz.job;

import com.mk.quartz.config.QuartzJobModel;
import com.mk.quartz.job.base.BaseJob;
import com.mk.quartz.utils.DateUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/8/22 23:55
 * @Version V1.0
 **/


@Component
public class Demo2Job extends BaseJob {

    @Override
    public QuartzJobModel buildJobModel() {
        return QuartzJobModel.create()
                .withJobClass("com.mk.quartz.job.Demo2Job")
                .withCron("* * 10 * * ?")
                .withJobName("job2")
                .withJobGroup("group2")
                .withTriggerName("trigger2")
                .withTriggerGroup("triggerGroup2");
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        StringJoiner joiner = new StringJoiner(" demo2 开始执行 -- ")
//                .add(this.hashCode() + "")
                .add("-- jobName: " + context.getTrigger().getJobKey().getName())
                .add("-- jobGroup: " + context.getTrigger().getJobKey().getGroup())
                .add("-- triggerName: " + context.getTrigger().getKey().getName())
                .add("-- triggerGroup: " + context.getTrigger().getKey().getGroup())
                .add(DateUtil.simpleDateFormat.format(new Date()));
        System.out.println(joiner);
    }
}
