package com.mk.logger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/24 19:35
 * @Version V1.0
 **/

@RestController
public class LogController {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);


    @RequestMapping("/log")
    public void runLog() throws Exception{
        while (true){
            Thread.sleep(10);
            LOGGER.info("QWERTYUIOPASDFGHJKLZXCVBNM`1234567890");
        }

    }

}
