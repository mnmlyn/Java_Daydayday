/*
 * 网络编程
 * 
 * 1. UDP通信
 * DatagramSocket,DatagramPacket,InetAddress
 */
package com.mnmlyn;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		// UDP通信，客户端，随机端口
		String sendBuffer = "hello";
		DatagramSocket socket = new DatagramSocket();
		DatagramPacket packet = new DatagramPacket(sendBuffer.getBytes(), sendBuffer.getBytes().length,
				InetAddress.getByName("127.0.0.1"), 9982);
		socket.send(packet);
		socket.close();
	}

}
