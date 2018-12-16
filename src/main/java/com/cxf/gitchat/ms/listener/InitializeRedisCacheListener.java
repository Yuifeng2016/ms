package com.cxf.gitchat.ms.listener;

import com.cxf.gitchat.ms.util.RedisUtil;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

public class InitializeRedisCacheListener implements ApplicationListener<ApplicationReadyEvent  > {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        ConfigurableApplicationContext applicationContext = applicationReadyEvent.getApplicationContext();

        RedisUtil redisUtil = applicationContext.getBean(RedisUtil.class);
        if (redisUtil != null){
            redisUtil.initializeRedisData();
        }
    }
}
