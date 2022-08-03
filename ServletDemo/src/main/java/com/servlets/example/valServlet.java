package com.servlets.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class valServlet extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int number1 = Integer.parseInt(req.getParameter("number1"));
		int number2 = Integer.parseInt(req.getParameter("number2"));
		
		int result = number1 + number2;
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1> Result is : " + result + "</h3>");
	}

}
