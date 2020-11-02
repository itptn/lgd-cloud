package com.lgd.base.constant;

/**
 * 乐观点系统级别常量
 *
 * @author YYJ
 * @version 1.0
 * @since 2020/9/16 13:54
 */
public class LgdConstant {

    public static final int SYSTEM_USER_ID = 1;
    public static final String SYSTEM_USER_NAME = "leguandian";

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 令牌自定义标识
     */
    public static final String HEADER = "Authorization";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 验证码有效期（分钟）
     */
    public static final long CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌有效期（分钟）
     */
    public final static long TOKEN_EXPIRE = 60;

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 用户ID字段
     */
    public static final String DETAILS_USER_ID = "user_id";

    /**
     * 用户名字段
     */
    public static final String DETAILS_USERNAME = "username";

    /**
     * 权限缓存前缀
     */
    public final static String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 用户名长度限制
     */
    public static final int USERNAME_MIN_LENGTH = 2;

    public static final int USERNAME_MAX_LENGTH = 20;

    /**
     * 密码长度限制
     */
    public static final int PASSWORD_MIN_LENGTH = 5;

    public static final int PASSWORD_MAX_LENGTH = 20;

    /**
     * 根节点
     */
    public static final Long ROOT_NODE = 0L;
}