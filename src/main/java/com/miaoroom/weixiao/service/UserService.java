package com.miaoroom.weixiao.service;
import com.miaoroom.weixiao.model.User;
import com.miaoroom.weixiao.core.Service;


/**
 * Created by CodeGenerator on 2019/03/12.
 */
public interface UserService extends Service<User> {
    boolean isRepeated(String userLogin);
}
