package com.miaoroom.weixiao.dao;

import com.miaoroom.weixiao.Tester;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: znnnnn
 * Date: 2019-03-21
 * Time: 22:06
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UsermetaMapperTest extends Tester {

    @Resource
    private UsermetaMapper usermetaMapper;

    @Autowired
    private UserMapper userMapper;

}