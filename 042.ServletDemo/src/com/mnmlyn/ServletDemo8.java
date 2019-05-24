/*
 * ��ʾʹ��Servlet���ṩ�ļ�����
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
		// ��ȡ�������ļ��ı��ؾ���·��
		String path = this.getServletContext().getRealPath("/������.txt");
		System.out.println(path);
		FileInputStream fis = new FileInputStream(path);
		
		// ��ȡ�ļ���
		String filename = path.substring(path.lastIndexOf('\\') + 1);
		System.out.println(filename);
		// �ļ�������
		filename = URLEncoder.encode(filename, "UTF-8");
		
		// ��֪��������ո������أ���ָ���ļ���
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
