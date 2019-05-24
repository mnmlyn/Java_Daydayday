/*
 * 演示使用Servlet，提供一个验证码服务
 * 
 * 1. 使用BufferedImage创建一个图片
 * 2. 获取图片的画笔Graphics对象，对图片进行操作
 * 3. 使用ImageIO.write将图片输出到指定的输出流
 * 
 * 告诉浏览器不使用缓存的方式：
 * 第一，可以在请求中加一个?t=new Date().getTime()来增加时间值，自动重新请求。
 * 第二，在HTTP响应头中设置no-cache。针对不同浏览器共有三种设置，参见下边代码
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
		// 1. 创建一个指定大小和类型的图片
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 2. 获取图片的画笔对象，对图片进行绘制
		Graphics g = img.getGraphics();
		// 设置画笔颜色
		g.setColor(Color.PINK);
		// 画一个实心矩形
		g.fillRect(1, 1, width - 2, height - 2);
		g.setColor(Color.RED);
		// 画空心矩形
		g.drawRect(0, 0, width - 1, height - 1);

		// 画文本
		g.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 35));
		g.setColor(Color.BLUE);
		Random rand = new Random();
		for (int i = 0; i < 4; ++i) {
			g.drawString(rand.nextInt(10) + "", width / 4 * i, 35);
		}
		
		// 画干扰线条
		for (int i = 0; i < 5; ++i) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}

		// 告知浏览器不使用缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expires", 0);
		
		// 3. 使用ImageIO.write将图片输出到指定输出流
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

}
