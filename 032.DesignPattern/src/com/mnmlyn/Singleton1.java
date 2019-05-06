package com.mnmlyn;

// 单例模式1，懒汉式
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
