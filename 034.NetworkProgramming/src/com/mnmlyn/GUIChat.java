package com.mnmlyn;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUIChat extends Frame {

	private TextArea viewText;
	private TextArea sendText;
	private Button send;
	private Button log;
	private Button clear;
	private Button shake;
	private TextField ipTextField;
	private DatagramSocket socket;
	private BufferedWriter logWriter;

	/**
	 * 窗口震动，其实就是不断改变窗口位置
	 */
	private void shake() {
		int x = this.getLocation().x;
		int y = this.getLocation().y;
		String title = this.getTitle();
		this.setTitle("震动中~");
		try {
			for (int i = 0; i < 10; ++i) {
				int k = 1;
				int scale = 80, base = y;
				for (int j = 0; j < 1000; j += 100) {
					if (k < 3) {
						k += 1;
					} else
						k = 1;
					this.setLocation(x + j - 500, base + (k - 2) * scale);
					Thread.sleep(100);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setTitle(title);
		this.setLocation(x, y);
	}

	/**
	 * 显示消息记录
	 * 
	 * @throws IOException
	 */
	private void logFile() throws IOException {
		logWriter.flush();
		FileInputStream fis = new FileInputStream("data.db");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();// 内存缓冲区

		int len;
		byte[] arr = new byte[8192];
		while ((len = fis.read(arr)) != -1) {
			baos.write(arr, 0, len);
		}

		String str = baos.toString();
		viewText.setText(str);
	}

	/**
	 * 接收，分配单独的线程
	 */
	private class Receive extends Thread {
		@Override
		public void run() {
			try {
				DatagramSocket socket = new DatagramSocket(9982);
				DatagramPacket packet = new DatagramPacket(new byte[8192], 8192);
				while (true) {
					socket.receive(packet);
					byte[] rcvBuffer = packet.getData();
					int len = packet.getLength();
					if (len == 1 && rcvBuffer[0] == -1) {
						// 震动指令
						shake();
						continue;
					}
					String ip = packet.getAddress().getHostAddress();// 获取IP地址
					String message = new String(rcvBuffer, 0, len);
					String time = getCurrentTime();
					String messageStr = time + " " + ip + "对我说\r\n" + message + "\r\n\r\n";
					viewText.append(messageStr);
					logWriter.write(messageStr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 向指定ip发送arr中的内容
	 * 
	 * @throws IOException
	 */
	private void send(byte[] arr, String ip) throws IOException {
		DatagramPacket packet = new DatagramPacket(arr, arr.length, InetAddress.getByName(ip), 9982);
		socket.send(packet);
	}

	/**
	 * 发送消息
	 * 
	 * @throws Exception
	 */
	private void send() throws Exception {
		// 通过UDP发送消息
		String message = sendText.getText();
		if (message.equals(""))
			return;
		String ip = ipTextField.getText();
		ip = ip.trim().length() == 0 ? "255.255.255.255" : ip;
		send(message.getBytes(), ip);

		// 显示消息
		String time = getCurrentTime();
		String receiver = ip.equals("255.255.255.255") ? "所有人" : ip;
		String messageStr = time + " 我对" + receiver + "说\r\n" + message + "\r\n\r\n";
		viewText.append(messageStr);
		logWriter.write(messageStr);
		sendText.setText("");
	}

	/**
	 * 获取当前时间字符串
	 */
	private String getCurrentTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		return sdf.format(d);
	}

	/**
	 * 初始化事件监听
	 */
	private void initEventListener() {
		// 窗口监听
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				socket.close();
				try {
					logWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});

		// 发送按钮监听
		send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					send();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// 记录按钮监听
		log.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					logFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// 清屏按钮监听
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewText.setText("");
			}
		});

		// 记录按钮监听
		shake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = ipTextField.getText();
				try {
					send(new byte[] { -1 }, ip);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// 发送按钮的快捷键
		sendText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {
					try {
						send();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * 初始化中间的面板，包含消息显示框和消息发送框
	 */
	private void initCenterPanel() {
		// centerPanel
		Panel centerPanel = new Panel();
		viewText = new TextArea();
		viewText.setEditable(false);
		viewText.setBackground(Color.LIGHT_GRAY);
		sendText = new TextArea(5, 1);
		sendText.setFont(new Font("", Font.PLAIN, 20));
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(sendText, BorderLayout.SOUTH);
		centerPanel.add(viewText, BorderLayout.CENTER);
		// 添加Panel
		this.add(centerPanel, BorderLayout.CENTER);
	}

	/**
	 * 初始化按钮面板
	 */
	private void initBtnPanel() {
		// btnPanel
		Panel btnPanel = new Panel();
		ipTextField = new TextField(15);
		ipTextField.setText("127.0.0.1");
		send = new Button("发送");
		log = new Button("记录");
		clear = new Button("清屏");
		shake = new Button("震动");
		btnPanel.add(ipTextField);
		btnPanel.add(send);
		btnPanel.add(log);
		btnPanel.add(clear);
		btnPanel.add(shake);
		// 添加Panel
		this.add(btnPanel, BorderLayout.SOUTH);
	}

	/**
	 * 初始化窗体
	 */
	public void initFrame() {
		// Frame
		this.setLocation(500, 50);
		this.setSize(400, 500);
		this.setTitle("沙雕聊天室");

		initBtnPanel();
		initCenterPanel();
		initEventListener();

		this.setVisible(true);
	}

	/**
	 * 窗体Frame构造函数
	 */
	public GUIChat() {
		initFrame();
		try {
			socket = new DatagramSocket();
			logWriter = new BufferedWriter(new FileWriter("data.db", true));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		new Receive().start();
	}

	public static void main(String[] args) {
		new GUIChat();
	}

}
