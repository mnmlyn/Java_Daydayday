/*
 * TCP客户端
 */
package com.mnmlyn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) throws IOException {
		// Test1();
		Test2();
	}

	private static void Test2() throws UnknownHostException, IOException {
		// 使用BufferedReader和PringStream优化发送接收过程
		Socket socket = new Socket("127.0.0.1", 9988);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("你好，服务端！");
		System.out.println(br.readLine());
		socket.close();
	}

	private static void Test1() throws UnknownHostException, IOException {
		// 创建套接字，并连接到指定的主机和端口
		Socket socket = new Socket("127.0.0.1", 9988);
		// 从套接字获取输入输出字节流
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();

		byte[] arr = new byte[1024];
		int len = is.read(arr);
		System.out.println(new String(arr, 0, len));

		os.write("你好，TCPServer！".getBytes());
		// 关闭套接字
		socket.close();
	}

}
