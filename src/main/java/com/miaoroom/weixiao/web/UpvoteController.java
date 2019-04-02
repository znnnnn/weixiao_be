package com.miaoroom.weixiao.web;

import com.miaoroom.weixiao.core.Result;
import com.miaoroom.weixiao.core.ResultGenerator;
import com.miaoroom.weixiao.dao.UpvoteMapper;
import com.miaoroom.weixiao.model.Upvote;
import com.miaoroom.weixiao.service.UpvoteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/03/30.
*/
@RestController
@RequestMapping("/upvote")
public class UpvoteController {
    @Resource
    private UpvoteService upvoteService;

    @PostMapping
    public Result add(@RequestBody Upvote upvote) {
        upvoteService.save(upvote);
        return ResultGenerator.genSuccessResult();
    }

//    @DeleteMapping("/{id}")
//    public Result delete(@PathVariable Integer id) {
//        upvoteService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }

    @Autowired
    private UpvoteMapper upvoteMapper;

    @DeleteMapping
    public Result deleteByUserId(@RequestParam Long postId, @RequestParam Long userId) {
//        System.out.println(postId);
//        System.out.println(userId);
        Integer isDeleted =  upvoteMapper.deleteUpvoteByUserId(postId,userId);
        return ResultGenerator.genSuccessResult(isDeleted);
    }

    @PutMapping
    public Result update(@RequestBody Upvote upvote) {
        upvoteService.update(upvote);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Upvote upvote = upvoteService.findById(id);
        return ResultGenerator.genSuccessResult(upvote);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Upvote> list = upvoteService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
