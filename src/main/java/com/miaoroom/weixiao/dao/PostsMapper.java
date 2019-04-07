package com.miaoroom.weixiao.dao;

import com.miaoroom.weixiao.core.Mapper;
import com.miaoroom.weixiao.model.Posts;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@org.apache.ibatis.annotations.Mapper
@Repository
public interface PostsMapper extends Mapper<Posts> {

//    @Select("SELECT * FROM posts where post_author= #{post_author}")
//    @ResultMap("BaseResultMap")
// 取出在售的所有商品，最新的排前面
//    @Select("SELECT * FROM posts where post_author= #{post_author}")
//    @Results({
//            // 这里要对id进行限定，否则 id 会为 null
//            @Result(property = "postAuthor", column = "post_author"),
//
//            // 将 image 的 link 和 product 的 id 绑定，通过 @Many 查询 返回 List
//            @Result(property = "upvoteUserId", column = "post_author", javaType = List.class, many = @Many(select = "com.miaoroom.weixiao.dao.PostsMapper.getUpvoteByUserId")),
//    })
    List<Posts> findByPostAuthor(Long postAuthor);

    Posts findByPostId(Long PostId);

    List<Posts> getPostsOfType(String type);

    List<Posts> getPostsOfTypeAndPostAuthor(@Param("postsCat") String type,@Param("postsAuthor") Long postsAuthor);

    List<Posts> findAll();

    Integer deletePostByPostId(@Param("postId") Long postId);
}