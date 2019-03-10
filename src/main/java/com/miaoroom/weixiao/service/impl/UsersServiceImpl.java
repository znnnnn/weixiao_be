package com.miaoroom.weixiao.service.impl;

import com.miaoroom.weixiao.dao.UsersMapper;
import com.miaoroom.weixiao.model.Users;
import com.miaoroom.weixiao.service.UsersService;
import com.miaoroom.weixiao.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/03/10.
 */
@Service
@Transactional
public class UsersServiceImpl extends AbstractService<Users> implements UsersService {
    @Resource
    private UsersMapper usersMapper;

}
