/*
 * 创建的时候，直接输入Servlet，按照模板创建，就是下边这种形式
 * 
 * 1. 
 * 可以看到，只要在继承HttpServlet的类上边，用WebServlet注解进行标注，不再需要在web.xml中进行配置
 * 这样真的好方便。
 * 
 * 2. ServletConfig
 * 这个是当前Servlet的配置信息
 * 
 * 3. ServletContext
 * 这是整个项目，各个Servlet共享的配置信息
 * 可以通过setAttribute和getAttribute进行设置和获取对象，供多个Servlet共享
 * 也可以获取web.xml中的配置参数
 * 
 * 4. 获取服务器部署目录下的任意资源在本地的绝对路径
 * 通过ServletContext
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
				@WebInitParam(name = "param2", value = "root", description = "这是参数描述2")
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
		// 获取初始化配置的方法，这个是局限于此Servlet的参数
		String str = this.getInitParameter("param1");
		System.out.println(str);
		System.out.println(this.getServletName());
		
		// ServletContext设置和获取整个项目范围的对象，供多个Servlet共享
		ServletContext context = this.getServletContext();
		context.setAttribute("GlobalParam1", "StringObject1");
		// 可以在另一个Servlet中进行获取
		System.out.println(context.getAttribute("GlobalParam1"));
		
		// 获取初始化参数，可以在web.xml中配置
		System.out.println(context.getInitParameter("context-param"));
		
		// 获取资源的本地绝对路径
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
