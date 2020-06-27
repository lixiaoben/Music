package cn.tedu.music.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间相关的工具类
 */
public class DateUtils {
    public static final SimpleDateFormat format = new SimpleDateFormat("mm:ss");
    /**
     * 按照format的格式 解析time时间戳
     * 返回格式化之后的字符串
     * @param time  时间戳
     * @return
     */
    public static String parseTime(int time){
        return format.format(new Date(time));
    }
}

