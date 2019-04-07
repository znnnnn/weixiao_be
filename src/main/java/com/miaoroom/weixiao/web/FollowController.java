package com.miaoroom.weixiao.web;

import com.miaoroom.weixiao.core.Result;
import com.miaoroom.weixiao.core.ResultGenerator;
import com.miaoroom.weixiao.dao.FollowMapper;
import com.miaoroom.weixiao.model.Follow;
import com.miaoroom.weixiao.service.FollowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/04/07.
 */
@RestController
@RequestMapping("/follow")
public class FollowController {
    @Resource
    private FollowService followService;

    @Autowired
    private FollowMapper followMapper;

    @PostMapping
    public Result add(@RequestBody Follow follow) {
        followService.save(follow);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping
    public Result delete(@RequestParam Long userId, @RequestParam Long followUserId) {
        followMapper.deleteFollowByUserId(userId, followUserId);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Follow follow) {
        followService.update(follow);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Follow follow = followService.findById(id);
        return ResultGenerator.genSuccessResult(follow);
    }

    @GetMapping("/user/{userId}")
    public Result findFollowByUserId(@PathVariable Long userId) {
        List<Follow> list = followMapper.findFollowByUserId(userId);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/user/mine/{userId}")
    public Result findMineFollowByUserId(@PathVariable Long userId) {
        List<Follow> list = followMapper.findMineFollowByUserId(userId);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Follow> list = followService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
