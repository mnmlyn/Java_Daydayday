/*
 * ������һ�����з��������
*/
package com.google;

//class������public���Σ��ű����������з���
public class Person {
	private String name;
	private int age;
	public Person() {
		this.name = "δ֪";
		this.age = 0;
	}
	
	//���캯��������public���εģ����ܱ����������з���
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