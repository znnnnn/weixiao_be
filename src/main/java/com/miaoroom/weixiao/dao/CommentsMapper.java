package com.miaoroom.weixiao.dao;

import com.miaoroom.weixiao.DTO.CommentsUsermetaDTO;
import com.miaoroom.weixiao.core.Mapper;
import com.miaoroom.weixiao.model.Comments;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsMapper extends Mapper<Comments> {
    List<CommentsUsermetaDTO> CommentsUsermetaDTOMap();
    List<CommentsUsermetaDTO> findCommentUsermeta(Long commentPostId);
    Integer deleteCommentsByCommentId(@Param("commentId") Long commentId);
}