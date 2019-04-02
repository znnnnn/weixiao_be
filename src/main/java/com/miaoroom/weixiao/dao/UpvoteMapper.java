package com.miaoroom.weixiao.dao;

import com.miaoroom.weixiao.core.Mapper;
import com.miaoroom.weixiao.model.Upvote;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpvoteMapper extends Mapper<Upvote> {
//    @Select("SELECT * from upvote WHERE upvote_post_ID= #{upvote_post_ID}")
//    List<Upvote> getUpvoteByPostId(Integer upvotePostId);

//    @Select("SELECT * from upvote WHERE upvote_user_ID= #{upvote_user_ID}")
    List<Upvote> getUpvoteByUserId(Long upvoteUserId);

    Integer deleteUpvoteByUserId(@Param("postId") Long postId,@Param("userId") Long userId);
}