package com.lgd.base;

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
    private int errorCode;
    private String errorMessage;
    private D data;

    public static <D> LgdResult<D> init() {
        LgdResult<D> lgdResult = new LgdResult();
        lgdResult.setSuccess(false);
        lgdResult.setErrorCode(500);
        lgdResult.setErrorMessage("系统错误");
        return lgdResult;
    }
}