package com.cxf.gitchat.ms.service;

import com.cxf.gitchat.ms.entity.User;

/**
 * 利用Redis持久化用户信息
 */
public interface RedisUserService {
    /**
     * 根据用户uuid获取用户信息
     * @param uuid
     * @return
     */
    User getUserInfo(String uuid);

    /**
     * 将用户信息存入Redis
     * @param user
     */
    String saveUserInfo(User user);
}
