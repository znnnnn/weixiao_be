package com.miaoroom.weixiao.web;

import com.miaoroom.weixiao.core.Result;
import com.miaoroom.weixiao.core.ResultGenerator;
import com.miaoroom.weixiao.dao.PostsMapper;
import com.miaoroom.weixiao.model.Posts;
import com.miaoroom.weixiao.service.PostsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/03/28.
*/
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Resource
    private PostsService postsService;

    @PostMapping
    public Result add(@RequestBody Posts posts) {
        postsService.save(posts);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        postsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Posts posts) {
        postsService.update(posts);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{postId}")
    public Result getPostsByPostId(@PathVariable Integer postId) {
//        Posts post = postsService.findBy("postId",Long.valueOf(postId));
        Posts posts = postsMapper.findByPostId(Long.valueOf(postId));
        return ResultGenerator.genSuccessResult(posts);

    }

    @Autowired
    PostsMapper postsMapper;

    @GetMapping("/user/{userId}")
    public Result getPostsByUserId(@PathVariable Integer userId) {
//        Posts posts = postsService.findById(id);
        System.out.println(userId);
        List<Posts> posts = postsMapper.findByPostAuthor(Long.valueOf(userId));
        return ResultGenerator.genSuccessResult(posts);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Posts> list = postsMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
