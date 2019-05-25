/*
 * 演示按照InputStream方式，读取Request
 */
package com.mnmlyn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo13
 */
@WebServlet("/demo13")
public class ServletDemo13 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object param = request.getAttribute("param");
		System.out.println("Demo13, param = " + param);
		
		// 按照InputStream获取Request中的信息
		// 浏览器网址带上参数，来测试
		ServletInputStream sis = request.getInputStream();
		int len = 0;
		byte[] buf = new byte[1024];
		while((len = sis.read(buf)) != -1) {
			System.out.println(new String(buf, 0, len));
		}
		sis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
