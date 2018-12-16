package com.cxf.gitchat.ms.controller;

import com.cxf.gitchat.ms.service.impl.PublishRedisMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private PublishRedisMessage publishRedisMessage;

    @RequestMapping("/publishMessage")
    public String publishRedisMessage(String channel,String msg){
        return  publishRedisMessage.publishMessage(channel,msg);
    }
}
