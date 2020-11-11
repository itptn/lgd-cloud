package com.lgd.base;

import com.lgd.base.enums.ResultEnum;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/4 17:03
 */
@Getter
public class LgdResult<D> implements Serializable {

    private static final long serialVersionUID = -7237955868021173850L;
    private boolean success;
    private String code;
    private String msg;
    private D data;

    /**
     * 初始化【成功】结果
     *
     * @param data
     * @param <D>
     * @return LgdResult
     */
    public static <D> LgdResult<D> init(D data) {
        return init(true, ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 初始化【失败】结果
     *
     * @param <D>
     * @return LgdResult
     */
    public static <D> LgdResult<D> init() {
        return init(ResultEnum.FAIL.getMsg());
    }

    /**
     * 初始化【失败】结果
     *
     * @param msg
     * @param <D>
     * @return LgdResult
     */
    public static <D> LgdResult<D> init(String msg) {
        return init(false, ResultEnum.FAIL.getCode(), msg, null);
    }

    /**
     * 初始化【失败】结果
     *
     * @param resultEnum
     * @param <D>
     * @return LgdResult
     */
    public static <D> LgdResult<D> init(ResultEnum resultEnum) {
        return init(false, ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg(), null);
    }


    /**
     * 设置成功
     *
     * @param data
     * @return LgdResult
     */
    public LgdResult setOk(D data) {
        this.setSuccess(true);
        this.setCode(ResultEnum.SUCCESS.getCode());
        this.setMsg(ResultEnum.SUCCESS.getMsg());
        this.setData(data);
        return this;
    }

    /**
     * 设置失败
     *
     * @param msg
     * @return LgdResult
     */
    public LgdResult setFail(String msg) {
        this.setSuccess(false);
        this.setCode(ResultEnum.FAIL.getCode());
        this.setMsg(msg);
        return this;
    }

    /**
     * 设置失败
     *
     * @param resultEnum
     * @return LgdResult
     */
    public LgdResult setFail(ResultEnum resultEnum) {
        this.setSuccess(false);
        this.setCode(resultEnum.getCode());
        this.setMsg(resultEnum.getMsg());
        return this;
    }

    /**
     * 设置结果数据
     *
     * @param data
     * @return LgdResult
     */
    public LgdResult setData(D data) {
        this.data = data;
        return this;
    }

    private static <D> LgdResult<D> init(boolean success, String code, String msg, D data) {
        LgdResult<D> lgdResult = new LgdResult();
        lgdResult.setSuccess(success);
        lgdResult.setCode(code);
        lgdResult.setMsg(msg);
        lgdResult.setData(data);
        return lgdResult;
    }

    void setSuccess(boolean success) {
        this.success = success;
    }

    void setCode(String code) {
        this.code = code;
    }

    void setMsg(String msg) {
        this.msg = msg;
    }
}