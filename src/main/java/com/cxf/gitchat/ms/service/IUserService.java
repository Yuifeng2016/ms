package com.cxf.gitchat.ms.service;

import com.cxf.gitchat.ms.entity.User;


import java.util.List;
import java.util.Map;

public interface IUserService {
     void registerUser(User user);

     User findByName(String name);
     List<User> findAllUsers();
     List<User> findUsersByPageAndPageSize(int currentPage, int pageSize);

     void addUser(User user);


     void updateUserAgeByUserId(Integer age,Integer userId);

     User getUserInfoByUserId(Integer userId);
     List<Map<String,Object>> queryUserCountByAge(int age);
}
