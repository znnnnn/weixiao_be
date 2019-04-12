package com.miaoroom.weixiao.dao;

import com.miaoroom.weixiao.DTO.UserWithUsermetaDTO;
import com.miaoroom.weixiao.core.Mapper;
import com.miaoroom.weixiao.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {

    User findByUserLogin(String UserLogin);

    UserWithUsermetaDTO findUserWithUsermetaDTOByUserLogin(String userLogin);

//    List<User> findByUserLogin();
}