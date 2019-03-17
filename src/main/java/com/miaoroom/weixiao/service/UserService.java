package com.miaoroom.weixiao.service;
import com.aliyuncs.exceptions.ClientException;
import com.miaoroom.weixiao.enums.ValidateCodeEnum;
import com.miaoroom.weixiao.model.User;
import com.miaoroom.weixiao.core.Service;
import com.miaoroom.weixiao.vo.CodeInfo;

import java.util.Map;


/**
 * Created by CodeGenerator on 2019/03/12.
 */
public interface UserService extends Service<User> {
    boolean isRepeated(String userLogin);
    String login(User user);
    String loginByCode(String phone);
    ValidateCodeEnum validateCode(String phone, String code);
    void sendSMS(String phone,String action) throws ClientException;
}
