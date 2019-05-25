/*
 * ��ʾServletת������һ�ַ�ʽ����ʾRequest�������µĲ������д��ݡ�
 * ��ʾ�������include��Ҳ���ǽ�����һ��Servlet�еĴ���һ��ִ��
 * 
 * ��һ����ServletDemo5�У�
 * this.getServletContext().getRequestDispatcher("/demo4").forward(request, response);��
 * ��һ���ǣ�
 * request.getRequestDispatcher("/demo13").forward(request, response);
 * 
 * ����������£�����������һ����
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
		// ����һ��Request�пɼ��Ĳ�����������ת�����Servlet�л��
		request.setAttribute("param", "hello");
		
		// ����ת��
		System.out.println("���󽫱�ת��");
		request.getRequestDispatcher("/demo13").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
