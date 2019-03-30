package com.miaoroom.weixiao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@ApiModel(value="Posts")
public class Posts {
    /**
     * 主键
     */
    @Id
    @Column(name = "post_ID")
    @ApiModelProperty(value="主键")
    private Long postId;

    /**
     * 作者的用户ID
     */
    @Column(name = "post_author")
    @ApiModelProperty(value="作者的用户ID")
    private Long postAuthor;

    /**
     * 创作时间
     */
    @Column(name = "post_date")
    @ApiModelProperty(value="创作时间")
    private Date postDate;

    /**
     * 文章状态 0草稿 1 发布 2删除
     */
    @Column(name = "post_status")
    @ApiModelProperty(value="文章状态 0草稿 1 发布 2删除")
    private String postStatus;

    /**
     * 最后修改时间
     */
    @Column(name = "post_modified")
    @ApiModelProperty(value="最后修改时间")
    private Date postModified;

    /**
     * 文章类目: 动态：dynamic
     */
    @Column(name = "post_cat")
    @ApiModelProperty(value="文章类目: 动态：dynamic")
    private String postCat;

    /**
     * 文章内容
     */
    @Column(name = "post_content")
    @ApiModelProperty(value="文章内容")
    private String postContent;

    /**
     * 文章标题
     */
    @Column(name = "post_title")
    @ApiModelProperty(value="文章标题")
    private String postTitle;

    /**
     * 文章内的图片
     */
    @Column(name = "post_image")
    @ApiModelProperty(value="文章内的图片")
    private String postImage;

    /**
     * 点赞
     */
    @Transient
    private List<Upvote> upvoteList;
//    private String name;

    /**
     * 获取主键
     *
     * @return post_ID - 主键
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置主键
     *
     * @param postId 主键
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取作者的用户ID
     *
     * @return post_author - 作者的用户ID
     */
    public Long getPostAuthor() {
        return postAuthor;
    }

    /**
     * 设置作者的用户ID
     *
     * @param postAuthor 作者的用户ID
     */
    public void setPostAuthor(Long postAuthor) {
        this.postAuthor = postAuthor;
    }

    /**
     * 获取创作时间
     *
     * @return post_date - 创作时间
     */
    public Date getPostDate() {
        return postDate;
    }

    /**
     * 设置创作时间
     *
     * @param postDate 创作时间
     */
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    /**
     * 获取文章状态 0草稿 1 发布 2删除
     *
     * @return post_status - 文章状态 0草稿 1 发布 2删除
     */
    public String getPostStatus() {
        return postStatus;
    }

    /**
     * 设置文章状态 0草稿 1 发布 2删除
     *
     * @param postStatus 文章状态 0草稿 1 发布 2删除
     */
    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    /**
     * 获取最后修改时间
     *
     * @return post_modified - 最后修改时间
     */
    public Date getPostModified() {
        return postModified;
    }

    /**
     * 设置最后修改时间
     *
     * @param postModified 最后修改时间
     */
    public void setPostModified(Date postModified) {
        this.postModified = postModified;
    }

    /**
     * 获取文章类目: 动态：dynamic
     *
     * @return post_cat - 文章类目: 动态：dynamic
     */
    public String getPostCat() {
        return postCat;
    }

    /**
     * 设置文章类目: 动态：dynamic
     *
     * @param postCat 文章类目: 动态：dynamic
     */
    public void setPostCat(String postCat) {
        this.postCat = postCat;
    }

    /**
     * 获取文章内容
     *
     * @return post_content - 文章内容
     */
    public String getPostContent() {
        return postContent;
    }

    /**
     * 设置文章内容
     *
     * @param postContent 文章内容
     */
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    /**
     * 获取文章标题
     *
     * @return post_title - 文章标题
     */
    public String getPostTitle() {
        return postTitle;
    }

    /**
     * 设置文章标题
     *
     * @param postTitle 文章标题
     */
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    /**
     * 获取文章内的图片
     *
     * @return post_image - 文章内的图片
     */
    public String getPostImage() {
        return postImage;
    }

    /**
     * 设置文章内的图片
     *
     * @param postImage 文章内的图片
     */
    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }
}