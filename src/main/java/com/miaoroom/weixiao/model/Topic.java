package com.miaoroom.weixiao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

@ApiModel(value="Topic")
public class Topic {
    /**
     * 主键，话题列表ID
     */
    @Id
    @Column(name = "topic_ID")
    @ApiModelProperty(value="主键，话题列表ID")
    private Long topicId;

    /**
     * 话题名字
     */
    @Column(name = "topic_name")
    @ApiModelProperty(value="话题名字")
    private String topicName;

    /**
     * 话题缩略图
     */
    @Column(name = "topic_thumb")
    @ApiModelProperty(value="话题缩略图")
    private String topicThumb;

    /**
     * 话题热度
     */
    @Column(name = "topic_hot")
    @ApiModelProperty(value="话题热度")
    private Integer topicHot;

    /**
     * 获取主键，话题列表ID
     *
     * @return topic_ID - 主键，话题列表ID
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * 设置主键，话题列表ID
     *
     * @param topicId 主键，话题列表ID
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * 获取话题名字
     *
     * @return topic_name - 话题名字
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * 设置话题名字
     *
     * @param topicName 话题名字
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    /**
     * 获取话题缩略图
     *
     * @return topic_thumb - 话题缩略图
     */
    public String getTopicThumb() {
        return topicThumb;
    }

    /**
     * 设置话题缩略图
     *
     * @param topicThumb 话题缩略图
     */
    public void setTopicThumb(String topicThumb) {
        this.topicThumb = topicThumb;
    }

    /**
     * 获取话题热度
     *
     * @return topic_hot - 话题热度
     */
    public Integer getTopicHot() {
        return topicHot;
    }

    /**
     * 设置话题热度
     *
     * @param topicHot 话题热度
     */
    public void setTopicHot(Integer topicHot) {
        this.topicHot = topicHot;
    }
}