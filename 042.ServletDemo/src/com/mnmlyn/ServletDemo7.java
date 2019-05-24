/*
 * 演示一下，response.getOutputStream()
 */
package com.mnmlyn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo7
 */
@WebServlet("/demo7")
public class ServletDemo7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		// 注意，getWriter和getOutputStream只能有一个被调用
		ServletOutputStream sos = response.getOutputStream();
		// 注意，这里按照字节流输出，要保证消息的编码，和HTTP Header中告诉客户端浏览器的编码一致，不然会产生乱码
		sos.write("你好啊！".getBytes("UTF-8"));
	}

}
