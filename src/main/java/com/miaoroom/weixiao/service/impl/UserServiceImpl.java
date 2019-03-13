package com.miaoroom.weixiao.service.impl;

import com.miaoroom.weixiao.dao.UserMapper;
import com.miaoroom.weixiao.model.User;
import com.miaoroom.weixiao.service.UserService;
import com.miaoroom.weixiao.core.AbstractService;
import com.miaoroom.weixiao.shiro.ShiroKit;
import com.miaoroom.weixiao.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/03/12.
 */
@Service
@Transactional
@Slf4j
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

    @Override
    public String login(User user) {
        //获取参数中的用户名密码
        String userLogin = user.getUserLogin();
        String userPass = user.getUserPass();
//        获取数据库中的用户对象
        User userFromDb = userMapper.findByUserLogin(userLogin);
        String salt = userFromDb.getUserSalt();
//        生成加密密码
        String encodedUserPass = ShiroKit.md5(userPass, userLogin + salt);

//        log.info("数据库密码:{}",userFromDb.getUserPass());
//        log.info("本次加密密码:{}",encodedUserPass);
//        log.info("密码是否正确:{}",userFromDb.getUserPass().equals(encodedUserPass));
//        log.info("token本次:{}",userFromDb.getUserPass().equals(encodedUserPass) ? JWTUtil.sign(userLogin, encodedUserPass) : null);
        return userFromDb.getUserPass().equals(encodedUserPass) ? JWTUtil.sign(userLogin, encodedUserPass) : null;
    }
}
