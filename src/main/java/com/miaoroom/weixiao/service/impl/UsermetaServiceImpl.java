package com.miaoroom.weixiao.service.impl;

import com.miaoroom.weixiao.DTO.SetUsermeta;
import com.miaoroom.weixiao.DTO.UserWithUsermetaDTO;
import com.miaoroom.weixiao.core.ResultGenerator;
import com.miaoroom.weixiao.dao.UserMapper;
import com.miaoroom.weixiao.dao.UsermetaMapper;
import com.miaoroom.weixiao.model.User;
import com.miaoroom.weixiao.model.Usermeta;
import com.miaoroom.weixiao.service.UserService;
import com.miaoroom.weixiao.service.UsermetaService;
import com.miaoroom.weixiao.core.AbstractService;
import com.miaoroom.weixiao.shiro.ShiroKit;
import com.miaoroom.weixiao.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;


/**
 * Created by CodeGenerator on 2019/03/21.
 */
@Service
@Transactional
public class UsermetaServiceImpl extends AbstractService<Usermeta> implements UsermetaService {
    @Resource
    private UsermetaMapper usermetaMapper;

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UsermetaService usermetaService;


    @Override
    public boolean setUsermeta(SetUsermeta setUsermetaDTO) {
        // 获取用户ID
//        System.out.println(userMapper.findByUserLogin(setUsermeta.getUserLogin()).getUserId());
        User user = new User();
        if (userService.isRepeated(setUsermetaDTO.getUserLogin())) {
            String salt = ShiroKit.getRandomSalt(16);
            user.setUserLogin(setUsermetaDTO.getUserLogin());
            user.setUserSalt(salt);
            user.setUserPass(ShiroKit.md5(setUsermetaDTO.getUserPass(), setUsermetaDTO.getUserLogin() + salt));
            userService.save(user);
            Long userId = userMapper.findByUserLogin(setUsermetaDTO.getUserLogin()).getUserId();
            Usermeta usermeta = (Usermeta) setUsermetaDTO;
            usermeta.setUserId(userId);
            usermetaService.save((Usermeta) setUsermetaDTO);
//            usermetaMapper.insertUserMeta();
        }
        return false;
    }

    @Override
    public UserWithUsermetaDTO myHome(String token) {
//        System.out.println(JWTUtil.getUsername(token));
        String userLogin = JWTUtil.getUsername(token);
//        System.out.println(userLogin);
//        Long userId = userService.findBy("userLogin",userLogin).getUserId();
        if (userLogin == null) {
            System.out.println(userLogin);
            return null;
        }
        UserWithUsermetaDTO result = userMapper.findUserWithUsermetaDTOByUserLogin(userLogin);
//        System.out.println(userWithUsermetaDTO);
//        return null;
//        Usermeta result = usermetaService.findBy("userId", userId);
//        查询是否存在用户信息，如果不存在则新建默认一条
        if (result == null) {
            Usermeta defaultUsermeta = new Usermeta();
            defaultUsermeta.setUserId(result.getUserId());
            defaultUsermeta.setNickname(userLogin);
            defaultUsermeta.setAvatar("http://111.67.196.209/wp-content/uploads/2019/03/avatar" + (int) (Math.random() * 17 + 1) + ".png");
            defaultUsermeta.setJob("在校学生");
            defaultUsermeta.setSchool("斯坦福大学");
            usermetaService.save(defaultUsermeta);
            UserWithUsermetaDTO userWithUsermetaDTO = new UserWithUsermetaDTO();
            userWithUsermetaDTO.setUsermeta(defaultUsermeta);
            return userWithUsermetaDTO;
        }
        return result;
    }


    @Override
    public Usermeta userHome(String userId) {
        Usermeta result = usermetaService.findBy("userId", userId);
        return null;
    }
}
