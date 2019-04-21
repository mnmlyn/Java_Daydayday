/*
 * ��̬����������ָ���������
 * 
 * 1. Father f = new Son();
 * ��Ա�����������б�������Ӧ������������뱨��
 * ��Ա���������������������������������ͷ�����Ӧ��
 * ��̬��Ա�����������������ͷ�����Ӧ��
 *
 * 2. �ڷ��������У����ݸ������á�
 *
 * 3. �ؼ���instanceof���жϸ��������Ƿ����������
*/
public class Polymorphic {
	public static void main(String[] args) {
		Animal animal1 = new Dog();
		//Animal�������eat������ֻ�ǿ��ܱ�������д
		animal1.eat();
		//���ڸ��������������ĳ�Ա������
		//�����������Ͷ�Ӧ��ı�����
		//���Լ򵥼�Ϊ��Ա���������̬
		System.out.println(animal1.age);
		//���þ�̬�������൱������.��������
		//�����������Ͷ�Ӧ��ľ�̬����
		animal1.method();
		Animal.method();
		feedAnimal(animal1);
	}
	
	public static void feedAnimal(Animal animal) {
		if(animal instanceof Dog) {
			animal.eat();
		}
	}
}

class Animal {
	public int age = 5;
	
	public void eat() {
		System.out.println("�����ڳ�");
	}
	
	public static void method() {
		System.out.println("����method");
	}
}

class Dog extends Animal {
	public int age = 10;
	
	public void eat() {
		System.out.println("���Թ�ͷ");
	}
	
	public void catMouse() {
		System.out.println("���ú���");
	}
	
	public static void method() {
		System.out.println("��method");
	}
}