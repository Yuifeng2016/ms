package com.cxf.gitchat.ms.listener;

import com.cxf.gitchat.ms.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 实现ApplicationListener实现用户注册监听
 */
@Component
public class RegisterUserApplicationListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println("实现接口ApplicationListener监听用户注册事件并向用户发送邮件");
        System.out.println("注册用户名：" + userRegisterEvent.getUser().getName());
    }
}
