package com.cxf.gitchat.ms.service.impl;

import com.cxf.gitchat.ms.entity.User;
import com.cxf.gitchat.ms.service.RedisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("redisUserServiceImpl")
public class RedisUserServiceImpl implements RedisUserService {
    @Autowired
    RedisTemplate redisTemplate ;

    @Override
    public User getUserInfo(String uuid) {
        return (User) redisTemplate.opsForValue().get(uuid);
    }

    @Override
    public String saveUserInfo(User user) {
        redisTemplate.opsForValue().set(user.getUuid(),user);
        return user.getUuid();

    }
}
