/*
 * ��ʾ��δ���Servlet����Ŀ
 * 
 * 1. �½�һ��Dynamic Web Project��ע��ҪѡRuntime���ã���Ȼû��Tomcat�İ����޷�����Servlet
 * 2. ��src���½�һ��package�������´���һ��class��ʵ��Servlet�ӿ�
 * 3. ��Servers�����У��½�һ��Tomcat����������Ŀ��ӵ�Servers��
 * 4. �������̵�ʱ�����һֱ��next���Զ���WebContent�µ�WEB-INF�£�����web.xml�������Լ�������
 *    д���μ��������е�web.xml
 * 5. ��Servers�����У�����Server����������д�http://localhost:8081/042.ServletDemo/demo1
 */
package com.mnmlyn;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo1 implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("------��ʼ������һ�η���ʱ�����ã�������Ϊ����ʱload����Server����ʱ����------");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("------����ÿ�η��ʶ�������------");
		res.getWriter().write("Hello World");
	}
	
	@Override
	public void destroy() {
		System.out.println("------���٣�Ӧ�ñ�ж��ʱ������------");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

}
