package com.mk.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/8/26 10:06
 * @Version V1.0
 **/

@SpringBootApplication
@EnableScheduling
public class CommonJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonJavaApplication.class, args);
    }
}
