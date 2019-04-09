package com.miaoroom.weixiao.service.impl;

import com.miaoroom.weixiao.dao.TopicMapper;
import com.miaoroom.weixiao.model.Topic;
import com.miaoroom.weixiao.service.TopicService;
import com.miaoroom.weixiao.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/04/08.
 */
@Service
@Transactional
public class TopicServiceImpl extends AbstractService<Topic> implements TopicService {
    @Resource
    private TopicMapper topicMapper;

}
