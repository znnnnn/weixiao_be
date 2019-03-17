package com.miaoroom.weixiao.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum  LoginEnum {
    SUCCESS(0, "登录成功"),
    NONE(1, "用户名未注册"),
    ERROR(2,"用户名密码错误"),
    CODE_ERROR(3, "验证码错误");

    private Integer code;
    private String message;

    LoginEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
