/*
 * StringBuffer，线程安全的字符串构造器
 * 
 * 非线程安全版本为StringBuilder。
 * 其实，感觉这东西基本就是C++里边的string。Java里String不能修改，
 * 修改String要依靠StringBuffer或StringBuilder
 * 
 * 1. 构造方法
 * 空参构造，初始分配空间大小为16，内容为空（length()为0，capacity()为16）
 * 
 * 2. 常用方法 
 * append()向StringBuffer最后添加，
 * insert()向指定位置添加
 * delete()删除下标范围的字符
 * deleteCharAt()删除指定下标的字符
 * replace()替换指定范围为新字符串
 * reverse()反转字符串
 * substring()得到范围内的字符串，返回String
 * 
 * 3. String和StringBuffer互相转换
 * 可以互相构造
 * String -> StringBuffer，可以append()，
 * StringBuffer -> String，可以toString()，可以substring()
 * 
 * 4. StringBuffer的非线程安全版本StringBuilder
 * 方法几乎全部一样。单线程时使用，效率更高
 * 
 * 5. String当做方法参数传递，相当于传值，
 * 而StringBuffer和StringBuilder当做方法参数传递，相当于传引用
 */
package com.mnmlyn;

public class StringBufferTest {

	public static void main(String[] args) {
		// 构造方法
		StringBuffer sb1 = new StringBuffer();
		System.out.println(sb1.capacity());// 空参构造，默认初始容量为16
		System.out.println(sb1.length());// 长度为0

		StringBuffer sb2 = new StringBuffer(10);// 指定初始容量大小
		System.out.println(sb2.capacity());
		System.out.println(sb2.length());// 长度为0

		String str1 = "hello";
		StringBuffer sb3 = new StringBuffer(str1);// 用一个字符串构造
		System.out.println(sb3.capacity());// 这种构造，除了构造的字符串，另外添加初始容量16，总共5+16=21
		System.out.println(sb3.length());// 长度为0

		// 末尾追加append()
		sb3.append(str1);
		System.out.println(sb3.toString());

		// 指定位置插入insert()
		sb3.insert(1, true);// 下标越界会报错
		System.out.println(sb3.toString());

		// 删除指定位置的字符deleteCharAt()
		sb3.deleteCharAt(0);
		System.out.println(sb3);// 直接打印默认调用toString()方法

		// 删除指定区间上的字符，左开右闭delete()
		sb3.delete(0, 4);
		System.out.println(sb3);
		sb3.delete(0, sb3.length());// 清空StringBuffer
		System.out.println(sb3);

		// 替换指定下标范围的字符为新字符串replace()
		sb3.append("abcdefg");
		sb3.replace(0, 2, "12");
		System.out.println(sb3);

		// 反转字符串reverse()
		sb3.reverse();
		System.out.println(sb3);

		// 子字符串substring()，返回String
		System.out.println(sb3.substring(5));
		System.out.println(sb3.substring(1, 3));

		// String和StringBuffer的相互转换
		System.out.println("------String和StringBuffer-------");
		String str2 = new String(sb3);
		System.out.println(str2);
		System.out.println(sb3.substring(0));
		System.out.println(sb3.toString());

		// StringBuilder
		System.out.println("--------StringBuilder---------");
		StringBuilder sbd1 = new StringBuilder();
		sbd1.append("hello");
		sbd1.reverse();
		sbd1.replace(0, 1, "O");
		System.out.println(sbd1);

		// String,StringBuffer,StringBuilder当做参数传递
		String str3 = "hello";
		StringBuilder sbd2 = new StringBuilder();
		sbd2.append(str3);
		StringBuffer sb4 = new StringBuffer();
		sb4.append(str3);

		System.out.println("--------String func----------");
		System.out.println(str3);
		func(str3);// Ctrl+1，编程提示，自动创建方法
		System.out.println(str3);// 可以看到，String当做参数传递，相当于传递值，方法中的修改，不影响原值

		System.out.println("--------StringBuilder func----------");
		System.out.println(sbd2);
		func(sbd2);
		System.out.println(sbd2);

		System.out.println("--------StringBuffer func----------");
		System.out.println(sb4);
		func(sb4);
		System.out.println(sb4);
	}

	private static void func(StringBuffer sb4) {
		sb4.append("changed");
	}

	private static void func(StringBuilder sbd2) {
		sbd2.append("changed");
	}

	private static void func(String str3) {
		str3 += "changed";
		str3 = str3.concat(str3);
	}
}