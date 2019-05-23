/*
 * ������ʱ��ֱ������Servlet������ģ�崴���������±�������ʽ
 * 
 * 1. 
 * ���Կ�����ֻҪ�ڼ̳�HttpServlet�����ϱߣ���WebServletע����б�ע��������Ҫ��web.xml�н�������
 * ������ĺ÷��㡣
 * 
 * 2. ServletConfig
 * ����ǵ�ǰServlet��������Ϣ
 * 
 * 3. ServletContext
 * ����������Ŀ������Servlet�����������Ϣ
 * ����ͨ��setAttribute��getAttribute�������úͻ�ȡ���󣬹����Servlet����
 * Ҳ���Ի�ȡweb.xml�е����ò���
 * 
 * 4. ��ȡ����������Ŀ¼�µ�������Դ�ڱ��صľ���·��
 * ͨ��ServletContext
 */
package com.mnmlyn;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo4
 */
@WebServlet(
		name = "servletDemo4", 
		urlPatterns = { "/demo4" },
		initParams = { 
				@WebInitParam(name = "param1", value = "123", description = "ccccccc"), 
				@WebInitParam(name = "param2", value = "root", description = "���ǲ�������2")
		})
public class ServletDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo4() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ��ʼ�����õķ���������Ǿ����ڴ�Servlet�Ĳ���
		String str = this.getInitParameter("param1");
		System.out.println(str);
		System.out.println(this.getServletName());
		
		// ServletContext���úͻ�ȡ������Ŀ��Χ�Ķ��󣬹����Servlet����
		ServletContext context = this.getServletContext();
		context.setAttribute("GlobalParam1", "StringObject1");
		// ��������һ��Servlet�н��л�ȡ
		System.out.println(context.getAttribute("GlobalParam1"));
		
		// ��ȡ��ʼ��������������web.xml������
		System.out.println(context.getInitParameter("context-param"));
		
		// ��ȡ��Դ�ı��ؾ���·��
		String path = context.getRealPath("/1.html");
		System.out.println(path);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
