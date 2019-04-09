package com.miaoroom.weixiao.dao;

import com.miaoroom.weixiao.core.Mapper;
import com.miaoroom.weixiao.model.Topic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicMapper extends Mapper<Topic> {
    Topic getTopicByTopicName(@Param("topicName") String topicName);
}