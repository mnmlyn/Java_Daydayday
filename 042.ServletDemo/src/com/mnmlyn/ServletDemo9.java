/*
 * ��ʾʹ��Servlet���ṩһ����֤�����
 * 
 * 1. ʹ��BufferedImage����һ��ͼƬ
 * 2. ��ȡͼƬ�Ļ���Graphics���󣬶�ͼƬ���в���
 * 3. ʹ��ImageIO.write��ͼƬ�����ָ���������
 * 
 * �����������ʹ�û���ķ�ʽ��
 * ��һ�������������м�һ��?t=new Date().getTime()������ʱ��ֵ���Զ���������
 * �ڶ�����HTTP��Ӧͷ������no-cache����Բ�ͬ����������������ã��μ��±ߴ���
 */
package com.mnmlyn;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo9
 */
@WebServlet("/demo9")
public class ServletDemo9 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width = 100;
		int height = 40;
		// 1. ����һ��ָ����С�����͵�ͼƬ
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 2. ��ȡͼƬ�Ļ��ʶ��󣬶�ͼƬ���л���
		Graphics g = img.getGraphics();
		// ���û�����ɫ
		g.setColor(Color.PINK);
		// ��һ��ʵ�ľ���
		g.fillRect(1, 1, width - 2, height - 2);
		g.setColor(Color.RED);
		// �����ľ���
		g.drawRect(0, 0, width - 1, height - 1);

		// ���ı�
		g.setFont(new Font("����", Font.BOLD | Font.ITALIC, 35));
		g.setColor(Color.BLUE);
		Random rand = new Random();
		for (int i = 0; i < 4; ++i) {
			g.drawString(rand.nextInt(10) + "", width / 4 * i, 35);
		}
		
		// ����������
		for (int i = 0; i < 5; ++i) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}

		// ��֪�������ʹ�û���
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expires", 0);
		
		// 3. ʹ��ImageIO.write��ͼƬ�����ָ�������
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

}
