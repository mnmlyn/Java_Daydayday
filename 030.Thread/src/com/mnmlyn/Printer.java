package com.mnmlyn;

public class Printer {
	// 未使用同步，演示乱序
	public void print1() {
		System.out.print("欲");
		System.out.print("渡");
		System.out.print("黄");
		System.out.print("河");
		System.out.print("冰");
		System.out.print("塞");
		System.out.print("川");
		System.out.println();
	}

	public void print2() {
		System.out.print("将");
		System.out.print("登");
		System.out.print("太");
		System.out.print("行");
		System.out.print("雪");
		System.out.print("满");
		System.out.print("山");
		System.out.println();
	}

	// 使用任意对象进行同步，用同一个锁obj，来保护临界资源标准输出
	Object obj = new Object();

	public void print3() {
		synchronized (obj) {
			this.print1();
		}
	}

	public void print4() {
		synchronized (obj) {
			this.print2();
		}
	}

	// 非静态同步方法，使用对象的this指针作为同步锁对象
	public synchronized void print5() {
		this.print1();
	}

	public void print6() {
		synchronized (this) {
			this.print2();
		}
	}

	// 静态方法，使用类的字节码对象，作为同步锁对象
	public synchronized static void print7() {
		System.out.print("欲");
		System.out.print("渡");
		System.out.print("黄");
		System.out.print("河");
		System.out.print("冰");
		System.out.print("塞");
		System.out.print("川");
		System.out.println();
	}

	public static void print8() {
		synchronized (Printer.class) {
			System.out.print("将");
			System.out.print("登");
			System.out.print("太");
			System.out.print("行");
			System.out.print("雪");
			System.out.print("满");
			System.out.print("山");
			System.out.println();
		}
	}
}
