/*
 * packageָ����ǰԴ�ļ��İ��������ֻ���ڵ�һ�г���һ��
 *
 * ���뷽����javac -d . PackageTest.java
 * ���з�����java com.mnmlyn.PackageTest
 *
 * 1. û��package��䣬�����ް���
 *
 * 2. ������һ�����е���
 * ����ʱ���ȱ��뱻ʹ�õ���javac -d . Person.java
 * �ٱ��뵱ǰ��javac -d . PackageTest.java
 *
 * 3. ��ʹ�õ���һ�����е�class��������public���Σ����ܱ�����
 * ��ʹ����Ĺ��캯��������public���εģ����ܱ�����
 *
 * 4. ʹ��import��ȫ���������Ե����ࡣ����ʹ��ͨ�����
 *
 * 5. ��̬���룬�������еľ�̬���������Բ���ǰ׺ʹ�þ�̬����
 * һ�����������ô������ԣ�ֻ��Ҫ֪������
*/
package com.mnmlyn;
import com.google.Person;
//��̬���룬�������еľ�̬��������ñ�������
import static com.google.Person.print;

//import java.util.*;  //����java.util������£���*ƥ���������
public class PackageTest {
	public static void main(String[] args) {
		System.out.println("Hello World");
		com.google.Person p = new com.google.Person();
		String name = p.getName();
		System.out.println(name);
		
		//ʹ��import�󣬿��Բ�д������ֱ��ʹ����
		Person p1 = new Person();
		System.out.println(p1.getName());
		
		//δ��̬���뷽��ʱ��ʹ�þ�̬����
		Person.print();
		//��̬�������еľ�̬�����󣬿��Բ���ǰ׺ʹ��
		//���ǣ�������������ͻʱ�����鷳����ñ�������
		print();
	}
}