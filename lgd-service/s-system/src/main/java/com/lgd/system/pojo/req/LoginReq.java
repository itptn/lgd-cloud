package com.lgd.system.pojo.req;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/11/5 15:07
 */
@Getter
@Setter
public class LoginReq implements Serializable {
    private static final long serialVersionUID = -3282904392457271336L;

    private String username;
    private String password;
    private String mobile;
    private String captcha;
    private String type;
}