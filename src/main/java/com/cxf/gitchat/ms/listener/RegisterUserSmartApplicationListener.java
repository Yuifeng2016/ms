package com.cxf.gitchat.ms.listener;

import com.cxf.gitchat.ms.event.UserRegisterEvent;
import com.cxf.gitchat.ms.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserSmartApplicationListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == UserRegisterEvent.class;
    }
    /**
     * 注意此处aClass不能与IUserService.class比较
     * @param aClass
     * @return
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == UserServiceImpl.class;
    }
    /**
     * 返回值越小监听越靠前
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        UserRegisterEvent userRegisterEvent = (UserRegisterEvent) applicationEvent;
        System.out.println("实现接口SmartApplicationListener监听用户注册事件并向用户发送邮件");
        System.out.println("注册用户名：" + userRegisterEvent.getUser().getName());
    }
}
