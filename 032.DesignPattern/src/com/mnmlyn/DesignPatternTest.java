/*
 * 几个设计模式
 * 
 * 1. 单例模式
 * 三种实现方法，均私有构造方法，获取实例方法和单例引用都应是static（因为外部无法创建实例）
 * 懒汉式，在第一次获取实例时，创建对象
 * 饿汉式，在类加载时，创建对象
 * 直接暴露内部对象，用final修饰防止被修改
 * 
 * 2. 简单工厂模式
 * 定义工厂类，定义static方法，用来创建所需要的对象
 * 可以每个需要创建的类对应一个静态方法，
 * 若这些类继承自同一个父类，可以仅通过一个静态方法创建，通过方法传参确定该创建哪个类的对象
 * 
 * 3. 工厂方法模式
 * 定义工厂接口
 * 对于每个类，都定义对应的工厂，实现工厂接口
 * 
 * 4. 适配器设计模式
 * 接口中有多个要实现的方法，但程序不一定全都用到，但必须要全部实现，哪怕只是定义空方法，这很繁琐。
 * 适配器简化这种操作，适配器是一个类，用空方法实现了接口的全部方法，但定义为抽象类，即不能实例化。
 * 适配器定义为抽象类的原因是，全部为空方法的接口实现是没有任何意义的。
 * 在需要使用接口，但只需要一部分方法时，只需要继承适配器，然后重写所需的少量方法即可，简化操作。
 * Ctrl+Shift+t，参见WindowAdapter
 */
package com.mnmlyn;

public class DesignPatternTest {

	public static void main(String[] args) {
		// 单例模式1
		Singleton1 s11 = Singleton1.getInstance();
		Singleton1 s12 = Singleton1.getInstance();
		System.out.println(s11 == s12);
		// 单例模式2
		Singleton2 s21 = Singleton2.getInstance();
		Singleton2 s22 = Singleton2.getInstance();
		System.out.println(s21 == s22);
		// 单例模式3
		Singleton3 s31 = Singleton3.instance;
		Singleton3 s32 = Singleton3.instance;
		System.out.println(s31 == s32);
		
		// 简单工厂模式
		// 通过动物工厂，创建不同的动物
		Dog d = (Dog) AnimalFactory.createAnimal("Dog");
		Cat c = (Cat) AnimalFactory.createAnimal("Cat");
		d.eat();
		c.eat();
		
		// 工厂方法模式
		DogFactory df = new DogFactory();
		Dog d1 = (Dog) df.createAnimal();
		CatFactory cf = new CatFactory();
		Cat c1 = (Cat) cf.createAnimal();
		d1.eat();
		c1.eat();
	}

}
