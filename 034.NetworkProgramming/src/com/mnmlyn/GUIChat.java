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
	 * �����𶯣���ʵ���ǲ��ϸı䴰��λ��
	 */
	private void shake() {
		int x = this.getLocation().x;
		int y = this.getLocation().y;
		String title = this.getTitle();
		this.setTitle("����~");
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
	 * ��ʾ��Ϣ��¼
	 * 
	 * @throws IOException
	 */
	private void logFile() throws IOException {
		logWriter.flush();
		FileInputStream fis = new FileInputStream("data.db");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();// �ڴ滺����

		int len;
		byte[] arr = new byte[8192];
		while ((len = fis.read(arr)) != -1) {
			baos.write(arr, 0, len);
		}

		String str = baos.toString();
		viewText.setText(str);
	}

	/**
	 * ���գ����䵥�����߳�
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
						// ��ָ��
						shake();
						continue;
					}
					String ip = packet.getAddress().getHostAddress();// ��ȡIP��ַ
					String message = new String(rcvBuffer, 0, len);
					String time = getCurrentTime();
					String messageStr = time + " " + ip + "����˵\r\n" + message + "\r\n\r\n";
					viewText.append(messageStr);
					logWriter.write(messageStr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��ָ��ip����arr�е�����
	 * 
	 * @throws IOException
	 */
	private void send(byte[] arr, String ip) throws IOException {
		DatagramPacket packet = new DatagramPacket(arr, arr.length, InetAddress.getByName(ip), 9982);
		socket.send(packet);
	}

	/**
	 * ������Ϣ
	 * 
	 * @throws Exception
	 */
	private void send() throws Exception {
		// ͨ��UDP������Ϣ
		String message = sendText.getText();
		if (message.equals(""))
			return;
		String ip = ipTextField.getText();
		ip = ip.trim().length() == 0 ? "255.255.255.255" : ip;
		send(message.getBytes(), ip);

		// ��ʾ��Ϣ
		String time = getCurrentTime();
		String receiver = ip.equals("255.255.255.255") ? "������" : ip;
		String messageStr = time + " �Ҷ�" + receiver + "˵\r\n" + message + "\r\n\r\n";
		viewText.append(messageStr);
		logWriter.write(messageStr);
		sendText.setText("");
	}

	/**
	 * ��ȡ��ǰʱ���ַ���
	 */
	private String getCurrentTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		return sdf.format(d);
	}

	/**
	 * ��ʼ���¼�����
	 */
	private void initEventListener() {
		// ���ڼ���
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

		// ���Ͱ�ť����
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

		// ��¼��ť����
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

		// ������ť����
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewText.setText("");
			}
		});

		// ��¼��ť����
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

		// ���Ͱ�ť�Ŀ�ݼ�
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
	 * ��ʼ���м����壬������Ϣ��ʾ�����Ϣ���Ϳ�
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
		// ���Panel
		this.add(centerPanel, BorderLayout.CENTER);
	}

	/**
	 * ��ʼ����ť���
	 */
	private void initBtnPanel() {
		// btnPanel
		Panel btnPanel = new Panel();
		ipTextField = new TextField(15);
		ipTextField.setText("127.0.0.1");
		send = new Button("����");
		log = new Button("��¼");
		clear = new Button("����");
		shake = new Button("��");
		btnPanel.add(ipTextField);
		btnPanel.add(send);
		btnPanel.add(log);
		btnPanel.add(clear);
		btnPanel.add(shake);
		// ���Panel
		this.add(btnPanel, BorderLayout.SOUTH);
	}

	/**
	 * ��ʼ������
	 */
	public void initFrame() {
		// Frame
		this.setLocation(500, 50);
		this.setSize(400, 500);
		this.setTitle("ɳ��������");

		initBtnPanel();
		initCenterPanel();
		initEventListener();

		this.setVisible(true);
	}

	/**
	 * ����Frame���캯��
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
