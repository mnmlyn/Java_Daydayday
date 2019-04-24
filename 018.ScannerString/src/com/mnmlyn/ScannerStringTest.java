/*
 * Scanner�࣬��������
 * String�࣬�ַ���
 * 
 * 1. �ж������Ƿ���ȷ�����ͣ�����������
 * hasNextInt()
 * 
 * 2. ����int��������������String��������������ŵ�String
 * ��Ϊ���з�û�ж���
 * 
 * 3. String��
 * String������ַ��������޸ģ�������������һ���ַ���
 * String str = "abc";
 * str[0] = '1';//���Ǵ��
 * str = "123";
 * 
 * 4. String�Ĺ��캯��
 * + �ֽ�����byte[]����ָ����ʼλ�úͳ���
 * + �ַ�����char[]����ָ����ʼλ�úͳ���
 * + �ַ�������
 * 
 * 5. ����String����ȽϵĿ�
 * ==��equals��ע��Ҫ��equals����Ϊ==�����������͵�ʱ���жϵ��ǵ�ֵַ�Ƿ���ȡ�
 * �������ַ���ָ��ͬһ��������ʱ��==�ķ��ؽ����true�������Ⲣ������Ϊ�ж��ַ�����ȵ�ͨ�ñ�׼��
 * 
 * 6. ����String���캯������String����ʱ���Ḵ�Ʋ����ĸ���,
 * ���ַ�����=��ֵʱ��ֻ��ָ�����ַ��������忴����ע�ͣ�����ܹؼ�
 * 
 * 7. String���ó�Ա����
 * ���ĵ�û���κ����壬ֱ�ӿ�������ϰʹ��
 */
package com.mnmlyn;

import java.util.Scanner;

public class ScannerStringTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ������");
		int a;
		if (sc.hasNextInt()) {
			a = sc.nextInt();
			System.out.println(a);
		} else {
			System.out.println("�������");
		}

		// nextInt()��û�аѻ��з����ߣ���nextLine()�����з������������
		// ��ô����������nextLine()��ok�ˡ���һ�ζ��������Ļ��У��ڶ��������ַ���
		System.out.println("������һ���ַ���");
		sc.nextLine();// ���������nextInt()֮�����
		String str = sc.nextLine();
		System.out.println(str);
		System.out.println("End");
		sc.close();

		// String�����޸�
		String name = "abc";
		// �±���仰�ǲ��Եġ�
		// name[0] = '1';
		name = "123";

		// String���캯��
		byte[] arr1 = { 'a', 98, 99 };// �ֽ����飬ÿ��Ԫ��һ���ֽ�
		char[] arr2 = { 97, '��', 99 };// �ַ����飬�䳤����
		String s1 = new String(arr1);
		String s2 = new String(arr1, 1, 2);
		String s3 = new String(arr2);
		String s4 = new String(arr2, 1, 2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);

		// String�����ж����
		String str1 = "456";
		String str2 = "456";
		System.out.println(str1 == str2);// ����true����Ϊ�����ַ���"456"�ڳ�����ֻ�洢һ��
		System.out.println(str1.equals(str2));

		byte[] arr3 = { '4', '5', '6' };
		String str3 = new String(arr3);
		System.out.println("str3=" + str3 + ",str2=" + str2 + ",==?");
		System.out.println(str3 == str2);// ����false�����������ַ���ʵ�����

		System.out.println("Java���ж��ַ�����ȣ���ʹ��equals()������Ҫʹ��==");
		System.out.println(str3.equals(str2));

		// 1. String�Ĺ��캯���������˼�������?����
		// ����������û��"4321"���������лᴴ��һ�����󡣵��ù��캯�����ᴴ��һ���������ѡ�
		String str4 = new String("4321");
		String str5 = "4321";
		String str6 = "4321";
		// 2. str4 == str5�Ľ����ʲô��str5 == str6�Ľ����ʲô��Ϊʲô��
		// false��true����Ϊ���캯���Ḵ�Ƴ������ĸ�����������ָ�������ַ�����ַ��ȡ�
		System.out.println(str4 == str5);// false
		System.out.println(str5 == str6);// true
		String str7 = "4" + "3" + "2" + "1";
		// 3. str6==str7�Ľ����ʲô��Ϊʲô��
		// true����Ϊ����ʱ��ֱ�ӽ���������õ��˽��"4321"
		System.out.println(str6 == str7);// true
		String str8 = "432";
		String str9 = str8 + "1";
		// 4. str9==str6�Ľ����ʲô��Ϊʲô��
		// false����Ϊstr8�Ǳ�����String��+�����������ײ����StringBuffer�����ַ���ƴ��
		System.out.println(str9 == str6);// false
		System.out.println(str9.equals(str6));// true

		// String���ó�Ա����
		String mystr1 = "abc123456";
		String mystr2 = "abc";
		String mystr3 = "123456";
		String mystr4 = "abc";
		String mystr5 = "Abc";
		String mystr6 = "";
		String mystr7 = null;
		System.out.println("--------------------------------");
		System.out.println(mystr2.equals(mystr4));// �ж��ַ����Ƿ����
		System.out.println(mystr5.equalsIgnoreCase(mystr4));// ���Դ�Сд�ж����
		System.out.println(mystr1.contains(mystr2));// �Ƿ����Ӵ�
		System.out.println(mystr1.startsWith(mystr2));// �ж�ǰ׺
		System.out.println(mystr1.startsWith(mystr3, 3));// �ж�ǰ׺��ָ��ƫ��
		System.out.println(mystr1.endsWith(mystr3));// �жϺ�׺
		System.out.println(mystr6.isEmpty());// �ж��ַ����Ƿ�Ϊ��
		// System.out.println(mystr7.isEmpty());//��������isEmpty()�ǳ�Ա�������ж�����ܵ���

		// ���ȣ���ȡ�������ַ��������ַ�����������ȡ�Ӵ�
		// length(),charAt(),IndexOf(),lastIndexOf(),substring()
		System.out.println("--------------------------------");
		System.out.println(mystr1.length());
		System.out.println(mystr1.charAt(2));
		System.out.println(mystr1.indexOf('1'));
		System.out.println(mystr1.substring(3));

		// �ַ���תΪ�ֽ�����
		System.out.println("--------getBytes()--------");
		String istr1 = "abc������";
		byte[] arr4 = istr1.getBytes();// ����ΪϵͳĬ�ϱ���
		for (int i = 0; i < arr4.length; i++) {
			System.out.print(arr4[i] + " ");// 97 98 99 -64 -78 -64 -78 -64 -78
		}
		System.out.println();

		// �ַ���ת��Ϊ�ַ�����
		System.out.println("--------toCharArray()--------");
		char[] arr5 = istr1.toCharArray();
		for (int i = 0; i < arr5.length; i++) {
			System.out.print(arr5[i] + " ");
		}
		System.out.println();

		// valueOf()��̬����������������ת��ΪString��ʵ���ǵ���String�Ĺ��췽��
		System.out.println("--------valueOf()--------");
		int b = 123456;
		String istr2 = String.valueOf(b);
		System.out.println(istr2);
		String istr3 = String.valueOf(arr5);
		System.out.println(istr3);

		// �ַ�����Ϊȫ����д����Ϊȫ��Сд
		System.out.println("--------toLower-Upper-Case()--------");
		String istr4 = "asdfSHDISHDI������";
		System.out.println(istr4.toLowerCase());
		System.out.println(istr4.toUpperCase());

		// �ַ���ƴ��
		System.out.println("--------concat()--------");
		String istr5 = "abc";
		String istr6 = "defg";
		System.out.println(istr5.concat(istr6));

		// �ַ����滻
		System.out.println("--------replace()--------");
		String istr7 = "   hello   world!    ";
		System.out.println(istr7.replace('l', 'g'));// �����ַ��滻
		System.out.println(istr7.replace("world", "java"));// �������ַ����滻

		// �ַ������˿ո��ȥ��
		System.out.println("--------trim()--------");
		System.out.println(istr7.trim());

		// �ַ����ֵ���Ƚ�
		System.out.println("--------compareTo()--------");
		String istr8 = "hello";
		String istr9 = "head";
		String istr10 = "Hello";
		String istr11 = "hellohhhh";
		System.out.println(istr8.compareTo(istr9));// �����ȣ����ص�һ�����ȵ�Ԫ�صı���ֵ�ĲUnicode
		System.out.println(istr8.compareTo(istr11));// ��һ��������һ����ǰ׺������ֵ��length�Ĳ�
		System.out.println(istr8.compareToIgnoreCase(istr10));// ���Դ�Сд
	}

}
