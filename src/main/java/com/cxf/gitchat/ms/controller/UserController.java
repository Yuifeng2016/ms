package com.cxf.gitchat.ms.controller;

import com.cxf.gitchat.ms.entity.User;
import com.cxf.gitchat.ms.service.IUserService;
import com.cxf.gitchat.ms.service.RedisUserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    IUserService userService;
    @Resource
    RedisUserService redisUserService;
    @Resource
    RedisTemplate redisTemplate;

    @GetMapping("/register")
    public String registUser(@NonNull String userName, @NonNull Integer age){
        String msg = "success";

        try {
            userService.registerUser(new User(userName,age));
        }catch (Exception e){
            msg = "error";
            e.printStackTrace();
        }
        return msg;
    }

    @GetMapping("/queryUserByName")
    public User queryUserByName(String name){
        return userService.findByName(name);
    }
    @GetMapping("/queryAllUsers")
    public List<User> queryAllUsers() {
        return userService.findAllUsers();
    }
    @GetMapping("/queryUsersPaged")
    public List<User> queryUsersPaged(Integer currentPage, Integer pageSize){
        return userService.findUsersByPageAndPageSize(currentPage,pageSize);
    }

    @RequestMapping("/updateUserAgeById")
    public String updateUserAgeById(Integer age, Integer userId) {
        userService.updateUserAgeByUserId(age, userId);
        return "success";
    }

    @RequestMapping("/queryUserByUserId")
    public User queryUserByUserId(Integer userId) {
        return userService.getUserInfoByUserId(userId);
    }

    @GetMapping("addUser")
    public String addUser(String name,Integer age){
        userService.addUser(new User(name,age));
        return "success";
    }

    @RequestMapping("/queryUserCountByAge")
    public List<Map<String,Object>> updateUserAgeById(Integer age) {
        return userService.queryUserCountByAge(age);
    }

    @RequestMapping("/saveUserInfoIntoRedis")
    public String saveUserInfoIntoRedis(String name,Integer age){
        User user = new User(name,age);
        user.setUuid(UUID.randomUUID().toString());


        return redisUserService.saveUserInfo(user);
    }

    @RequestMapping("/getUserInfoFromRedis")
    public User saveUserInfoIntoRedis(String uuid){

        return redisUserService.getUserInfo(uuid);
    }

}
