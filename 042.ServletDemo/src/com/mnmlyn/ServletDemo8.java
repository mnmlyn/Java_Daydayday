/*
 * 演示使用Servlet，提供文件下载
 */
package com.mnmlyn;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo8
 */
@WebServlet("/demo8")
public class ServletDemo8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取待下载文件的本地绝对路径
		String path = this.getServletContext().getRealPath("/下载我.txt");
		System.out.println(path);
		FileInputStream fis = new FileInputStream(path);
		
		// 获取文件名
		String filename = path.substring(path.lastIndexOf('\\') + 1);
		System.out.println(filename);
		// 文件名编码
		filename = URLEncoder.encode(filename, "UTF-8");
		
		// 告知浏览器按照附件下载，并指定文件名
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		
		ServletOutputStream sos = response.getOutputStream();
		int len = 0;
		byte[] buf = new byte[1024];
		while((len = fis.read(buf)) != -1) {
			sos.write(buf, 0, len);
		}
		fis.close();
	}

}
