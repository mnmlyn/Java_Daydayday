package com.mnmlyn;

//实现接口，并且继续使用泛型
public class InterImplement1<T> implements Inter<T> {

	@Override
	public void show(T t) {
		System.out.println(t);
	}

}
