package com.cxf.gitchat.ms.service.impl;

import org.springframework.stereotype.Component;

@Component
public class PublishRedisMessage {

    public String publishMessage(String channel, String msg){
        return  "channel: "+ channel + " msg: "+ msg;
    }
}
