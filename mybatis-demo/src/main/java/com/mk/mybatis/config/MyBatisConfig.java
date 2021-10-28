package com.mk.mybatis.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/27 13:41
 * @Version V1.0
 **/


@Configuration
@MapperScan("com.mk.mybatis.mapper")
public class MyBatisConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        StatFilter statFilter = new StatFilter();
        statFilter.setLogSlowSql(true);
        statFilter.setSlowSqlMillis(500);
        dataSource.setProxyFilters(Arrays.asList(statFilter));
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager mysqlTransactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        return sessionFactory.getObject();
    }
}
