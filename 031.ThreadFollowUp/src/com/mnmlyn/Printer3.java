package com.mnmlyn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Printer3 {
	private ReentrantLock rl = new ReentrantLock();// ��������
	private Condition c1 = rl.newCondition();
	private Condition c2 = rl.newCondition();
	private Condition c3 = rl.newCondition();
	private int flag = 1;

	public void print1() throws InterruptedException {
		rl.lock();
		if (flag != 1)
			c1.await();
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print(",");
		flag = 2;
		c2.signal();
		rl.unlock();
	}

	public void print2() throws InterruptedException {
		rl.lock();
		if (flag != 2)
			c2.await();
		System.out.print("��");
		System.out.print("��");
		System.out.print("̫");
		System.out.print("��");
		System.out.print("ѩ");
		System.out.print("��");
		System.out.print("ɽ");
		System.out.print("��");
		flag = 3;
		c3.signal();
		rl.unlock();
	}

	public void print3() throws InterruptedException {
		rl.lock();
		if (flag != 3)
			c3.await();
		System.out.print("�ѣ�");
		System.out.print("�ѣ�");
		System.out.print("�ѣ�");
		System.out.println();
		flag = 1;
		c1.signal();
		rl.unlock();
	}
}
