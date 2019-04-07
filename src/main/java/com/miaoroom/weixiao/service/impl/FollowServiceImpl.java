package com.miaoroom.weixiao.service.impl;

import com.miaoroom.weixiao.dao.FollowMapper;
import com.miaoroom.weixiao.model.Follow;
import com.miaoroom.weixiao.service.FollowService;
import com.miaoroom.weixiao.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/04/07.
 */
@Service
@Transactional
public class FollowServiceImpl extends AbstractService<Follow> implements FollowService {
    @Resource
    private FollowMapper followMapper;

}
