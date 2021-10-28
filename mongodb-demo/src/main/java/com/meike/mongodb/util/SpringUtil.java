package com.meike.mongodb.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware, EnvironmentAware {

    private static ApplicationContext applicationContext;
    private static Environment environment;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        if(SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;

        }
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }

    public static String getValue (String key) {
        return environment.getProperty(key);
    }

    @Override
    public void setEnvironment(Environment environment) {
        if (SpringUtil.environment == null) {
            SpringUtil.environment = environment;
        }
    }
}
