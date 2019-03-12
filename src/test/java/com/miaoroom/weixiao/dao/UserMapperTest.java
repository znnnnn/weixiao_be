package com.miaoroom.weixiao.dao;

import com.miaoroom.weixiao.Tester;
import com.miaoroom.weixiao.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest extends Tester {

    @Autowired
    UserMapper userMapper;

    @Test
    public void findByUserLogin() {
        User user =  userMapper.findByUserLogin("leonl");
        System.out.println(user.getUserLogin());
//        System.out.println(user);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}