package com.mnmlyn;

//����ģʽ2������ʽ
public class Singleton2 {
	private Singleton2() {
	}

	private static Singleton2 s = new Singleton2();

	public static Singleton2 getInstance() {
		return s;
	}
}
