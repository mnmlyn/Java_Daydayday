/*
 * 泛型类演示
 */
package com.mnmlyn;

public class Tool<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	// 成员方法可以再声明新的泛型Q，可以使用类的泛型T
	public <Q> void print(Q q, T t) {
		System.out.println(q + " " + t);
	}

	// 静态方法中，不能使用非静态的类型T
	public static <W> void print1(W w) {
		System.out.println(w);
	}
}
