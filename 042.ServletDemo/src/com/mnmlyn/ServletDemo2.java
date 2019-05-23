/*
 * ��ʾServlet��ʹ�ã�ʹ�ü̳�GenericsServlet�ķ�ʽ��
 * ʹ��������ģʽ��Ҳ����GenericServletʵ����Servlet�еķ���
 * 
 * 1. ����һ��class���̳�GenericServlet����д��δʵ�ַ���service
 * 2. �޸�WebContentĿ¼�µ�WEB-INF�µ�web.xml������servlet���ã���URI����
 */
package com.mnmlyn;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo2 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("ServletDemo2��service������������");
		res.getWriter().write("Hello, I'm demo2!");
	}

}
