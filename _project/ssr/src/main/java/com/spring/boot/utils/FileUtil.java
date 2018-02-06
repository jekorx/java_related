package com.spring.boot.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.spring.boot.config.domains.Constants;
import com.spring.boot.config.domains.ResultEnum;
import com.spring.boot.config.domains.WebException;

/**
 * 文件操作工具类
 * @author wang_donggang
 */
public class FileUtil {
	
	/**
	 * 上传文件
	 * @param file
	 * @param subPath
	 * @return
	 */
	public static String fileUpload(MultipartFile file, String subPath) {
		if (file == null || file.isEmpty()) {
			// 文件为空返回空路径
			return "";
		}
		// 原始文件名
		String originalFileName = file.getOriginalFilename();
		// 获取文件的后缀名
		String suffixName = originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();
		// 不是允许的文件类型禁止上传
		if (Constants.FILE_ALLOW_SUFFIX.indexOf(suffixName) == -1) {
			throw new WebException(ResultEnum.FILE_NOT_ALLOW);
		}
		// 新文件名
		String fileName = UUID.randomUUID().toString();
		// 文件保存路径
		String filePath = Constants.FILE_REAL_PATH + subPath + "//";
		// 完整文件路径+名
		String path = filePath + fileName + suffixName;
		// 文件保存对象
		File dest = new File(path);
		// 如果目录不存在
		if (!dest.getParentFile().exists()) {
			// 创建
			dest.getParentFile().mkdirs();
		}
		try {
			// MultipartFile的transferTo方法，保存文件
			file.transferTo(dest);
			// 返回可访问的服务器路径
			return Constants.FILE_SERVER_PATH + subPath + "/" + fileName + suffixName;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 上传失败
		return Constants.FILE_404;
	}
	
}
