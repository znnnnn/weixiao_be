package com.miaoroom.weixiao.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.miaoroom.weixiao.Tester;
import com.miaoroom.weixiao.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceImplTest extends Tester {

    @Autowired
    UserService userService;

    @Test
    public void validateCode() {
    }

    @Test
    public void sendSMS() throws ClientException {
        userService.sendSMS("15372868305","注册");
    }
}