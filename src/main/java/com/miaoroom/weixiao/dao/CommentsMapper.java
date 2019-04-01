package com.miaoroom.weixiao.dao;

import com.miaoroom.weixiao.DTO.CommentsUsermetaDTO;
import com.miaoroom.weixiao.core.Mapper;
import com.miaoroom.weixiao.model.Comments;

import java.util.List;

public interface CommentsMapper extends Mapper<Comments> {
    List<CommentsUsermetaDTO> CommentsUsermetaDTOMap();
}