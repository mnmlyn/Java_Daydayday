package com.mnmlyn;

public class AnimalFactory {
	public static Animal createAnimal(String type) {
		if (type.equals("Cat")) {
			return new Cat();
		} else if (type.equals("Dog")) {
			return new Dog();
		} else {
			return null;
		}
	}
}
