package com.miaoroom.weixiao.web;

import com.miaoroom.weixiao.DTO.CommentsUsermetaDTO;
import com.miaoroom.weixiao.core.Result;
import com.miaoroom.weixiao.core.ResultGenerator;
import com.miaoroom.weixiao.dao.CommentsMapper;
import com.miaoroom.weixiao.model.Comments;
import com.miaoroom.weixiao.service.CommentsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/03/29.
*/
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Resource
    private CommentsService commentsService;

    @Autowired
    private CommentsMapper commentsMapper;

    @PostMapping
    public Result add(@RequestBody Comments comments) {
        commentsService.save(comments);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        commentsMapper.deleteCommentsByCommentId(Long.valueOf(id));
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Comments comments) {
        commentsService.update(comments);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Comments comments = commentsService.findById(id);
        return ResultGenerator.genSuccessResult(comments);
    }

    @GetMapping("/posts/{commentPostId}")
    public Result getCommentsListByPostId(@PathVariable Long commentPostId) {
        List<CommentsUsermetaDTO> comments = commentsMapper.findCommentUsermeta(commentPostId);
        return ResultGenerator.genSuccessResult(comments);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Comments> list = commentsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
