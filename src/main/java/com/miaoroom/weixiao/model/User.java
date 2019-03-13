package com.miaoroom.weixiao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@ApiModel(value = "User")
public class User {
    /**
     * 主键
     */
    @Id
    @Column(name = "user_ID")
    @ApiModelProperty(value = "主键")
    private Long userId;

    /**
     * 用户名
     */
    @Column(name = "user_login")
    @ApiModelProperty(value = "用户名", required = true)
    private String userLogin;

    /**
     * 密码
     */
    @Column(name = "user_pass")
    @ApiModelProperty(value = "密码", required = true)
    private String userPass;

    /**
     * 密码
     */
    @Column(name = "user_salt")
    @ApiModelProperty(value = "用户密码盐")
    private String userSalt;

    /**
     * 注册时间
     */
    @Column(name = "user_registered")
    @ApiModelProperty(value = "注册时间")
    private Date userRegistered;

    /**
     * 用户状态 0 待激活 1 激活 2 封禁
     */
    @Column(name = "user_status")
    @ApiModelProperty(value = "用户状态 0 待激活 1 激活 2 封禁")
    private Integer userStatus;

    /**
     * 手机
     */
    @Column(name = "user_phone")
    @ApiModelProperty(value = "手机")
    private String userPhone;

    /**
     * 用户角色
     */
    @Column(name = "user_role")
    @ApiModelProperty(value = "用户权限")
    private String userRole;

    /**
     * 用户权限
     */
    @Column(name = "user_permission")
    @ApiModelProperty(value = "用户权限")
    private String userPermission;

    /**
     * 获取主键
     *
     * @return user_ID - 主键
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置主键
     *
     * @param userId 主键
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_login - 用户名
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * 设置用户名
     *
     * @param userLogin 用户名
     */
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * 获取密码
     *
     * @return user_pass - 密码
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * 设置密码
     *
     * @param userPass 密码
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * 获取密码
     *
     * @return user_salt - 用户密码盐
     */
    public String getUserSalt() {
        return userSalt;
    }

    /**
     * 设置密码
     *
     * @param userSalt 用户密码盐
     */
    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    /**
     * 获取注册时间
     *
     * @return user_registered - 注册时间
     */
    public Date getUserRegistered() {
        return userRegistered;
    }

    /**
     * 设置注册时间
     *
     * @param userRegistered 注册时间
     */
    public void setUserRegistered(Date userRegistered) {
        this.userRegistered = userRegistered;
    }

    /**
     * 获取用户状态 0 待激活 1 激活 2 封禁
     *
     * @return user_status - 用户状态 0 待激活 1 激活 2 封禁
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态 0 待激活 1 激活 2 封禁
     *
     * @param userStatus 用户状态 0 待激活 1 激活 2 封禁
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取手机
     *
     * @return user_phone - 手机
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置手机
     *
     * @param userPhone 手机
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取用户角色
     *
     * @return user_role 用户角色
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 设置用户角色
     *
     * @param userRole 用户角色
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * 获取用户权限
     *
     * @return user_permission 用户权限
     */
    public String getUserPermission() {
        return userPermission;
    }

    /**
     * 设置用户权限
     *
     * @param userPermission 用户权限
     */
    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }
}