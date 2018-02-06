package com.dwr.push;

import java.net.URLEncoder;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;

public class DwrPush {
	
	public void msg(final String msg) {
		ScriptBuffer sb = new ScriptBuffer();
		Browser.withAllSessions(() -> {
			// 调用js的回调函数处理返回的内容，注意字符串参数加单引号
			sb.appendScript("sendDwrMsg('");
			try {
				// 前端接收到decode，防止中文乱码
				sb.appendScript(URLEncoder.encode(msg, "UTF-8"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			sb.appendScript("')");
			Browser.getTargetSessions().stream().forEach((session) -> {
				session.addScript(sb);
			});
		});
	}
	
}
