package com.miaoroom.weixiao.service.impl;

import com.miaoroom.weixiao.dao.UserMapper;
import com.miaoroom.weixiao.model.User;
import com.miaoroom.weixiao.service.UserService;
import com.miaoroom.weixiao.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/03/12.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean isRepeated(String userLogin) {
        if (null == userMapper.findByUserLogin(userLogin)) {
            return true;
        } else {
            return false;
        }
    }
}
