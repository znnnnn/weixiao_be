package com.miaoroom.weixiao.dao;

import com.miaoroom.weixiao.core.Mapper;
import com.miaoroom.weixiao.model.Follow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowMapper extends Mapper<Follow> {
    List<Follow> findFollowByUserId(@Param("userId") Long userId);

    List<Follow> findMineFollowByUserId(@Param("userId") Long userId);

    Integer deleteFollowByUserId(@Param("userId") Long userId, @Param("followUserId") Long followUserId);
}