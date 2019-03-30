package com.miaoroom.weixiao.service.impl;

import com.miaoroom.weixiao.DTO.PostsListItemDTO;
import com.miaoroom.weixiao.dao.PostsMapper;
import com.miaoroom.weixiao.model.Posts;
import com.miaoroom.weixiao.service.PostsService;
import com.miaoroom.weixiao.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/03/28.
 */
@Service
@Transactional
public class PostsServiceImpl extends AbstractService<Posts> implements PostsService {
    @Resource
    private PostsMapper postsMapper;

    @Override
    public PostsListItemDTO getPostsList() {
        return null;
    }
}
