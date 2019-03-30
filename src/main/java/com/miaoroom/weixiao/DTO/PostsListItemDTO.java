package com.miaoroom.weixiao.DTO;

import com.miaoroom.weixiao.model.Posts;
import com.miaoroom.weixiao.model.Usermeta;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;


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
     * 主键
     */
    @Id
    @Column(name = "umeta_ID")
    @ApiModelProperty(value = "主键")
    private Long umetaId;

    /**
     * 用户ID
     */
    @Column(name = "user_login")
    @ApiModelProperty(value = "用户名")
    private String userLogin;

    /**
     * 密码
     */
    @Column(name = "user_pass")
    @ApiModelProperty(value = "密码", required = true)
    private String userPass;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 真名
     */
    @ApiModelProperty(value = "真名")
    private String truename;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 学校
     */
    @ApiModelProperty(value = "学校")
    private String school;

    /**
     * 专业
     */
    @ApiModelProperty(value = "专业")
    private String major;

    /**
     * 学历
     */
    @ApiModelProperty(value = "学历")
    private String education;

    /**
     * 入学时间
     */
    @Column(name = "Admission")
    @ApiModelProperty(value = "入学时间")
    private Date admission;

    /**
     * 工作
     */
    @ApiModelProperty(value = "工作")
    private String job;

    /**
     * 用户标签
     */
    @Column(name = "user_tag")
    @ApiModelProperty(value = "用户标签")
    private String userTag;

    /**
     * 用户介绍
     */
    @Column(name = "user_introduce")
    @ApiModelProperty(value = "用户介绍")
    private String userIntroduce;

    /**
     * 年级
     */
    @ApiModelProperty(value = "年级")
    private String grade;

    /**
     * 权限：user/admin
     */
    @ApiModelProperty(value = "权限：user/admin")
    private String role;

    /**
     * 头像的url
     */
    @ApiModelProperty(value = "头像的url")
    private String avatar;


    @Column(name = "likeID")
    @ApiModelProperty(value="")
    private Long likeid;

    @Column(name = "like_post_ID")
    @ApiModelProperty(value="")
    private Long likePostId;

    @Column(name = "like_user_ID")
    @ApiModelProperty(value="")
    private Long likeUserId;

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



}
