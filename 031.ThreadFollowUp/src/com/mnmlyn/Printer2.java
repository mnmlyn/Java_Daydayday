package com.mnmlyn;

public class Printer2 {
	private int flag = 1;

	public void print1() throws InterruptedException {
		synchronized (this) {
			if (flag != 1)
				this.wait();
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print(",");
			flag = 2;
			this.notify();
		}
	}

	public void print2() throws InterruptedException {
		synchronized (this) {
			if (flag != 2)
				this.wait();
			System.out.print("��");
			System.out.print("��");
			System.out.print("̫");
			System.out.print("��");
			System.out.print("ѩ");
			System.out.print("��");
			System.out.print("ɽ");
			System.out.println();
			flag = 1;
			this.notify();
		}
	}
}
