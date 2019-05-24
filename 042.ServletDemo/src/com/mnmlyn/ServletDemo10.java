/*
 * 演示通过响应头，让页面定时刷新和跳转
 * 
 * 主要是设置HTTP HEADER中的refresh
 * 跳转通过refresh=10;url=xxxxxxx来跳转
 */
package com.mnmlyn;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo10
 */
@WebServlet("/demo10")
public class ServletDemo10 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置浏览器1s刷新一次页面
		/*
		response.setHeader("refresh", "1");
		Random rand = new Random();
		response.getWriter().write(rand.nextInt() + "");
		*/
		
		// 设置为3s后刷新进入其他页面
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("refresh", "3;url=/042.ServletDemo/1.html");
		response.getWriter().write("访问成功！3s后自动回到静态页面！");
	}

}
