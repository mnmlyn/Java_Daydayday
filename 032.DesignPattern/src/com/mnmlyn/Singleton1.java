package com.mnmlyn;

// ����ģʽ1������ʽ
public class Singleton1 {
	private Singleton1() {
	}

	private static Singleton1 s;

	public static Singleton1 getInstance() {
		if (s == null) {
			s = new Singleton1();
		}
		return s;
	}
}
