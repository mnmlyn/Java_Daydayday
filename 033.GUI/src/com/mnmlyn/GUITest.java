/*
 * GUI
 * ��Ȼjava���и���˵GUIû�ã�����ѧ�����ǻ����˽�һ�¡�
 * Just for fun!
 * 
 * 
 */
package com.mnmlyn;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUITest {

	public static void main(String[] args) {
		Frame f = new Frame("gy����");
		f.setSize(400, 200);
		f.setLocation(200, 200);

		Button btn1 = new Button("�˳���ť");
		Button btn2 = new Button("����������ť");
		f.add(btn1);
		f.add(btn2);

		// Layout���ã��Ͳ���ϸ���ˣ�������ѧ��׿����CSS��
		f.setLayout(new FlowLayout());

		// ��Ӵ��ڹرհ�ť�ļ���
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// ���������
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		// ��Ӽ��̼�����Ϊɶ��ӵ����岻�У�
		btn1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_Q)
					System.exit(0);
			}
		});

		// ��Ӷ�������
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		f.setVisible(true);
	}

}
