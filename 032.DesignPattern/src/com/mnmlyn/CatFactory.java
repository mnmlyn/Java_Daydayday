package com.mnmlyn;

// ��������ģʽ
public class CatFactory implements Factory {

	@Override
	public Animal createAnimal() {
		return new Cat();
	}

}
