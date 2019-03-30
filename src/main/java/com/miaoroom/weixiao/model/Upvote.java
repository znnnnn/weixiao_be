package com.miaoroom.weixiao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

@ApiModel(value="Upvote")
public class Upvote {
    @Id
    @Column(name = "upvoteID")
    @ApiModelProperty(value="")
    private Long upvoteid;

    @Column(name = "upvote_post_ID")
    @ApiModelProperty(value="")
    private Long upvotePostId;

    @Column(name = "upvote_user_ID")
    @ApiModelProperty(value="")
    private Long upvoteUserId;

    /**
     * @return upvoteID
     */
    public Long getUpvoteid() {
        return upvoteid;
    }

    /**
     * @param upvoteid
     */
    public void setUpvoteid(Long upvoteid) {
        this.upvoteid = upvoteid;
    }

    /**
     * @return upvote_post_ID
     */
    public Long getUpvotePostId() {
        return upvotePostId;
    }

    /**
     * @param upvotePostId
     */
    public void setUpvotePostId(Long upvotePostId) {
        this.upvotePostId = upvotePostId;
    }

    /**
     * @return upvote_user_ID
     */
    public Long getUpvoteUserId() {
        return upvoteUserId;
    }

    /**
     * @param upvoteUserId
     */
    public void setUpvoteUserId(Long upvoteUserId) {
        this.upvoteUserId = upvoteUserId;
    }
}