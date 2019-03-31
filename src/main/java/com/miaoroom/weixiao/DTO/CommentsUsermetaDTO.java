package com.miaoroom.weixiao.DTO;

import com.miaoroom.weixiao.model.Comments;
import com.miaoroom.weixiao.model.Usermeta;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: znnnnn
 * Date: 2019-03-31
 * Time: 20:04
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
public class CommentsUsermetaDTO extends Comments {
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
