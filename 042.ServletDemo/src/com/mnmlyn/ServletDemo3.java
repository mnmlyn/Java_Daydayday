/*
 * 演示Servlet的使用，采用继承HttpServlet的方式。
 * 使用的是，模板方法设计模式。
 * 
 * 继承HttpServlet类，重写doGet方法，配置web.xml，即可对HTTP GET请求做出响应。
 * 
 * 其实，Tomcat服务器依然是调用了Servlet的service方法，但是在service方法中，将请求强转为Http请求和响应，
 * 当请求为GET方法时，调用HttpServlet定义的doGet方法。该方法默认返回不支持信息，只需要重写即可。
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
		System.out.println("-----Demo3的doGet方法被调用--------");
		resp.getWriter().write("Hello, demo3!");
	}
}
