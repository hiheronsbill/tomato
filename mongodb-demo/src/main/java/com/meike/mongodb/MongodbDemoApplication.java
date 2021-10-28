package com.meike.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication()
public class MongodbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbDemoApplication.class, args);
    }

}
