package com.miaoroom.weixiao.service.impl;

import com.miaoroom.weixiao.dao.UsermetaMapper;
import com.miaoroom.weixiao.model.Usermeta;
import com.miaoroom.weixiao.service.UsermetaService;
import com.miaoroom.weixiao.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/03/10.
 */
@Service
@Transactional
public class UsermetaServiceImpl extends AbstractService<Usermeta> implements UsermetaService {
    @Resource
    private UsermetaMapper usermetaMapper;

}
