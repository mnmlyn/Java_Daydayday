package com.mnmlyn;

public class Printer2 {
	private int flag = 1;

	public void print1() throws InterruptedException {
		synchronized (this) {
			if (flag != 1)
				this.wait();
			System.out.print("Óû");
			System.out.print("¶É");
			System.out.print("»Æ");
			System.out.print("ºÓ");
			System.out.print("±ù");
			System.out.print("Èû");
			System.out.print("´¨");
			System.out.print(",");
			flag = 2;
			this.notify();
		}
	}

	public void print2() throws InterruptedException {
		synchronized (this) {
			if (flag != 2)
				this.wait();
			System.out.print("½«");
			System.out.print("µÇ");
			System.out.print("Ì«");
			System.out.print("ÐÐ");
			System.out.print("Ñ©");
			System.out.print("Âú");
			System.out.print("É½");
			System.out.println();
			flag = 1;
			this.notify();
		}
	}
}
