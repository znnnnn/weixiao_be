package com.miaoroom.weixiao.DTO;

import com.miaoroom.weixiao.model.User;
import com.miaoroom.weixiao.model.Usermeta;
import lombok.Data;

import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * User: znnnnn
 * Date: 2019-04-12
 * Time: 12:52
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
public class UserWithUsermetaDTO extends User {
    /**
     * 角色信息
     */
    @Transient
    private Usermeta usermeta;

    public Usermeta getUsermeta() {
        return usermeta;
    }

    public void setUsermeta(Usermeta usermeta) {
        this.usermeta = usermeta;
    }
}
