/*
 * ��ʾ��ȡ����Request�е���Ϣ
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
		// 1. ��ȡ�������е���Ϣ
		// ��ȡHTTP��������
		System.out.println(request.getMethod());
		// ��ȡ�����URL
		System.out.println(request.getRequestURL());
		// ��ȡ�����URI
		System.out.println(request.getRequestURI());
		// ��ȡ��ǰURI��ǰ׺Path
		System.out.println(request.getContextPath());
		// ��ȡ�����еĲ�������ַ����?user=root&password=root
		System.out.println(request.getQueryString());
		
		// 2. ��ȡ�����Header�е���Ϣ
		// ��ȡָ��Header
		System.out.println(request.getHeader("User-Agent"));
		// ��ȡ����Headerö��
		System.out.println("---------------Header�а�����������---------------------");
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			System.out.println(name + ": " + request.getHeader(name));
		}
		// Header����ͬһ�����ж������ȡĳ�����Ƶ�Headerö��
		Enumeration<String> headers = request.getHeaders("Host");
		while(headers.hasMoreElements()) {
			String header = headers.nextElement();
			System.out.println(header);
		}
		
		// 3. ��ȡ�����еı�����
		// �������ģ�Ҫ���ύ�������htmlҳ�棬Ҳ���ǿͻ��������ʹ�õı�����ͬ<meta charset="UTF-8">
		request.setCharacterEncoding("UTF-8");
		System.out.println("��ȡ��form������userName=" + request.getParameter("userName"));
		System.out.println("��ȡ��form������password=" + request.getParameter("password"));
		System.out.println("��ȡ��form������sex=" + request.getParameter("sex"));
		String[] hobbys = request.getParameterValues("hobby");
		if (hobbys != null)//ע�����Ҫ�ж��Ƿ�����һ�����forѭ��������쳣
			for (String hobby : hobbys) {
				System.out.println("��ȡ��form������hobby=" + hobby);
			}
		System.out.println("��ȡ��form������city=" + request.getParameter("city"));
		System.out.println("��ȡ��form������code=" + request.getParameter("code"));
		
		// ��ȡ�ύ�ı�������keyֵ����ͨ��key��ȡvalue
		System.out.println("-------------------------");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String[] values = request.getParameterValues(name);
			System.out.println("��ȡ��form�����ֶΣ�" + name);
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
