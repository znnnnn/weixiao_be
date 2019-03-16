package com.miaoroom.weixiao.enums;

import lombok.Getter;

@Getter
public enum  ValidateCodeEnum {
    SUCCESS(0, "验证码正确"),
    FAIL(1, "验证码错误"),
    TIMEOUT(2,"验证码过期");

    private Integer code;
    private String message;

    ValidateCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
