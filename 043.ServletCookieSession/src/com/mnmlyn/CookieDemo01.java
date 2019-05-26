/*
 * ��ͻ��˷���cookie������path����ȡcookie
 * 
 * ɾ��cookie��ֻ��Ҫ������ȷ��path�����ҽ�maxAge����Ϊ0
 */
package com.mnmlyn;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo01
 */
@WebServlet("/demo01")
public class CookieDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		// ��ȡcookie
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if("lastAccessTime".equals(cookie.getName())){
					long ts = Long.parseLong(cookie.getValue());
					Date date = new Date(ts);
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
					String time = sdf.format(date);
					System.out.println(time);
					response.getWriter().write("�ϴη���ʱ��Ϊ��" + time);
				}
			}
		}
		 
		// ����cookie
		Cookie cookie = new Cookie("lastAccessTime", new Date().getTime() + "");
		cookie.setPath(request.getContextPath());// ����cookie��path
		cookie.setMaxAge(30);// ����cookie������ʱ�䣬������������رպ���Ȼ��Ч
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
