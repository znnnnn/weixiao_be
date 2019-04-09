package com.miaoroom.weixiao.web;

import com.miaoroom.weixiao.core.Result;
import com.miaoroom.weixiao.core.ResultGenerator;
import com.miaoroom.weixiao.dao.TopicMapper;
import com.miaoroom.weixiao.model.Topic;
import com.miaoroom.weixiao.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/04/08.
 */
@RestController
@RequestMapping("/topic")
public class TopicController {
    @Resource
    private TopicService topicService;

    @Autowired
    private TopicMapper topicMapper;

    @PostMapping
    public Result add(@RequestBody Topic topic) {
        Topic topicFromDatabase= topicService.findBy("topicName", topic.getTopicName());
        if (topicFromDatabase == null) {
            topicService.save(topic);
            return ResultGenerator.genSuccessResult();
        }
        if (!topic.getTopicThumb().equals("[]")){
            topicFromDatabase.setTopicThumb(topic.getTopicThumb());
            topicService.update(topicFromDatabase);
        }
        return ResultGenerator.genSuccessResult("该话题已存在，所以不创建");

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        topicService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Topic topic) {
        topicService.update(topic);
        return ResultGenerator.genSuccessResult();
    }

//    @GetMapping("/{id}")
//    public Result detail(@PathVariable Integer id) {
//        Topic topic = topicService.findById(id);
//        return ResultGenerator.genSuccessResult(topic);
//    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Topic> list = topicService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/topicName")
    public Result getTopicByTopicName(@RequestParam String topicName) {
        Topic topic = topicMapper.getTopicByTopicName(topicName);
        return ResultGenerator.genSuccessResult(topic);
    }
}
