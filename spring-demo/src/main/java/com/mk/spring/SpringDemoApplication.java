package com.mk.spring;

import com.mk.spring.service.BeanInject;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class SpringDemoApplication implements ApplicationContextAware {


    private static ApplicationContext applicationContext;


    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
        String[] beanNames = applicationContext.getBeanNamesForType(BeanInject.class);
        for (String beanName : beanNames) {
            System.out.println(beanName + "   ----   " + applicationContext.getBean(beanName));
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
