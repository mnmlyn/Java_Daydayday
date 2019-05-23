/*
 * 这里演示Servlet的转发
 * 将当前请求交给其他Servlet处理
 */
package com.mnmlyn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo5
 */
@WebServlet(name = "servletDemo5", urlPatterns = { "/demo5" })
public class ServletDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet请求的转发
		ServletContext context = this.getServletContext();
		// 指定转发的的Servlet
		RequestDispatcher dispatcher = context.getRequestDispatcher("/demo4");
		dispatcher.forward(request, response);
		
		// 这句没有起作用，证明转发后，相应的Servlet直接完成了HTTP响应
		response.getWriter().append("处理完成");
		System.out.println("处理完成");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
