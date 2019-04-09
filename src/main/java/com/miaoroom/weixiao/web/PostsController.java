package com.miaoroom.weixiao.web;

import com.miaoroom.weixiao.core.Result;
import com.miaoroom.weixiao.core.ResultGenerator;
import com.miaoroom.weixiao.dao.CommentsMapper;
import com.miaoroom.weixiao.dao.PostsMapper;
import com.miaoroom.weixiao.dao.UpvoteMapper;
import com.miaoroom.weixiao.model.Posts;
import com.miaoroom.weixiao.model.Topic;
import com.miaoroom.weixiao.service.PostsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miaoroom.weixiao.service.TopicService;
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

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private UpvoteMapper upvoteMapper;

    @Autowired
    private TopicService topicService;

    @PostMapping
    public Result add(@RequestBody Posts posts) {
        postsService.save(posts);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        postsMapper.deletePostByPostId(id);
        commentsMapper.deleteCommentsByPostId(id);
        upvoteMapper.deleteUpvoteByUpvotePostId(id);
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
//        System.out.println(userId);
        List<Posts> posts = postsMapper.findByPostAuthor(Long.valueOf(userId));
        return ResultGenerator.genSuccessResult(posts);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "dynamic") String type) {
        PageHelper.startPage(page, size);
        List<Posts> list = postsMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据类别获取文章
     *
     * @param page
     * @param size
     * @param type
     * @return
     */
    @GetMapping("/type")
    public Result getPostsOfType(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "dynamic") String type) {
        PageHelper.startPage(page, size);
        List<Posts> list = postsMapper.getPostsOfType(type);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据用户获取不同类别的文章
     *
     * @param page
     * @param size
     * @param type
     * @param postsAuthor
     * @return
     */
    @GetMapping("/type/user")
    public Result getPostsOfTypeAndPostAuthor(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "dynamic") String type, @RequestParam(defaultValue = "dynamic") Long postsAuthor) {
        PageHelper.startPage(page, size);
        List<Posts> list = postsMapper.getPostsOfTypeAndPostAuthor(type, postsAuthor);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 获取话题列表
     *
     * @param page
     * @param size
     * @param topicName
     * @return
     */
    @GetMapping("/topic")
    public Result getTopicList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam String topicName) {
        Topic topic = topicService.findBy("topicName", topicName);
        if (topic != null) {
            topic.setTopicHot(topic.getTopicHot() + 1);
            topicService.update(topic);
        }
        PageHelper.startPage(page, size);
        List<Posts> list = postsMapper.getTopicList(topicName);
        PageInfo pageInfo = new PageInfo(list);
//        每查询一次，增加一次热度
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    /**
     * 获取最近发表中的文章的一幅图片
     * @param topicName
     * @return
     */
//    @GetMapping("/topic/thumb")
//    public Result getTopicThumb(@RequestParam String topicName) {
//        List<Posts> url = postsMapper.getTopicThumb(topicName);
////        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(url);
//    }
}
