package com.lgd.base.enums;

import lombok.Getter;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/9 17:16
 */
@Getter
public enum  LoginTypeEnum {

    账户密码登录("account"),
    手机号登录("mobile");

    private String type;
    LoginTypeEnum(String type){
        this.type = type;
    }
}
