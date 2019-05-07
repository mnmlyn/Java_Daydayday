/*
 * TCP�ͻ���
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
		// ʹ��BufferedReader��PringStream�Ż����ͽ��չ���
		Socket socket = new Socket("127.0.0.1", 9988);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("��ã�����ˣ�");
		System.out.println(br.readLine());
		socket.close();
	}

	private static void Test1() throws UnknownHostException, IOException {
		// �����׽��֣������ӵ�ָ���������Ͷ˿�
		Socket socket = new Socket("127.0.0.1", 9988);
		// ���׽��ֻ�ȡ��������ֽ���
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();

		byte[] arr = new byte[1024];
		int len = is.read(arr);
		System.out.println(new String(arr, 0, len));

		os.write("��ã�TCPServer��".getBytes());
		// �ر��׽���
		socket.close();
	}

}
