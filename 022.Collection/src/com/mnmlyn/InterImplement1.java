package com.mnmlyn;

//ʵ�ֽӿڣ����Ҽ���ʹ�÷���
public class InterImplement1<T> implements Inter<T> {

	@Override
	public void show(T t) {
		System.out.println(t);
	}

}
