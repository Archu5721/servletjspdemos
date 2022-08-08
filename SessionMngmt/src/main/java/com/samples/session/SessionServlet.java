package com.samples.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		HttpSession session= request.getSession();
		session.setAttribute("user",username);
		PrintWriter out =  response.getWriter();
		out.println("Session Servlet!!");
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = new Cookie("user", username);
		response.addCookie(cookie);
		
	}

}
