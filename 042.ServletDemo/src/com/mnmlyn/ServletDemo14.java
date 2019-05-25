/*
 * 演示Servlet转发的另一种方式。演示Request中设置新的参数进行传递。
 * 演示请求包含include，也就是将将另一个Servlet中的代码一并执行
 * 
 * 上一种在ServletDemo5中，
 * this.getServletContext().getRequestDispatcher("/demo4").forward(request, response);、
 * 这一种是，
 * request.getRequestDispatcher("/demo13").forward(request, response);
 * 
 * 请求包含如下，不再重新敲一个了
 * request.getRequestDispatcher("/demo").include(request, response);
 */
package com.mnmlyn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo14
 */
@WebServlet("/demo14")
public class ServletDemo14 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置一个Request中可见的参数，可以在转发后的Servlet中获得
		request.setAttribute("param", "hello");
		
		// 请求转发
		System.out.println("请求将被转发");
		request.getRequestDispatcher("/demo13").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
