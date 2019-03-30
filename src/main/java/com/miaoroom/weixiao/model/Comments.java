package com.miaoroom.weixiao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel(value="Comments")
public class Comments {
    /**
     * 评论ID
     */
    @Id
    @Column(name = "comment_ID")
    @ApiModelProperty(value="评论ID")
    private Long commentId;

    /**
     * 评论的文章ID
     */
    @Column(name = "comment_post_ID")
    @ApiModelProperty(value="评论的文章ID")
    private Long commentPostId;

    /**
     * 评论人的用户ID
     */
    @Column(name = "comment_user_ID")
    @ApiModelProperty(value="评论人的用户ID")
    private Long commentUserId;

    /**
     * 评论的人昵称
     */
    @Column(name = "comment_author")
    @ApiModelProperty(value="评论的人昵称")
    private String commentAuthor;

    /**
     * 评论者IP
     */
    @Column(name = "comment_IP")
    @ApiModelProperty(value="评论者IP")
    private String commentIp;

    /**
     * 评论时间
     */
    @Column(name = "comment_date")
    @ApiModelProperty(value="评论时间")
    private Date commentDate;

    /**
     * 父级评论
     */
    @Column(name = "comment_parent")
    @ApiModelProperty(value="父级评论")
    private Long commentParent;

    /**
     * 评论或分享
     */
    @Column(name = "comment_type")
    @ApiModelProperty(value="评论或分享")
    private String commentType;

    /**
     * 评论内容
     */
    @Column(name = "comment_content")
    @ApiModelProperty(value="评论内容")
    private String commentContent;

    /**
     * 获取评论ID
     *
     * @return comment_ID - 评论ID
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 设置评论ID
     *
     * @param commentId 评论ID
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取评论的文章ID
     *
     * @return comment_post_ID - 评论的文章ID
     */
    public Long getCommentPostId() {
        return commentPostId;
    }

    /**
     * 设置评论的文章ID
     *
     * @param commentPostId 评论的文章ID
     */
    public void setCommentPostId(Long commentPostId) {
        this.commentPostId = commentPostId;
    }

    /**
     * 获取评论人的用户ID
     *
     * @return comment_user_ID - 评论人的用户ID
     */
    public Long getCommentUserId() {
        return commentUserId;
    }

    /**
     * 设置评论人的用户ID
     *
     * @param commentUserId 评论人的用户ID
     */
    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }

    /**
     * 获取评论的人昵称
     *
     * @return comment_author - 评论的人昵称
     */
    public String getCommentAuthor() {
        return commentAuthor;
    }

    /**
     * 设置评论的人昵称
     *
     * @param commentAuthor 评论的人昵称
     */
    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    /**
     * 获取评论者IP
     *
     * @return comment_IP - 评论者IP
     */
    public String getCommentIp() {
        return commentIp;
    }

    /**
     * 设置评论者IP
     *
     * @param commentIp 评论者IP
     */
    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
    }

    /**
     * 获取评论时间
     *
     * @return comment_date - 评论时间
     */
    public Date getCommentDate() {
        return commentDate;
    }

    /**
     * 设置评论时间
     *
     * @param commentDate 评论时间
     */
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    /**
     * 获取父级评论
     *
     * @return comment_parent - 父级评论
     */
    public Long getCommentParent() {
        return commentParent;
    }

    /**
     * 设置父级评论
     *
     * @param commentParent 父级评论
     */
    public void setCommentParent(Long commentParent) {
        this.commentParent = commentParent;
    }

    /**
     * 获取评论或分享
     *
     * @return comment_type - 评论或分享
     */
    public String getCommentType() {
        return commentType;
    }

    /**
     * 设置评论或分享
     *
     * @param commentType 评论或分享
     */
    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    /**
     * 获取评论内容
     *
     * @return comment_content - 评论内容
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置评论内容
     *
     * @param commentContent 评论内容
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}