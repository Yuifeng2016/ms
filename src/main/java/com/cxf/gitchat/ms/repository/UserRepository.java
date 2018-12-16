package com.cxf.gitchat.ms.repository;

import com.cxf.gitchat.ms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByName(String  name);

    @Modifying
    @Query(value = "update user set user_age = ?1 where id = ?2",nativeQuery = true)
    void updateUserInfoByUserId(Integer age,Integer userId);

    @Query(value = "select * from user where id = ?1",nativeQuery = true)
    User queryUserInfoById(Integer userId);

    @Query(value = "select user_age,COUNT(*) as count from user where user_age < ?1 group by user_age",nativeQuery = true)
    List<Object[]> getUserCount(Integer age);
}
