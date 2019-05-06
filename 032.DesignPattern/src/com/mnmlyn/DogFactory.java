package com.mnmlyn;

// 工厂方法模式
public class DogFactory implements Factory {

	@Override
	public Animal createAnimal() {
		return new Dog();
	}

}
