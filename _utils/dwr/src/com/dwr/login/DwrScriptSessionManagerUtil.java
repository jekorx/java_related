package com.dwr.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.directwebremoting.servlet.DwrServlet;

public class DwrScriptSessionManagerUtil extends DwrServlet {

	private static final long serialVersionUID = 2337279977953752130L;
	
	@Override
	public void init() throws ServletException {
		Container container = ServerContextFactory.get().getContainer();
		ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
		manager.addScriptSessionListener(new ScriptSessionListener() {
			@Override
			public void sessionCreated(ScriptSessionEvent event) {
				HttpSession session = WebContextFactory.get().getSession();
				String sessionid = session.getId();
				event.getSession().setAttribute("userId", sessionid);
			}
			@Override
			public void sessionDestroyed(ScriptSessionEvent event) {
				//System.out.println("退出");
			}
		});
	}

}
