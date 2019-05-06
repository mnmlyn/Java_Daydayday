package com.mnmlyn;

//单例模式2，饿汉式
public class Singleton2 {
	private Singleton2() {
	}

	private static Singleton2 s = new Singleton2();

	public static Singleton2 getInstance() {
		return s;
	}
}
