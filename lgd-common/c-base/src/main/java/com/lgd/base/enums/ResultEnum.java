package com.lgd.base.enums;

import lombok.Getter;

/**
 *
 */
@Getter
public enum ResultEnum {

    SUCCESS("0000", "操作成功"),
    FAIL("9999", "操作失败");

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}