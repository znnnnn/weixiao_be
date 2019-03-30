package com.miaoroom.weixiao.service.impl;

import com.miaoroom.weixiao.dao.CommentsMapper;
import com.miaoroom.weixiao.model.Comments;
import com.miaoroom.weixiao.service.CommentsService;
import com.miaoroom.weixiao.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/03/29.
 */
@Service
@Transactional
public class CommentsServiceImpl extends AbstractService<Comments> implements CommentsService {
    @Resource
    private CommentsMapper commentsMapper;

}
