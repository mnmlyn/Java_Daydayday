/*
 * 将在另一个包中访问这个类
*/
package com.google;

//class必须用public修饰，才被从其他包中访问
public class Person {
	private String name;
	private int age;
	public Person() {
		this.name = "未知";
		this.age = 0;
	}
	
	//构造函数必须是public修饰的，才能被从其他包中访问
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public static void print() {
		System.out.println("print");
	}
}