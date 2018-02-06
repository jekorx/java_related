package com.spring.boot.config.domains;

import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.spring.boot.utils.ResultUtil;

/**
 * 常量
 * @author wang_donggang
 */
public class Constants {
	
	// 拦截路径
	public final static String[] INTERCEPTOR_URLS = {"/app/"};
	// 请求拦截的返回json
	public final static String USER_NOT_LOGIN = JSON.toJSONString(ResultUtil.error(ResultEnum.USER_NOT_LOGIN));
	
	// 用户token key
	public final static String USER_TOKEN = "__UTOKEN__";
	
	// redis中保存用户信息变量
	// 保存时长
	public final static int REDIS_EXPIRE = 300;
	// 单位
	public final static TimeUnit REDIS_EXPIRE_UNIT = TimeUnit.MINUTES;
	
	// 年月日时分秒日期格式
	public final static String DATE_FMT_YMDHMS = "yyyy-MM-dd HH:mm:ss";
	
	// 真实保存路径
	public final static String FILE_REAL_PATH = "F://ProgramFiles//Apache2.2//htdocs//images//";
	// 服务器路径
	public final static String FILE_SERVER_PATH = "http://127.0.0.1/images/";
	// 没有图片
	public final static String FILE_404 = "http://127.0.0.1/images/404.gif";
	// 允许上传的文件后缀
	public final static String FILE_ALLOW_SUFFIX = ".jpg.png.gif";
}
