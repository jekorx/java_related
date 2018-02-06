package com.dwr.login;

import java.net.URLEncoder;

import javax.servlet.ServletException;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;

public class DwrLoginPush {
	
	public void onPageLoad(String userId) {
		ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
		scriptSession.setAttribute("userId", userId);
		
		DwrScriptSessionManagerUtil util = new DwrScriptSessionManagerUtil();
		try {
			util.init();
		} catch (ServletException e) {
			System.out.println("init error");
			e.printStackTrace();
		}
	}
	
	public void msg(final String userId, final String msg) {
		ScriptBuffer sb = new ScriptBuffer();
		Browser.withAllSessionsFiltered(session -> {
			// 如果不传推送人，全部推送
			if (userId == null || userId.isEmpty())
				return true;
			// 如果ScriptSession中userId为空则不推送
			if (session.getAttribute("userId") == null)
				return false;
			// 如果ScriptSession中和推送人相同，则推送
			return session.getAttribute("userId").toString().equals(userId);
		}, () -> {
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
