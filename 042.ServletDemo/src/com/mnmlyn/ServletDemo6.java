/*
 * ServletResponse代表的是HTTP响应
 * 
 * 
 */
package com.mnmlyn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo6
 */
@WebServlet("/demo6")
public class ServletDemo6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ErrorDemo1(request, response);
		
		// 在getWriter之前，调用setCharacterEncoding和setContentType
		// response.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html");
		// 以上两句与下边这句等价
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.write("你好！");
	}

	private void ErrorDemo1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/* 注释掉错误示例，看一下这个函数的解释，可知setContentType和setCharacterEncoding，
		 * 都应在getWriter之前，且response未被提交时，被调用
		// 经过测试，下边这样的写法，是会乱码的
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html; charset=GBK");
		response.setCharacterEncoding("GBK");
		response.setHeader("Content-Type", "text/html; charset=GBK");
		writer.write("你好！");
		response.getWriter().append("哈Served at: ").append(request.getContextPath());
		*/
	}

}
