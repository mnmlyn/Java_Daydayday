/*
 * 演示获取请求Request中的信息
 */
package com.mnmlyn;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo12
 */
@WebServlet("/demo12")
public class ServletDemo12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 获取请求行中的信息
		// 获取HTTP请求类型
		System.out.println(request.getMethod());
		// 获取请求的URL
		System.out.println(request.getRequestURL());
		// 获取请求的URI
		System.out.println(request.getRequestURI());
		// 获取当前URI的前缀Path
		System.out.println(request.getContextPath());
		// 获取请求中的参数，地址最后加?user=root&password=root
		System.out.println(request.getQueryString());
		
		// 2. 获取请求的Header中的信息
		// 获取指定Header
		System.out.println(request.getHeader("User-Agent"));
		// 获取所有Header枚举
		System.out.println("---------------Header中包含以下内容---------------------");
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			System.out.println(name + ": " + request.getHeader(name));
		}
		// Header可以同一名称有多个，获取某个名称的Header枚举
		Enumeration<String> headers = request.getHeaders("Host");
		while(headers.hasMoreElements()) {
			String header = headers.nextElement();
			System.out.println(header);
		}
		
		// 3. 获取请求中的表单数据
		// 关于中文，要和提交这个表单的html页面，也就是客户端浏览器使用的编码相同<meta charset="UTF-8">
		request.setCharacterEncoding("UTF-8");
		System.out.println("获取到form表单数据userName=" + request.getParameter("userName"));
		System.out.println("获取到form表单数据password=" + request.getParameter("password"));
		System.out.println("获取到form表单数据sex=" + request.getParameter("sex"));
		String[] hobbys = request.getParameterValues("hobby");
		if (hobbys != null)//注意这里，要判断是否有这一项，否则for循环会出现异常
			for (String hobby : hobbys) {
				System.out.println("获取到form表单数据hobby=" + hobby);
			}
		System.out.println("获取到form表单数据city=" + request.getParameter("city"));
		System.out.println("获取到form表单数据code=" + request.getParameter("code"));
		
		// 获取提交的表单的所有key值，并通过key获取value
		System.out.println("-------------------------");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String[] values = request.getParameterValues(name);
			System.out.println("获取到form表单的字段：" + name);
			if (values == null)
				continue;
			for (int i = 0; i < values.length; i++) {
				String value = values[i];
				System.out.println("    " + name + " = " + value);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
