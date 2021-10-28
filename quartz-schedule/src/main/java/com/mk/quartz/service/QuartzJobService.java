package com.mk.quartz.service;

import com.mk.quartz.config.QuartzJobModel;

/**
 * @Desc quartzJob任务管理服务
 * @Author zhxy
 * @Date 2021/8/22 22:50
 * @Version V1.0
 **/
public interface QuartzJobService {

    /**
     * 新增任务
     * @param jobModel
     */
    void addJob(QuartzJobModel jobModel);

    /**
     * 暂停任务
     * @param jobModel
     */
    void pauseJob(QuartzJobModel jobModel);

    /**
     * 暂停任务
     * @param jobModel
     */
    void resumeJob(QuartzJobModel jobModel);

    /**
     * 更新任务
     * @param jobModel
     */
    void updateJob(QuartzJobModel jobModel);

    /**
     * 删除任务
     * @param jobModel
     */
    void deleteJob(QuartzJobModel jobModel);

    /**
     * 启动任务调度器
     */
    void start();

}
