package com.lgd.base;

import com.lgd.base.constant.HttpStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author YYJ
 */
@Setter
@Getter
public class LgdResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = HttpStatus.SUCCESS;

    /**
     * 失败
     */
    public static final int FAIL = HttpStatus.ERROR;

    private int code;

    private String msg;

    private T data;

    public static <T> LgdResult<T> ok() {
        return restResult(null, SUCCESS, null);
    }

    public static <T> LgdResult<T> ok(T data) {
        return restResult(data, SUCCESS, null);
    }

    public static <T> LgdResult<T> ok(T data, String msg) {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> LgdResult<T> fail() {
        return restResult(null, FAIL, null);
    }

    public static <T> LgdResult<T> fail(String msg) {
        return restResult(null, FAIL, msg);
    }

    public static <T> LgdResult<T> fail(T data) {
        return restResult(data, FAIL, null);
    }

    public static <T> LgdResult<T> fail(T data, String msg) {
        return restResult(data, FAIL, msg);
    }

    public static <T> LgdResult<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    private static <T> LgdResult<T> restResult(T data, int code, String msg) {
        LgdResult<T> apiResult = new LgdResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}