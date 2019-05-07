/*
 * �������ģʽ
 * 
 * 1. ����ģʽ
 * ����ʵ�ַ�������˽�й��췽������ȡʵ�������͵������ö�Ӧ��static����Ϊ�ⲿ�޷�����ʵ����
 * ����ʽ���ڵ�һ�λ�ȡʵ��ʱ����������
 * ����ʽ���������ʱ����������
 * ֱ�ӱ�¶�ڲ�������final���η�ֹ���޸�
 * 
 * 2. �򵥹���ģʽ
 * ���幤���࣬����static������������������Ҫ�Ķ���
 * ����ÿ����Ҫ���������Ӧһ����̬������
 * ����Щ��̳���ͬһ�����࣬���Խ�ͨ��һ����̬����������ͨ����������ȷ���ô����ĸ���Ķ���
 * 
 * 3. ��������ģʽ
 * ���幤���ӿ�
 * ����ÿ���࣬�������Ӧ�Ĺ�����ʵ�ֹ����ӿ�
 * 
 * 4. ���������ģʽ
 * �ӿ����ж��Ҫʵ�ֵķ�����������һ��ȫ���õ���������Ҫȫ��ʵ�֣�����ֻ�Ƕ���շ�������ܷ�����
 * �����������ֲ�������������һ���࣬�ÿշ���ʵ���˽ӿڵ�ȫ��������������Ϊ�����࣬������ʵ������
 * ����������Ϊ�������ԭ���ǣ�ȫ��Ϊ�շ����Ľӿ�ʵ����û���κ�����ġ�
 * ����Ҫʹ�ýӿڣ���ֻ��Ҫһ���ַ���ʱ��ֻ��Ҫ�̳���������Ȼ����д����������������ɣ��򻯲�����
 * Ctrl+Shift+t���μ�WindowAdapter
 */
package com.mnmlyn;

public class DesignPatternTest {

	public static void main(String[] args) {
		// ����ģʽ1
		Singleton1 s11 = Singleton1.getInstance();
		Singleton1 s12 = Singleton1.getInstance();
		System.out.println(s11 == s12);
		// ����ģʽ2
		Singleton2 s21 = Singleton2.getInstance();
		Singleton2 s22 = Singleton2.getInstance();
		System.out.println(s21 == s22);
		// ����ģʽ3
		Singleton3 s31 = Singleton3.instance;
		Singleton3 s32 = Singleton3.instance;
		System.out.println(s31 == s32);
		
		// �򵥹���ģʽ
		// ͨ�����﹤����������ͬ�Ķ���
		Dog d = (Dog) AnimalFactory.createAnimal("Dog");
		Cat c = (Cat) AnimalFactory.createAnimal("Cat");
		d.eat();
		c.eat();
		
		// ��������ģʽ
		DogFactory df = new DogFactory();
		Dog d1 = (Dog) df.createAnimal();
		CatFactory cf = new CatFactory();
		Cat c1 = (Cat) cf.createAnimal();
		d1.eat();
		c1.eat();
	}

}
