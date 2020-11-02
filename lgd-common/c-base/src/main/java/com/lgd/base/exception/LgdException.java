package com.lgd.base.exception;

import com.lgd.base.constant.HttpStatus;
import lombok.Getter;

/**
 * 基础异常
 *
 * @author YYJ
 */
@Getter
public class LgdException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final static String DEFAULT_MODULE = "lgd";

    /**
     * 所属模块
     */
    private String module;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    public LgdException(String msg) {
        this(DEFAULT_MODULE, msg);
    }

    public LgdException(String module, String msg) {
        this(module, HttpStatus.EXCEPTION + "", msg);
    }

    public LgdException(String module, String code , String msg) {
        this(module, code, msg, null);
    }

    public LgdException(String module, String code, String msg, Object[] args) {
        this.module = module;
        this.code = code;
        this.msg = msg;
        this.args = args;
    }
}