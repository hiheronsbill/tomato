package com.mk.quartz.config;

import lombok.Data;

import java.util.Map;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/8/22 23:01
 * @Version V1.0
 **/

@Data
public class QuartzJobModel {

    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务组名
     */
    private String jobGroup;
    /**
     * 任务执行类
     */
    private String jobClass;
    /**
     * cron表达式
     */
    private String cron;
    /**
     * 触发器名称
     */
    private String triggerName;
    /**
     * 触发器组名
     */
    private String triggerGroup;

    /**
     * 附加参数
     */
    private Map<String, Object> params;

    public static QuartzJobModel create() {
        return new QuartzJobModel();
    }

    public QuartzJobModel withJobClass(String jobClass) {
        this.jobClass = jobClass;
        return this;
    }

    public QuartzJobModel withJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public QuartzJobModel withJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
        return this;
    }

    public QuartzJobModel withCron(String cron) {
        this.cron = cron;
        return this;
    }

    public QuartzJobModel withTriggerName(String triggerName){
        this.triggerName = triggerName;
        return this;
    }

    public QuartzJobModel withTriggerGroup(String triggerGroup){
        this.triggerGroup = triggerGroup;
        return this;
    }

    public String getTriggerName() {
        return triggerName == null ? jobName : triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup == null ? jobGroup : triggerGroup;
    }
}
