/*
 * TCP服务端
 */
package com.mnmlyn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		// Test1();
		// Test2();
		Test3();
	}

	private static void Test3() throws IOException {
		// 将服务器改为多线程
		ServerSocket server = new ServerSocket(9988);
		while (true) {
			Socket socket = server.accept();
			new Thread() {
				@Override
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						System.out.println(br.readLine());
						ps.println("你好，客户端！");
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
		}
		// server.close();
	}

	private static void Test2() throws IOException {
		// 使用BufferedReader和PrintStream优化输入输出
		ServerSocket server = new ServerSocket(9988);
		Socket socket = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		System.out.println(br.readLine());
		ps.println("你好，客户端！");
		socket.close();
		server.close();
	}

	private static void Test1() throws IOException {
		// 创建套接字，并绑定到端口
		ServerSocket server = new ServerSocket(9988);
		// accept获得连接套接字
		Socket socket = server.accept();
		// 连接套接字中获取输入输出字节流
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();

		os.write("你好，TCPClient！".getBytes());
		byte[] arr = new byte[1024];
		int len = is.read(arr);
		System.out.println(new String(arr, 0, len));
		// 关闭连接套接字
		socket.close();
		// 关闭监听套接字
		server.close();
	}

}
