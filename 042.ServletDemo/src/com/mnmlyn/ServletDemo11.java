/*
 * 演示重定向的实现
 */
package com.mnmlyn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo11
 */
@WebServlet("/demo11")
public class ServletDemo11 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("服务要被重定向了！");
		
		// 设置重定向状态码，并且设置location，这是HTTP协议的内容
		//response.setStatus(302);
		//response.setHeader("location", "/042.ServletDemo/1.html");
		
		// 以上两句，可以写为
		response.sendRedirect("/042.ServletDemo/1.html");
	}

}
