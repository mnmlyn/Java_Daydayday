/*
 * 演示Servlet的使用，使用继承GenericsServlet的方式。
 * 使用适配器模式，也就是GenericServlet实现了Servlet中的方法
 * 
 * 1. 创建一个class，继承GenericServlet，重写其未实现方法service
 * 2. 修改WebContent目录下的WEB-INF下的web.xml，增加servlet配置，和URI配置
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
		System.out.println("ServletDemo2的service方法被调用了");
		res.getWriter().write("Hello, I'm demo2!");
	}

}
