/*package com.marakana.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*//**
 * Servlet implementation class HelloWorld
 *//*
@WebServlet("/hello-servlet")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().println("<html><body><h1>HelloWorld</h1></body></html>");
	
		
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		RequestDispatcher view = request.getRequestDispatcher("jsp/hello.jsp");
		view.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
		response.setContentType("text/html");
	//	response.setContentType("text/html");
 	//	response.getWriter().println("<html><body><h1>HelloWorld</h1></body></html>");
 	//	response.getWriter().println("<html><body><h1>HelloWorld</h1></body></html>");
		
		String[] names = request.getParameter("names").split("\\|");
		request.setAttribute("names", names);
 		RequestDispatcher view = request.getRequestDispatcher("jsp/hello.jsp");
 		view.forward(request, response);
 		view.forward(request, response);
 	}
 	}



*/