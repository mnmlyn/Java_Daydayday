/*
 * ������ʾServlet��ת��
 * ����ǰ���󽻸�����Servlet����
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
		// Servlet�����ת��
		ServletContext context = this.getServletContext();
		// ָ��ת���ĵ�Servlet
		RequestDispatcher dispatcher = context.getRequestDispatcher("/demo4");
		dispatcher.forward(request, response);
		
		// ���û�������ã�֤��ת������Ӧ��Servletֱ�������HTTP��Ӧ
		response.getWriter().append("�������");
		System.out.println("�������");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
