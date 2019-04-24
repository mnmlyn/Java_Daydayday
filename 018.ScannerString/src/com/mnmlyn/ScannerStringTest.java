/*
 * Scanner类，用于输入
 * String类，字符串
 * 
 * 1. 判断输入是否是确定类型（比如整数）
 * hasNextInt()
 * 
 * 2. 输入int数，紧接着输入String，会读不到紧接着的String
 * 因为换行符没有读走
 * 
 * 3. String类
 * String对象的字符串不能修改，但可以引用另一个字符串
 * String str = "abc";
 * str[0] = '1';//这是错的
 * str = "123";
 * 
 * 4. String的构造函数
 * + 字节数组byte[]，或指定起始位置和长度
 * + 字符数组char[]，或指定起始位置和长度
 * + 字符串常量
 * 
 * 5. 两个String对象比较的坑
 * ==和equals，注意要用equals，因为==用于引用类型的时候，判断的是地址值是否相等。
 * 当两个字符串指向同一个常量串时，==的返回结果是true，但是这并不能作为判断字符串相等的通用标准，
 * 
 * 6. 调用String构造函数创建String对象时，会复制参数的副本,
 * 而字符串用=赋值时，只是指向常量字符串。具体看代码注释，这个很关键
 * 
 * 7. String常用成员方法
 * 抄文档没有任何意义，直接看代码练习使用
 */
package com.mnmlyn;

import java.util.Scanner;

public class ScannerStringTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数");
		int a;
		if (sc.hasNextInt()) {
			a = sc.nextInt();
			System.out.println(a);
		} else {
			System.out.println("输入错误");
		}

		// nextInt()并没有把换行符读走，而nextLine()将换行符当做输入结束
		// 那么，调用两次nextLine()就ok了。第一次读走遗留的换行，第二次输入字符串
		System.out.println("请输入一个字符串");
		sc.nextLine();// 这个可以在nextInt()之后调用
		String str = sc.nextLine();
		System.out.println(str);
		System.out.println("End");
		sc.close();

		// String不可修改
		String name = "abc";
		// 下边这句话是不对的。
		// name[0] = '1';
		name = "123";

		// String构造函数
		byte[] arr1 = { 'a', 98, 99 };// 字节数组，每个元素一个字节
		char[] arr2 = { 97, '中', 99 };// 字符数组，变长编码
		String s1 = new String(arr1);
		String s2 = new String(arr1, 1, 2);
		String s3 = new String(arr2);
		String s4 = new String(arr2, 1, 2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);

		// String对象判断相等
		String str1 = "456";
		String str2 = "456";
		System.out.println(str1 == str2);// 返回true，因为常量字符串"456"在常量区只存储一份
		System.out.println(str1.equals(str2));

		byte[] arr3 = { '4', '5', '6' };
		String str3 = new String(arr3);
		System.out.println("str3=" + str3 + ",str2=" + str2 + ",==?");
		System.out.println(str3 == str2);// 返回false，但是两个字符串实际相等

		System.out.println("Java中判断字符串相等，请使用equals()，而不要使用==");
		System.out.println(str3.equals(str2));

		// 1. String的构造函数，创建了几个对象?两个
		// 若常量池中没有"4321"，则常量池中会创建一个对象。调用构造函数，会创建一个副本到堆。
		String str4 = new String("4321");
		String str5 = "4321";
		String str6 = "4321";
		// 2. str4 == str5的结果是什么？str5 == str6的结果是什么？为什么？
		// false。true。因为构造函数会复制常量串的副本，而两个指向常量的字符串地址相等。
		System.out.println(str4 == str5);// false
		System.out.println(str5 == str6);// true
		String str7 = "4" + "3" + "2" + "1";
		// 3. str6==str7的结果是什么？为什么？
		// true。因为编译时，直接将常量计算得到了结果"4321"
		System.out.println(str6 == str7);// true
		String str8 = "432";
		String str9 = str8 + "1";
		// 4. str9==str6的结果是什么？为什么？
		// false。因为str8是变量，String用+号来串连，底层会用StringBuffer进行字符串拼接
		System.out.println(str9 == str6);// false
		System.out.println(str9.equals(str6));// true

		// String常用成员方法
		String mystr1 = "abc123456";
		String mystr2 = "abc";
		String mystr3 = "123456";
		String mystr4 = "abc";
		String mystr5 = "Abc";
		String mystr6 = "";
		String mystr7 = null;
		System.out.println("--------------------------------");
		System.out.println(mystr2.equals(mystr4));// 判断字符串是否相等
		System.out.println(mystr5.equalsIgnoreCase(mystr4));// 忽略大小写判断相等
		System.out.println(mystr1.contains(mystr2));// 是否含有子串
		System.out.println(mystr1.startsWith(mystr2));// 判断前缀
		System.out.println(mystr1.startsWith(mystr3, 3));// 判断前缀，指定偏移
		System.out.println(mystr1.endsWith(mystr3));// 判断后缀
		System.out.println(mystr6.isEmpty());// 判断字符串是否为空
		// System.out.println(mystr7.isEmpty());//不论怎样isEmpty()是成员方法，有对象才能调用

		// 长度，获取索引处字符，查找字符的索引，获取子串
		// length(),charAt(),IndexOf(),lastIndexOf(),substring()
		System.out.println("--------------------------------");
		System.out.println(mystr1.length());
		System.out.println(mystr1.charAt(2));
		System.out.println(mystr1.indexOf('1'));
		System.out.println(mystr1.substring(3));

		// 字符串转为字节数组
		System.out.println("--------getBytes()--------");
		String istr1 = "abc啦啦啦";
		byte[] arr4 = istr1.getBytes();// 编码为系统默认编码
		for (int i = 0; i < arr4.length; i++) {
			System.out.print(arr4[i] + " ");// 97 98 99 -64 -78 -64 -78 -64 -78
		}
		System.out.println();

		// 字符串转换为字符数组
		System.out.println("--------toCharArray()--------");
		char[] arr5 = istr1.toCharArray();
		for (int i = 0; i < arr5.length; i++) {
			System.out.print(arr5[i] + " ");
		}
		System.out.println();

		// valueOf()静态方法，把任意类型转换为String，实际是调用String的构造方法
		System.out.println("--------valueOf()--------");
		int b = 123456;
		String istr2 = String.valueOf(b);
		System.out.println(istr2);
		String istr3 = String.valueOf(arr5);
		System.out.println(istr3);

		// 字符串变为全部大写，变为全部小写
		System.out.println("--------toLower-Upper-Case()--------");
		String istr4 = "asdfSHDISHDI啦啦啦";
		System.out.println(istr4.toLowerCase());
		System.out.println(istr4.toUpperCase());

		// 字符串拼接
		System.out.println("--------concat()--------");
		String istr5 = "abc";
		String istr6 = "defg";
		System.out.println(istr5.concat(istr6));

		// 字符串替换
		System.out.println("--------replace()--------");
		String istr7 = "   hello   world!    ";
		System.out.println(istr7.replace('l', 'g'));// 按照字符替换
		System.out.println(istr7.replace("world", "java"));// 按照子字符串替换

		// 字符串两端空格的去除
		System.out.println("--------trim()--------");
		System.out.println(istr7.trim());

		// 字符串字典序比较
		System.out.println("--------compareTo()--------");
		String istr8 = "hello";
		String istr9 = "head";
		String istr10 = "Hello";
		String istr11 = "hellohhhh";
		System.out.println(istr8.compareTo(istr9));// 若不等，返回第一个不等的元素的编码值的差。Unicode
		System.out.println(istr8.compareTo(istr11));// 若一个串是另一个的前缀，返回值是length的差
		System.out.println(istr8.compareToIgnoreCase(istr10));// 忽略大小写
	}

}
