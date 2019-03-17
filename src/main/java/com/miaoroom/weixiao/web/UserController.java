package com.miaoroom.weixiao.web;

import com.aliyuncs.exceptions.ClientException;
import com.miaoroom.weixiao.core.Result;
import com.miaoroom.weixiao.core.ResultGenerator;
import com.miaoroom.weixiao.enums.LoginEnum;
import com.miaoroom.weixiao.enums.ValidateCodeEnum;
import com.miaoroom.weixiao.model.User;
import com.miaoroom.weixiao.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miaoroom.weixiao.shiro.ShiroKit;
import com.miaoroom.weixiao.vo.CodeInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2019/03/12.
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    //    @ApiImplicitParams({
//            @ApiImplicitParam(name = "user.userLogin", value = "用户名", required = true, dataType = "String", paramType = "body"),
//            @ApiImplicitParam(name = "user.userPass", value = "密码", required = true, dataType = "String", paramType = "body")})
    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "根据用户名密码进行登录")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    public Result login(@RequestBody User user) {
//        不为空则开始请求token
        String token = userService.login(user);
        log.info("用户请求登录，获取Token:{}", token);
//        Map<String, String> map = new HashMap<String, String>();
//        map.put();
        return ResultGenerator.genSuccessResult(token);
    }

    @ApiOperation(value = "发送验证码", notes = "根据手机号发送验证码")
    @GetMapping("/login/sendsms/{phone}")
    public Result sendLoginCode(@PathVariable String phone) throws ClientException {
//        如果用户不存在
        userService.sendSMS(phone, "注册");
        return ResultGenerator.genSuccessResult("发送成功");
    }

    @ApiOperation(value = "验证码登录", notes = "使用验证码进行登录")
    @PostMapping("/login/validatecode")
    public Result loginByCode(@RequestBody CodeInfo codeInfo) {
        String ValidateCodeEnumMessage = userService.validateCode(codeInfo.getPhone(), codeInfo.getCode()).getMessage();


        if (ValidateCodeEnumMessage.equals("验证码正确")) {
            //获得用户名
            String userLogin = codeInfo.getPhone();
            String token = userService.loginByCode(userLogin);
            return ResultGenerator.genSuccessResult(token);
        } else {
            return ResultGenerator.genFailResult(ValidateCodeEnumMessage);
        }

    }

    @ApiOperation(value = "注册", notes = "根据用户名密码进行注册，用户名为手机号")
    @PostMapping
    public Result add(@RequestBody User user) {
//        如果用户不存在
        if (userService.isRepeated(user.getUserLogin())) {
            String salt = ShiroKit.getRandomSalt(16);
            user.setUserSalt(salt);
            user.setUserPass(ShiroKit.md5(user.getUserPass(), user.getUserLogin() + salt));
            userService.save(user);
        } else {
            return ResultGenerator.genFailResult("用户名重复");
        }
        return ResultGenerator.genSuccessResult("注册成功");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "发送验证码", notes = "根据手机号发送验证码")
    @GetMapping("/register/sendsms/{phone}")
    public Result sendRegisterCode(@PathVariable String phone) throws ClientException {
//        如果用户不存在
        userService.sendSMS(phone, "注册");
        return ResultGenerator.genSuccessResult("发送成功");
    }

    @ApiOperation(value = "验证码检测", notes = "判断用户发送服务器的验证码是否正确")
    @PostMapping("/register/validatecode")
    public Result update(@RequestBody CodeInfo codeInfo) {
//        如果用户不存在
        String validateCodeEnum = userService.validateCode(codeInfo.getPhone(), codeInfo.getCode()).getMessage();
        return ResultGenerator.genSuccessResult(validateCodeEnum);
    }

}
