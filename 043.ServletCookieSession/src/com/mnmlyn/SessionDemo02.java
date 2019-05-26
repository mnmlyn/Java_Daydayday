/*
 * ��ʾSession��ʹ��
 * 
 * ע�⣬Session��һ�λỰ����Ч���������ڼ�¼��¼״̬����ȡ�����¼�ȹ���
 */
package com.mnmlyn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo02
 */
@WebServlet("/demo02")
public class SessionDemo02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP�����У������������������cookie�������ͨ��getSession����ȡ����Ӧ��Session
		HttpSession session = request.getSession();
		session.setAttribute("user", "Tom");
		System.out.println(session.getAttribute("user"));
		System.out.println(session.getId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
