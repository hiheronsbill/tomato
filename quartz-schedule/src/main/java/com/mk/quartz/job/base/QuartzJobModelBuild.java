package com.mk.quartz.job.base;

import com.mk.quartz.config.QuartzJobModel;

/**
 * @Desc 生成job的参数模型，每个job都需要实现
 * @Author zhxy
 * @Date 2021/8/22 23:50
 * @Version V1.0
 **/
public interface QuartzJobModelBuild {


    /**
     * 生成jobModel
     *
     * @return
     */
    QuartzJobModel buildJobModel();

}
