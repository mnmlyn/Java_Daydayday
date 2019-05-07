/*
 * GUI
 * 虽然java大佬给我说GUI没用，不用学，但是还是了解一下。
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
		Frame f = new Frame("gy窗体");
		f.setSize(400, 200);
		f.setLocation(200, 200);

		Button btn1 = new Button("退出按钮");
		Button btn2 = new Button("动作监听按钮");
		f.add(btn1);
		f.add(btn2);

		// Layout设置，就不仔细搞了，还不如学安卓或者CSS。
		f.setLayout(new FlowLayout());

		// 添加窗口关闭按钮的监听
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// 添加鼠标监听
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		// 添加键盘监听，为啥添加到窗体不行？
		btn1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_Q)
					System.exit(0);
			}
		});

		// 添加动作监听
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		f.setVisible(true);
	}

}
