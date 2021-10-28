package com.mk.quartz.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/17 14:05
 * @Version V1.0
 **/

@Component
public class DruidUtil {

    @Autowired
    private DataSource dataSource;




    public void getPoolSize(){
        if(dataSource != null){
            DruidDataSource druidDataSource = (DruidDataSource) dataSource;
            System.out.println("数据库最大连接数：" + druidDataSource.getMaxActive());
            System.out.println("数据库初始化连接数：" + druidDataSource.getInitialSize());
        }
    }

}
