/*
 * ServletResponse�������HTTP��Ӧ
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
		
		// ��getWriter֮ǰ������setCharacterEncoding��setContentType
		// response.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html");
		// �����������±����ȼ�
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.write("��ã�");
	}

	private void ErrorDemo1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/* ע�͵�����ʾ������һ����������Ľ��ͣ���֪setContentType��setCharacterEncoding��
		 * ��Ӧ��getWriter֮ǰ����responseδ���ύʱ��������
		// �������ԣ��±�������д�����ǻ������
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html; charset=GBK");
		response.setCharacterEncoding("GBK");
		response.setHeader("Content-Type", "text/html; charset=GBK");
		writer.write("��ã�");
		response.getWriter().append("��Served at: ").append(request.getContextPath());
		*/
	}

}
