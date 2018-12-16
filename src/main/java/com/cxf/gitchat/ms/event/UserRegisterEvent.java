package com.cxf.gitchat.ms.event;

import com.cxf.gitchat.ms.entity.User;
import org.springframework.context.ApplicationEvent;

/**
 * 定义事件类
 */
public class UserRegisterEvent extends ApplicationEvent {
    private User user;

    public UserRegisterEvent(Object source, User user){
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
