package com.miaoroom.weixiao.service.impl;

import com.miaoroom.weixiao.dao.UpvoteMapper;
import com.miaoroom.weixiao.model.Upvote;
import com.miaoroom.weixiao.service.UpvoteService;
import com.miaoroom.weixiao.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/03/30.
 */
@Service
@Transactional
public class UpvoteServiceImpl extends AbstractService<Upvote> implements UpvoteService {
    @Resource
    private UpvoteMapper upvoteMapper;

}
