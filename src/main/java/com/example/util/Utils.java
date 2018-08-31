package com.example.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zp
 * @Description: 日期格式化
 * @date 2018/8/30 21:55
 */
public class Utils {
    private final static String date_s = "yyyy-MM-dd HH:mm:ss";
    private final static String like_s = "%";

    public static final String delete_T = "T";
    public static final String delete_F = "F";

    /**
     * @Description: 获取 字符串日期
     * @author zp
     * @date 2018/8/30 11:51
     */
    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(date_s);
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * @Description: 传入字符串获得拼接后的字符串 格式： '%string%'
     * @author zp
     * @date 2018/8/31 11:55
     */
    public static String getLikes(String befor) {
        String after = like_s + befor + like_s;
        return after;
    }
}
