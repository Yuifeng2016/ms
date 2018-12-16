package com.cxf.gitchat.ms.service.impl;

import com.cxf.gitchat.ms.entity.User;
import com.cxf.gitchat.ms.event.UserRegisterEvent;
import com.cxf.gitchat.ms.repository.UserRepository;
import com.cxf.gitchat.ms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private ApplicationContext applicationContext;
    /**
     * 用户注册
     * @param user
     */
    @Override
    public void registerUser(User user) {
        if (user != null){
            //调用持久层注册用户

            //发布用户注册事件
            //applicationContext.publishEvent(new UserRegisterEvent(this,user ));
        }
    }
    @Autowired
    private UserRepository userDao;

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll(new Sort(Sort.Direction.DESC,"age"));
    }

    /**
     * 对用户年龄降序排列并实现分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public List<User> findUsersByPageAndPageSize(int currentPage, int pageSize) {
        Sort ageSort = new Sort(Sort.Direction.DESC,"age");

        Pageable pageable = PageRequest.of(currentPage,pageSize,ageSort);

        Page<User> page = userDao.findAll(pageable);

        if (page != null){
            return page.getContent();
        }

        return null;
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void updateUserAgeByUserId(Integer age, Integer userId) {
        userDao.updateUserInfoByUserId(age,userId);
    }

    @Override
    public User getUserInfoByUserId(Integer userId) {
        return userDao.queryUserInfoById(userId );
    }

    @Override
    public List<Map<String, Object>> queryUserCountByAge(int age) {
        List<Object[]> list = userDao.getUserCount(age);

        if (!CollectionUtils.isEmpty(list)){
            List<Map<String ,Object>> mapList = new ArrayList<Map<String ,Object>>();

            for (Object[] objects:list) {
                Map<String ,Object> map  = new HashMap<String ,Object>();
                map.put("age",objects[0]);
                map.put("userCount",objects[1]);
                mapList.add(map);
            }
            return mapList;

        }
        return null;
    }
}
