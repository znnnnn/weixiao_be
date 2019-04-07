package com.miaoroom.weixiao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel(value="Follow")
public class Follow {
    @Id
    @Column(name = "follow_ID")
    @ApiModelProperty(value="")
    private Long followId;

    /**
     * 用户id
     */
    @Column(name = "user_ID")
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
     * 粉丝的用户id
     */
    @Column(name = "follow_user_ID")
    @ApiModelProperty(value="粉丝的用户id")
    private Long followUserId;

    /**
     * 粉丝状态  0 取消  1 激活
     */
    @Column(name = "follow_status")
    @ApiModelProperty(value="粉丝状态  0 取消  1 激活")
    private Integer followStatus;

    /**
     * 粉丝id
     */
    @Column(name = "follow_time")
    @ApiModelProperty(value="粉丝id")
    private Date followTime;

    /**
     * @return follow_ID
     */
    public Long getFollowId() {
        return followId;
    }

    /**
     * @param followId
     */
    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    /**
     * 获取用户id
     *
     * @return user_ID - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取粉丝的用户id
     *
     * @return follow_user_ID - 粉丝的用户id
     */
    public Long getFollowUserId() {
        return followUserId;
    }

    /**
     * 设置粉丝的用户id
     *
     * @param followUserId 粉丝的用户id
     */
    public void setFollowUserId(Long followUserId) {
        this.followUserId = followUserId;
    }

    /**
     * 获取粉丝状态  0 取消  1 激活
     *
     * @return follow_status - 粉丝状态  0 取消  1 激活
     */
    public Integer getFollowStatus() {
        return followStatus;
    }

    /**
     * 设置粉丝状态  0 取消  1 激活
     *
     * @param followStatus 粉丝状态  0 取消  1 激活
     */
    public void setFollowStatus(Integer followStatus) {
        this.followStatus = followStatus;
    }

    /**
     * 获取粉丝id
     *
     * @return follow_time - 粉丝id
     */
    public Date getFollowTime() {
        return followTime;
    }

    /**
     * 设置粉丝id
     *
     * @param followTime 粉丝id
     */
    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
}