package com.cxf.gitchat.ms.listener;

import com.cxf.gitchat.ms.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncAnnotationUserRegisterListener {

    /**
     * 在需要执行异步监听方法上面添加 @Async注解
     * @param userRegisterEvent
     */
    @Async
    @EventListener
    public void sendMailToUser(UserRegisterEvent userRegisterEvent){
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("利用@EventListener注解监听用户注册事件并异步向用户发送邮件");
    }
}
