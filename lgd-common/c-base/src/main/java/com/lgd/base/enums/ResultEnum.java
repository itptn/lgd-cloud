package com.lgd.base.enums;

import lombok.Getter;

/**
 *
 */
@Getter
public enum ResultEnum {

    SUCCESS("0000", "操作成功"),

    登陆方式不支持("S0001", "登陆方式不支持"),
    用户名或密码不能为空("S0002", "用户名或密码不能为空"),
    用户名或密码不正确("S0003", "用户名或密码不正确"),
    FAIL("9999", "操作失败");

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}