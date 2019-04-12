package com.miaoroom.weixiao.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.miaoroom.weixiao.dao.UserMapper;
import com.miaoroom.weixiao.enums.LoginEnum;
import com.miaoroom.weixiao.enums.ValidateCodeEnum;
import com.miaoroom.weixiao.model.User;
import com.miaoroom.weixiao.service.UserService;
import com.miaoroom.weixiao.core.AbstractService;
import com.miaoroom.weixiao.shiro.ShiroKit;
import com.miaoroom.weixiao.utils.JWTUtil;
import com.miaoroom.weixiao.utils.SMSVerification.SMSUtil;
import com.miaoroom.weixiao.vo.CodeInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by CodeGenerator on 2019/03/12.
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean isRepeated(String userLogin) {
        if (null == userMapper.findByUserLogin(userLogin)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据传入的用户名密码来比对数据库中的用户名密码，如果正确，则返回JWTUtil生成的token
     * 其中密码需要进行加密判断
     *
     * @param user
     * @return
     */
    @Override
    public String login(User user) {
        //获取参数中的用户名密码
        String userLogin = user.getUserLogin();
        String userPass = user.getUserPass();
        if (userLogin == null) {
            log.error("请求的用户名为空");
            return "请求的用户名为空";
        }

//      获取数据库中的用户对象
        User userFromDb = userMapper.findByUserLogin(userLogin);
        if (userFromDb == null) {
            log.error(LoginEnum.NONE.getMessage());
            return LoginEnum.NONE.getMessage();
        }
        String salt = userFromDb.getUserSalt();
//        生成加密密码
        String encodedUserPass = ShiroKit.md5(userPass, userLogin + salt);
//        log.info("数据库密码:{}",userFromDb.getUserPass());
//        log.info("本次加密密码:{}",encodedUserPass);
//        log.info("密码是否正确:{}",userFromDb.getUserPass().equals(encodedUserPass));
//        log.info("token本次:{}",userFromDb.getUserPass().equals(encodedUserPass) ? JWTUtil.sign(userLogin, encodedUserPass) : null);
        return userFromDb.getUserPass().equals(encodedUserPass) ? JWTUtil.sign(userLogin, encodedUserPass) : LoginEnum.ERROR.getMessage();
    }


    @Override
    public String loginByCode(String userLogin) {
//        获取数据库中的用户对象
        User userFromDb = userMapper.findByUserLogin(userLogin);
//        如果不存在这个用户
        if (userFromDb == null) {
            log.error(LoginEnum.NONE.getMessage());
            return LoginEnum.NONE.getMessage();
        }
        String userPass = userFromDb.getUserPass();
        return JWTUtil.sign(userLogin, userPass);
    }

    @Autowired
    SMSUtil smsUtil;

    /**
     * 该手机号的验证码和发送时间，用到了一个Map保存。
     */
    private final static Map<String, CodeInfo> codeInfoMap = new HashMap<String, CodeInfo>();

    @Override
    public Map<String, CodeInfo> getCodeInfoMap() {
        return codeInfoMap;
    }

    /**
     * 发送短信
     *
     * @param phone
     * @throws ClientException
     */
    @Override
    public void sendSMS(String phone, String action) throws ClientException {
        CodeInfo codeInfo = smsUtil.sendSMS2codeInfo(phone, action);
        codeInfoMap.put(phone, codeInfo);
    }


    /**
     * 传入phone和code来验证是否正确
     *
     * @param phone
     * @param code
     * @return
     */
    @Override
    public ValidateCodeEnum validateCode(String phone, String code) {
        return smsUtil.validateCode(phone, code, codeInfoMap);
    }


}
