package com.mnmlyn;

public class Printer {
	// δʹ��ͬ������ʾ����
	public void print1() {
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.println();
	}

	public void print2() {
		System.out.print("��");
		System.out.print("��");
		System.out.print("̫");
		System.out.print("��");
		System.out.print("ѩ");
		System.out.print("��");
		System.out.print("ɽ");
		System.out.println();
	}

	// ʹ������������ͬ������ͬһ����obj���������ٽ���Դ��׼���
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

	// �Ǿ�̬ͬ��������ʹ�ö����thisָ����Ϊͬ��������
	public synchronized void print5() {
		this.print1();
	}

	public void print6() {
		synchronized (this) {
			this.print2();
		}
	}

	// ��̬������ʹ������ֽ��������Ϊͬ��������
	public synchronized static void print7() {
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.println();
	}

	public static void print8() {
		synchronized (Printer.class) {
			System.out.print("��");
			System.out.print("��");
			System.out.print("̫");
			System.out.print("��");
			System.out.print("ѩ");
			System.out.print("��");
			System.out.print("ɽ");
			System.out.println();
		}
	}
}
