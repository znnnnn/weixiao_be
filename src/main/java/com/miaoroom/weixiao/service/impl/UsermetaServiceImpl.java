package com.miaoroom.weixiao.service.impl;

import com.miaoroom.weixiao.DTO.SetUsermeta;
import com.miaoroom.weixiao.core.ResultGenerator;
import com.miaoroom.weixiao.dao.UserMapper;
import com.miaoroom.weixiao.dao.UsermetaMapper;
import com.miaoroom.weixiao.model.User;
import com.miaoroom.weixiao.model.Usermeta;
import com.miaoroom.weixiao.service.UserService;
import com.miaoroom.weixiao.service.UsermetaService;
import com.miaoroom.weixiao.core.AbstractService;
import com.miaoroom.weixiao.shiro.ShiroKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


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
}
