package com.mnmlyn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Printer3 {
	private ReentrantLock rl = new ReentrantLock();// 可重入锁
	private Condition c1 = rl.newCondition();
	private Condition c2 = rl.newCondition();
	private Condition c3 = rl.newCondition();
	private int flag = 1;

	public void print1() throws InterruptedException {
		rl.lock();
		if (flag != 1)
			c1.await();
		System.out.print("欲");
		System.out.print("渡");
		System.out.print("黄");
		System.out.print("河");
		System.out.print("冰");
		System.out.print("塞");
		System.out.print("川");
		System.out.print(",");
		flag = 2;
		c2.signal();
		rl.unlock();
	}

	public void print2() throws InterruptedException {
		rl.lock();
		if (flag != 2)
			c2.await();
		System.out.print("将");
		System.out.print("登");
		System.out.print("太");
		System.out.print("行");
		System.out.print("雪");
		System.out.print("满");
		System.out.print("山");
		System.out.print("。");
		flag = 3;
		c3.signal();
		rl.unlock();
	}

	public void print3() throws InterruptedException {
		rl.lock();
		if (flag != 3)
			c3.await();
		System.out.print("难！");
		System.out.print("难！");
		System.out.print("难！");
		System.out.println();
		flag = 1;
		c1.signal();
		rl.unlock();
	}
}
