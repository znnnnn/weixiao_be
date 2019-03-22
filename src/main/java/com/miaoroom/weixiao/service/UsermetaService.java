package com.miaoroom.weixiao.service;
import com.miaoroom.weixiao.DTO.SetUsermeta;
import com.miaoroom.weixiao.model.Usermeta;
import com.miaoroom.weixiao.core.Service;


/**
 * Created by CodeGenerator on 2019/03/21.
 */
public interface UsermetaService extends Service<Usermeta> {
    boolean setUsermeta(SetUsermeta usermeta);
    Usermeta myHome(String token);
}
