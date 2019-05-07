/*
 * UDP·þÎñ¶Ë
 */
package com.mnmlyn;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(9982);
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
		socket.receive(packet);

		byte[] rcvBuffer = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(rcvBuffer, 0, len));
		socket.close();
	}

}
