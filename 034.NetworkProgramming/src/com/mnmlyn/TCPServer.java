/*
 * TCP�����
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
		// ����������Ϊ���߳�
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
						ps.println("��ã��ͻ��ˣ�");
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
		// ʹ��BufferedReader��PrintStream�Ż��������
		ServerSocket server = new ServerSocket(9988);
		Socket socket = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		System.out.println(br.readLine());
		ps.println("��ã��ͻ��ˣ�");
		socket.close();
		server.close();
	}

	private static void Test1() throws IOException {
		// �����׽��֣����󶨵��˿�
		ServerSocket server = new ServerSocket(9988);
		// accept��������׽���
		Socket socket = server.accept();
		// �����׽����л�ȡ��������ֽ���
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();

		os.write("��ã�TCPClient��".getBytes());
		byte[] arr = new byte[1024];
		int len = is.read(arr);
		System.out.println(new String(arr, 0, len));
		// �ر������׽���
		socket.close();
		// �رռ����׽���
		server.close();
	}

}
