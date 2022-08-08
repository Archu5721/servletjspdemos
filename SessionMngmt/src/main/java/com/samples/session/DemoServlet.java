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


@WebServlet("/demoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		PrintWriter out = response.getWriter();
		out.println("Username is : " + username);
		
		Cookie[] cookies = request.getCookies();
		Cookie mycookies = cookies[1];
	//	PrintWriter out = response.getWriter();
		out.println("Username (Cookies ): " + mycookies.getValue());
		
	}

}	