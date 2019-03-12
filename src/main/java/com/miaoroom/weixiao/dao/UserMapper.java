package com.miaoroom.weixiao.dao;

import com.miaoroom.weixiao.core.Mapper;
import com.miaoroom.weixiao.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {

    User findByUserLogin(String UserLogin);
    List<User> findByUserLogin();
}