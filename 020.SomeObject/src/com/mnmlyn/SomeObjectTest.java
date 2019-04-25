/*
 * һЩ�����࣬����Ԥ����һƪ��ˮ�����Ƕ��ǳ�������������
 * 
 * 1. Arrays������
 * ��������г��ò��������򣬶��ֲ��ң�ת�ַ���
 * 
 * 2. Integer�Ȱ�װ��
 * �о�̬��������������������ת�ַ���
 * 
 * 3. String��int��ת��
 * + intתString��
 *   ֱ����+�ţ�""+10
 *   ��String�ľ�̬����valueOf()
 * + Stringתint
 *   ��Integer.parseInt()
 * 
 * 4. �Զ�װ����Զ�����
 * �Զ�װ���ǰѻ�����������ת��Ϊ���󣬱���int��Integer
 * Integer int1 = 110;
 * �Զ������ǰѶ���ת��Ϊ�����������ͣ�����Integer��int
 * int a = int1;
 * 
 * 5. �Զ�װ�䣬��������������int����ΪIntegerʱ��
 * ��ֵ��byte��Χ��-128~127������ָ�����ء��������¹������
 * �Լ��ֶ�������󣬶��ǻṹ�����ģ������ڴ����⡣
 * 
 * ----------------------------------------------
 * 6. ������ʽ
 * String����ķ�����str.matches()���ж��Ƿ�����ƥ��
 * str.split()������ƥ�䣬ƥ�䵽����Ϊ�з��ַ�����str�����з�
 * str.replaceAll()������ƥ�䣬ȫ���滻
 * ����ƥ��ķ������⣬(a)(b(c))��\\1 \\2 ...��$1 $2 ...
 * ����������ȷ������˳��
 * 
 * 7. Pattern���Matcher����������ƥ��
 * ����ʹ�÷�ʽ��
 * Pattern p = Pattern.compile("a*b+");//����õ�����ģʽp
 * Matcher m = p.matcher("aaaaab");//����p��matcher������ƥ���ַ������õ�ƥ�����m
 * boolean b = m.matches();//��ƥ������ж��Ƿ�ƥ��
 * m.find()�ж��Ƿ���ƥ����
 * m.group()�õ�find()����ƥ����
 */
package com.mnmlyn;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SomeObjectTest {

	public static void main(String[] args) {
		Test1();//����Ctrl+1��������ʾ����ȡ����
		Test2();
	}

	private static void Test2() {
		//������ʽ���ж�ƥ��matches()
		String regex = "[1-9]+";
		System.out.println("12312412".matches(regex));//true
		System.out.println("1231241sdf2".matches(regex));//false
		
		//������ʽ���з�split()
		String str1 = "hello hallo haha";
		String[] arr1 = str1.split(" ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		String str2="hello?hallo?haha";
		String[] arr2 = str2.split("\\?");//����������ַ���Ҫ��������б��ת��
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		//��ϰ������һ���ո�ָ����������ɵ��ַ����������ǽ�������
		String str3 = "45 63 12 87 1223";
		String[] arr3 = str3.split(" ");
		int[] intarr3 = new int[arr3.length];
		for (int i = 0; i < intarr3.length; i++) {
			intarr3[i] = Integer.parseInt(arr3[i]);
		}
		Arrays.sort(intarr3);
		StringBuilder sb = new StringBuilder(str3.length());//ֱ��ʹ��String����ƴ�ӣ�Ч�ʺܵ�
		for (int i = 0; i < intarr3.length; i++) {
			sb.append(intarr3[i]);
			if(i != intarr3.length-1)
				sb.append(" ");
		}
		String str3_ret = sb.toString();
		System.out.println(str3_ret);
		
		//����ƥ�䣬�����滻
		String str4 = "abc2de3fgh5444433ijk34lmn";
		String str4_ret = str4.replaceAll("\\d", "");
		System.out.println(str4);
		System.out.println(str4_ret);
		
		//����ƥ��ķ���
		//ȥ���ַ����еķָ��ַ���.�����������ظ��ַ���Ϊֻ��һ��
		String str5 = "��.....����...����..��.��������.....������....��...����...������..";
		System.out.println(str5.replaceAll("\\.",""));
		//�����ַ�����\\1��ƥ���һ�����ţ�Ҳ���Ƿ����ƥ�����ݡ����滻�ַ����$1�����һ�����������
		System.out.println(str5.replaceAll("\\.","").replaceAll("(.)\\1+", "$1"));
		
		//��Pattern��Matcher��������ƥ��
		String str6 = "IP1:192.168.1.120, IP2:10.123.2.3, tag:12313.13.12313.12312, IP3:125.18.246.200.";
		Pattern p = Pattern.compile("((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(1\\d\\d|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)");
		//ע���±���ôд��Ȼ���ԣ�IP��ַ���һ�����֣�ֻƥ��һλ�ͽ�����
		//������Ϊ��С����()��������|�ָ��Ĳ�ͬ�飬�ǰ�����д˳��������ƥ��ģ�ƥ�䵽�ͽ���
		//Pattern p = Pattern.compile("((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])");
		Matcher m = p.matcher(str6);
		while(m.find()) {
			System.out.println(m.group());
		}
	}

	private static void Test1() {
		// ����ĳ��ò�����ʹ��Arrays������
		int[] arr1 = { 1, 7, 3, 9, 2, 4 };
		Arrays.sort(arr1);// ����
		String str1 = Arrays.toString(arr1);// תΪ�ַ���
		System.out.println(str1);
		System.out.println(Arrays.binarySearch(arr1, 3));// �����±�
		System.out.println(Arrays.binarySearch(arr1, 5));// ���ز���λ��+1���Ӹ���

		// Integer��װ��
		System.out.println(Integer.toBinaryString(255));
		System.out.println(Integer.toHexString(255));
		System.out.println(Integer.toOctalString(255));
		System.out.println(Integer.toString(255));
		System.out.println(Integer.toString(255, 16));// ����ֱ��������toString()������
		System.out.println(Integer.toString(255, 2));

		// Integer���캯��
		Integer int1 = new Integer(10);
		Integer int2 = new Integer("10");
		System.out.println(int1);
		System.out.println(int2);
		System.out.println(Integer.MIN_VALUE);// Integer�����Сֵ
		System.out.println(Integer.MAX_VALUE);

		// intתString
		int a = 10;
		String str2 = "" + a;
		String str3 = String.valueOf(a);
		System.out.println(str2);
		System.out.println(str3);

		// Stringתint
		int b = Integer.parseInt(str2);
		System.out.println(b);

		// װ��
		Integer int3 = new Integer(100);
		// ����
		int c = int3.intValue();
		// �Զ�װ��
		Integer int4 = 100;
		// �Զ�����
		int d = int4;
		// ע�⣬�Զ�����ʱ������Ϊnull�ᱨ������������ж϶����Ƿ�Ϊnull
		System.out.println(int3);
		System.out.println(c);
		System.out.println(int4);
		System.out.println(d);

		// �ֶ�װ��
		Integer int5 = new Integer(50);
		Integer int6 = new Integer(50);
		System.out.println(int5 == int6);// false�����߲���һ������
		Integer int7 = new Integer(550);
		Integer int8 = new Integer(550);
		System.out.println(int7 == int8);// false�����߲���һ������

		// �Զ�װ��
		Integer int9 = 50;
		Integer int10 = 50;
		System.out.println(int9 == int10);// true�����߾�Ȼ��һ������
		// ������Ϊ����byte��Χ�ڵ������Զ�װ���ָ�������еĶ���
		Integer int11 = 550;
		Integer int12 = 550;
		System.out.println(int11 == int12);// false�����߲���һ������
	}

}
