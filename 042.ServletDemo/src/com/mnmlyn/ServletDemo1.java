/*
 * 演示如何创建Servlet的项目
 * 
 * 1. 新建一个Dynamic Web Project，注意要选Runtime配置，不然没有Tomcat的包，无法导入Servlet
 * 2. 在src中新建一个package，在其下创建一个class，实现Servlet接口
 * 3. 在Servers窗口中，新建一个Tomcat服务器将项目添加到Servers中
 * 4. 创建工程的时候，最好一直点next，自动在WebContent下的WEB-INF下，生成web.xml。否则，自己创建，
 *    写法参见本工程中的web.xml
 * 5. 在Servers窗口中，启动Server。在浏览器中打开http://localhost:8081/042.ServletDemo/demo1
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
		System.out.println("------初始化，第一次访问时被调用，当配置为启动时load则在Server启动时调用------");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("------服务，每次访问都被调用------");
		res.getWriter().write("Hello World");
	}
	
	@Override
	public void destroy() {
		System.out.println("------销毁，应用被卸载时被调用------");
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
