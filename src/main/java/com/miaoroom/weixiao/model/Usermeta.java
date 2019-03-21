package com.miaoroom.weixiao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;

@ApiModel(value="Usermeta")
public class Usermeta {
    /**
     * 主键
     */
    @Id
    @Column(name = "umeta_ID")
    @ApiModelProperty(value="主键")
    private Long umetaId;

    /**
     * 用户ID
     */
    @Column(name = "user_ID")
    @ApiModelProperty(value="用户ID")
    private Long userId;

    /**
     * 昵称
     */
    @ApiModelProperty(value="昵称")
    private String nickname;

    /**
     * 真名
     */
    @ApiModelProperty(value="真名")
    private String truename;

    /**
     * 性别
     */
    @ApiModelProperty(value="性别")
    private String sex;

    /**
     * 学校
     */
    @ApiModelProperty(value="学校")
    private String school;

    /**
     * 专业
     */
    @ApiModelProperty(value="专业")
    private String major;

    /**
     * 学历
     */
    @ApiModelProperty(value="学历")
    private String education;

    /**
     * 入学时间
     */
    @Column(name = "Admission")
    @ApiModelProperty(value="入学时间")
    private Date admission;

    /**
     * 工作
     */
    @ApiModelProperty(value="工作")
    private String job;

    /**
     * 用户标签
     */
    @Column(name = "user_tag")
    @ApiModelProperty(value="用户标签")
    private String userTag;

    /**
     * 用户介绍
     */
    @Column(name = "user_introduce")
    @ApiModelProperty(value="用户介绍")
    private String userIntroduce;

    /**
     * 年级
     */
    @ApiModelProperty(value="年级")
    private String grade;

    /**
     * 权限：user/admin
     */
    @ApiModelProperty(value="权限：user/admin")
    private String role;

    /**
     * 头像的url
     */
    @ApiModelProperty(value="头像的url")
    private String avatar;

    /**
     * 获取主键
     *
     * @return umeta_ID - 主键
     */
    public Long getUmetaId() {
        return umetaId;
    }

    /**
     * 设置主键
     *
     * @param umetaId 主键
     */
    public void setUmetaId(Long umetaId) {
        this.umetaId = umetaId;
    }

    /**
     * 获取用户ID
     *
     * @return user_ID - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取真名
     *
     * @return truename - 真名
     */
    public String getTruename() {
        return truename;
    }

    /**
     * 设置真名
     *
     * @param truename 真名
     */
    public void setTruename(String truename) {
        this.truename = truename;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取学校
     *
     * @return school - 学校
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置学校
     *
     * @param school 学校
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 获取专业
     *
     * @return major - 专业
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置专业
     *
     * @param major 专业
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 获取学历
     *
     * @return education - 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取入学时间
     *
     * @return Admission - 入学时间
     */
    public Date getAdmission() {
        return admission;
    }

    /**
     * 设置入学时间
     *
     * @param admission 入学时间
     */
    public void setAdmission(Date admission) {
        this.admission = admission;
    }

    /**
     * 获取工作
     *
     * @return job - 工作
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置工作
     *
     * @param job 工作
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 获取用户标签
     *
     * @return user_tag - 用户标签
     */
    public String getUserTag() {
        return userTag;
    }

    /**
     * 设置用户标签
     *
     * @param userTag 用户标签
     */
    public void setUserTag(String userTag) {
        this.userTag = userTag;
    }

    /**
     * 获取用户介绍
     *
     * @return user_introduce - 用户介绍
     */
    public String getUserIntroduce() {
        return userIntroduce;
    }

    /**
     * 设置用户介绍
     *
     * @param userIntroduce 用户介绍
     */
    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    /**
     * 获取年级
     *
     * @return grade - 年级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 设置年级
     *
     * @param grade 年级
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 获取权限：user/admin
     *
     * @return role - 权限：user/admin
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置权限：user/admin
     *
     * @param role 权限：user/admin
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 获取头像的url
     *
     * @return avatar - 头像的url
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像的url
     *
     * @param avatar 头像的url
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}