/*
 * ��������ʾ
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

	// ��Ա���������������µķ���Q������ʹ����ķ���T
	public <Q> void print(Q q, T t) {
		System.out.println(q + " " + t);
	}

	// ��̬�����У�����ʹ�÷Ǿ�̬������T
	public static <W> void print1(W w) {
		System.out.println(w);
	}
}
