package com.mnmlyn;

//单例模式3，直接暴露对象引用，用final修饰防止被修改
public class Singleton3 {
	private Singleton3() {
	}

	public static final Singleton3 instance = new Singleton3();
}
