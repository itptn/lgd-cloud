package com.lgd.base;

import com.lgd.base.enums.ResultEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/4 17:03
 */
@Getter
@Setter
public class LgdResult<D> implements Serializable {

    private static final long serialVersionUID = -7237955868021173850L;
    private boolean success;
    private String code;
    private String msg;
    private D data;

    public static <D> LgdResult<D> ok(D data) {
        return init(true, ResultEnum.SUCCESS, data);
    }

    public static <D> LgdResult<D> fail(String msg) {
        return init(false, ResultEnum.FAIL.getCode(), msg, null);
    }

    public static <D> LgdResult<D> fail(ResultEnum resultEnum) {
        return init(false, ResultEnum.FAIL, null);
    }

    public static <D> LgdResult<D> init() {
        return init(false, ResultEnum.FAIL, null);
    }

    public static <D> LgdResult<D> init(boolean success, ResultEnum resultEnum, D data) {
        LgdResult<D> lgdResult = new LgdResult();
        lgdResult.setSuccess(success);
        lgdResult.setCode(resultEnum.getCode());
        lgdResult.setMsg(resultEnum.getMsg());
        lgdResult.setData(data);
        return lgdResult;
    }

    public static <D> LgdResult<D> init(boolean success, String code, String msg, D data) {
        LgdResult<D> lgdResult = new LgdResult();
        lgdResult.setSuccess(success);
        lgdResult.setCode(code);
        lgdResult.setMsg(msg);
        lgdResult.setData(data);
        return lgdResult;
    }
}