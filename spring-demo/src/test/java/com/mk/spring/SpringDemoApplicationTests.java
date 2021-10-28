package com.mk.spring;

import com.mk.spring.service.BeanInject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDemoApplicationTests {

    @Autowired
    private BeanInject beanInjectBye;


    @Test
    public void test(){
        beanInjectBye.say("maycur");
        System.out.println(beanInjectBye.getClass().getName());
    }



    @Test
    void contextLoads() {
    }

}
