package com.miaoroom.weixiao.DTO;

import com.miaoroom.weixiao.model.Comments;
import com.miaoroom.weixiao.model.Posts;
import com.miaoroom.weixiao.model.Upvote;
import com.miaoroom.weixiao.model.Usermeta;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: znnnnn
 * Date: 2019-03-21
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Data
public class PostsListItemDTO extends Posts {

    /**
     * 点赞
     */
    @Transient
    private List<Upvote> upvoteList;

    public List<Upvote> getUpvoteList() {
        return upvoteList;
    }

    public void setUpvoteList(List<Upvote> upvoteList) {
        this.upvoteList = upvoteList;
    }

    /**
     * 评论
     */
    @Transient
    private List<CommentsUsermetaDTO> commentsUsermetaDTOList;

    public List<CommentsUsermetaDTO> getCommentsUsermetaDTOList() {
        return commentsUsermetaDTOList;
    }

    public void setCommentsUsermetaDTOList(List<CommentsUsermetaDTO> commentsUsermetaDTOList) {
        this.commentsUsermetaDTOList = commentsUsermetaDTOList;
    }

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
