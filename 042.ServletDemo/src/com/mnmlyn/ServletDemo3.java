/*
 * ��ʾServlet��ʹ�ã����ü̳�HttpServlet�ķ�ʽ��
 * ʹ�õ��ǣ�ģ�巽�����ģʽ��
 * 
 * �̳�HttpServlet�࣬��дdoGet����������web.xml�����ɶ�HTTP GET����������Ӧ��
 * 
 * ��ʵ��Tomcat��������Ȼ�ǵ�����Servlet��service������������service�����У�������ǿתΪHttp�������Ӧ��
 * ������ΪGET����ʱ������HttpServlet�����doGet�������÷���Ĭ�Ϸ��ز�֧����Ϣ��ֻ��Ҫ��д���ɡ�
 */
package com.mnmlyn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo3 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-----Demo3��doGet����������--------");
		resp.getWriter().write("Hello, demo3!");
	}
}
