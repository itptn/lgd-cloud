package com.lgd.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author YYJ
 * @version 1.0
 * @since 2020/9/16 17:20
 */
public class DateUtils {

    /**
     * 完整日期+时间
     */
    private final static DateTimeFormatter DATE_FORMAT_01 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final static DateTimeFormatter DATE_FORMAT_02 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * 只有日期
     */
    private final static DateTimeFormatter DATE_FORMAT_11 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final static DateTimeFormatter DATE_FORMAT_12 = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * 当天日期
     *
     * @return 2020-08-10
     */
    public static String today() {
        return toDateStr(LocalDate.now());
    }

    /**
     * 返回日期字符串
     *
     * @param date 2020-08-10
     * @return 2020-08-10
     */
    public static String toDateStr(LocalDate date) {
        try {
            if (null != date) {
                return date.format(DATE_FORMAT_11);
            }
        } catch (Exception e) {
//            log.info("[{}]转换String失败", date, e);
        }
        return "";
    }
}
