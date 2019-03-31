package com.miaoroom.weixiao.dao;

import com.miaoroom.weixiao.Tester;
import com.miaoroom.weixiao.model.Posts;
import com.miaoroom.weixiao.service.UpvoteService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: znnnnn
 * Date: 2019-03-30
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class PostsMapperTest extends Tester {
    @Autowired
    private PostsMapper postsMapper;

    @Autowired
    private UpvoteMapper upvoteMapper;


    @Test
    public void findByAuthor() {
//        System.out.println(111111111);
        List<Posts> posts = postsMapper.findByPostAuthor(25L);
//        if (posts != null) System.out.println(posts);
//        else System.out.println("null");

//        System.out.println(upvoteMapper.getUpvoteByUserId(15L).get(0).getUpvoteUserId());


//        List<Posts> posts = postsMapper.findAll();
//        System.out.println(posts.get(0).getPostContent());
    }

}