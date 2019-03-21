package com.miaoroom.weixiao.web;

import com.miaoroom.weixiao.DTO.SetUsermeta;
import com.miaoroom.weixiao.core.Result;
import com.miaoroom.weixiao.core.ResultGenerator;
import com.miaoroom.weixiao.model.Usermeta;
import com.miaoroom.weixiao.service.UsermetaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/03/21.
*/
@RestController
@RequestMapping("/usermeta")
public class UsermetaController {
    @Resource
    private UsermetaService usermetaService;

    @PostMapping("/set")
    public Result setUsermeta(@RequestBody SetUsermeta usermeta) {
        System.out.println(usermeta.getUserLogin());
        System.out.println(usermeta.getUserPass());
        System.out.println(usermeta.getNickname());
        System.out.println(usermeta.getTruename());
        System.out.println(usermeta.getSex());
        System.out.println(usermeta.getAvatar());
        System.out.println(usermeta.getSchool());
        System.out.println(usermeta.getMajor());
        System.out.println(usermeta.getJob());
        System.out.println(usermeta.getAdmission());
        System.out.println(usermeta.getEducation());
        usermetaService.setUsermeta(usermeta);
//        usermetaService.save(usermeta);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping
    public Result add(@RequestBody Usermeta usermeta) {
        usermetaService.save(usermeta);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        usermetaService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Usermeta usermeta) {
        usermetaService.update(usermeta);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Usermeta usermeta = usermetaService.findById(id);
        return ResultGenerator.genSuccessResult(usermeta);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Usermeta> list = usermetaService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
