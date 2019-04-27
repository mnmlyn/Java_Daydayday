package com.mnmlyn;

//实现接口，并且将接口的泛型具体化
public class InterImplement2 implements Inter<String> {

	@Override
	public void show(String t) {
		System.out.println(t);
	}

}
