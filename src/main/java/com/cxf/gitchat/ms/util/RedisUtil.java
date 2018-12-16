package com.cxf.gitchat.ms.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class RedisUtil {
    Logger logger  = LoggerFactory.getLogger(RedisUtil.class);

    public void initializeRedisData(){
//        System.out.println("正在初始化Redis数据");
        logger.info("正在初始化Redis数据");
    }
}
