package com.dwr.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 7010774507707063649L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		String sessionid = session.getId();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		session.setAttribute("sessionid", sessionid);
		//req.setAttribute("sessionid", sessionid);
		//req.getRequestDispatcher("index2.jsp").forward(req, res);
		res.sendRedirect("index2.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
		this.doGet(req, res);
	}
	
}
