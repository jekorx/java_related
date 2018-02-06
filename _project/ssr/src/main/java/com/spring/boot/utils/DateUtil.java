package com.spring.boot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.spring.boot.config.domains.Constants;

/**
 * 时间类工具
 * @author wang_donggang
 */
public class DateUtil {
	
	/**
	 * 获取当前时间的yyyy-MM-dd HH:mm:ss格式的时间戳
	 * @return
	 */
	public static String getStrTimeNow() {
		return getStrTimeWithDate(new Date());
	}
	
	/**
	 * 根据date获取yyyy-MM-dd HH:mm:ss格式的时间戳
	 * @param date
	 * @return
	 */
	public static String getStrTimeWithDate(Date date) {
		return getStrTimeWithDateFmt(date, Constants.DATE_FMT_YMDHMS);
	}
	
	/**
	 * 根据date和fmt获取String时间戳
	 * @param date
	 * @param fmt
	 * @return
	 */
	public static String getStrTimeWithDateFmt(Date date, String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		return sdf.format(date);
	}
	
}
