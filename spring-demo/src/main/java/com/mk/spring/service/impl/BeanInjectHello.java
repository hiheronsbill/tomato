package com.mk.spring.service.impl;

import com.mk.spring.service.BeanInject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/13 11:11
 * @Version V1.0
 **/

@Service
@ConditionalOnProperty(value = "bean.inject",havingValue = "hello")
public class BeanInjectHello implements BeanInject {
    @Override
    public void say(String word) {
        System.out.println("hello " + word);
    }
}
