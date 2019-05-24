/*
 * ��ʾһ�£�response.getOutputStream()
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
		// ע�⣬getWriter��getOutputStreamֻ����һ��������
		ServletOutputStream sos = response.getOutputStream();
		// ע�⣬���ﰴ���ֽ��������Ҫ��֤��Ϣ�ı��룬��HTTP Header�и��߿ͻ���������ı���һ�£���Ȼ���������
		sos.write("��ð���".getBytes("UTF-8"));
	}

}
