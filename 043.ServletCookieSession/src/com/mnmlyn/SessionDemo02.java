/*
 * 演示Session的使用
 * 
 * 注意，Session在一次会话中有效，可以用于记录登录状态，获取浏览记录等功能
 */
package com.mnmlyn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo02
 */
@WebServlet("/demo02")
public class SessionDemo02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP请求中，若包含浏览器发来的cookie，则可以通过getSession来获取到对应的Session
		HttpSession session = request.getSession();
		session.setAttribute("user", "Tom");
		System.out.println(session.getAttribute("user"));
		System.out.println(session.getId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
