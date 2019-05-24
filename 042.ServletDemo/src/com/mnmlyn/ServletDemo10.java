/*
 * ��ʾͨ����Ӧͷ����ҳ�涨ʱˢ�º���ת
 * 
 * ��Ҫ������HTTP HEADER�е�refresh
 * ��תͨ��refresh=10;url=xxxxxxx����ת
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
		// ���������1sˢ��һ��ҳ��
		/*
		response.setHeader("refresh", "1");
		Random rand = new Random();
		response.getWriter().write(rand.nextInt() + "");
		*/
		
		// ����Ϊ3s��ˢ�½�������ҳ��
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("refresh", "3;url=/042.ServletDemo/1.html");
		response.getWriter().write("���ʳɹ���3s���Զ��ص���̬ҳ�棡");
	}

}
