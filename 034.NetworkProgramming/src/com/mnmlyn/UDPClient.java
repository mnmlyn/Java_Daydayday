/*
 * ������
 * 
 * 1. UDPͨ��
 * DatagramSocket,DatagramPacket,InetAddress
 */
package com.mnmlyn;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		// UDPͨ�ţ��ͻ��ˣ�����˿�
		String sendBuffer = "hello";
		DatagramSocket socket = new DatagramSocket();
		DatagramPacket packet = new DatagramPacket(sendBuffer.getBytes(), sendBuffer.getBytes().length,
				InetAddress.getByName("127.0.0.1"), 9982);
		socket.send(packet);
		socket.close();
	}

}
