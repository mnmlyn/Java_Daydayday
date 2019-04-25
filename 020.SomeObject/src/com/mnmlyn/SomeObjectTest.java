/*
 * 一些常用类，可以预见这一篇很水，但是都是常规操作，必须会
 * 
 * 1. Arrays工具类
 * 对数组进行常用操作，排序，二分查找，转字符串
 * 
 * 2. Integer等包装类
 * 有静态方法，将基本数据类型转字符串
 * 
 * 3. String和int的转换
 * + int转String，
 *   直接用+号，""+10
 *   用String的静态方法valueOf()
 * + String转int
 *   用Integer.parseInt()
 * 
 * 4. 自动装箱和自动拆箱
 * 自动装箱是把基本数据类型转换为对象，比如int到Integer
 * Integer int1 = 110;
 * 自动拆箱是把独享转换为基本数据类型，比如Integer到int
 * int a = int1;
 * 
 * 5. 自动装箱，将基本数据类型int构造为Integer时。
 * 若值在byte范围内-128~127，则构造指向常量池。否则，重新构造对象。
 * 自己手动构造对象，都是会构造对象的，不存在此问题。
 * 
 * ----------------------------------------------
 * 6. 正则表达式
 * String对象的方法，str.matches()，判断是否正则匹配
 * str.split()，正则匹配，匹配到的作为切分字符，对str进行切分
 * str.replaceAll()，正则匹配，全部替换
 * 正则匹配的分组问题，(a)(b(c))，\\1 \\2 ...，$1 $2 ...
 * 按照左括号确定分组顺序
 * 
 * 7. Pattern类和Matcher类用于正则匹配
 * 典型使用方式，
 * Pattern p = Pattern.compile("a*b+");//编译得到正则模式p
 * Matcher m = p.matcher("aaaaab");//调用p的matcher方法，匹配字符串，得道匹配对象m
 * boolean b = m.matches();//用匹配对象判断是否匹配
 * m.find()判断是否还有匹配项
 * m.group()得到find()到的匹配项
 */
package com.mnmlyn;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SomeObjectTest {

	public static void main(String[] args) {
		Test1();//按键Ctrl+1，按照提示，提取方法
		Test2();
	}

	private static void Test2() {
		//正则表达式，判断匹配matches()
		String regex = "[1-9]+";
		System.out.println("12312412".matches(regex));//true
		System.out.println("1231241sdf2".matches(regex));//false
		
		//正则表达式，切分split()
		String str1 = "hello hallo haha";
		String[] arr1 = str1.split(" ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		String str2="hello?hallo?haha";
		String[] arr2 = str2.split("\\?");//正则的特殊字符，要用两个反斜杠转义
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		//练习，给定一个空格分隔的整数构成的字符串，对他们进行排序
		String str3 = "45 63 12 87 1223";
		String[] arr3 = str3.split(" ");
		int[] intarr3 = new int[arr3.length];
		for (int i = 0; i < intarr3.length; i++) {
			intarr3[i] = Integer.parseInt(arr3[i]);
		}
		Arrays.sort(intarr3);
		StringBuilder sb = new StringBuilder(str3.length());//直接使用String进行拼接，效率很低
		for (int i = 0; i < intarr3.length; i++) {
			sb.append(intarr3[i]);
			if(i != intarr3.length-1)
				sb.append(" ");
		}
		String str3_ret = sb.toString();
		System.out.println(str3_ret);
		
		//正则匹配，进行替换
		String str4 = "abc2de3fgh5444433ijk34lmn";
		String str4_ret = str4.replaceAll("\\d", "");
		System.out.println(str4);
		System.out.println(str4_ret);
		
		//正则匹配的分组
		//去除字符串中的分隔字符‘.’，将连续重复字符变为只有一个
		String str5 = "我.....我我...我我..爱.爱爱爱你.....你你你....你...啊啊...啊啊啊..";
		System.out.println(str5.replaceAll("\\.",""));
		//正则字符串里\\1是匹配第一个括号，也即是分组的匹配内容。在替换字符串里，$1代表第一个分组的内容
		System.out.println(str5.replaceAll("\\.","").replaceAll("(.)\\1+", "$1"));
		
		//用Pattern和Matcher进行正则匹配
		String str6 = "IP1:192.168.1.120, IP2:10.123.2.3, tag:12313.13.12313.12312, IP3:125.18.246.200.";
		Pattern p = Pattern.compile("((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(1\\d\\d|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)");
		//注意下边这么写竟然不对，IP地址最后一个数字，只匹配一位就结束。
		//这是因为，小括号()中用竖线|分隔的不同组，是按照书写顺序来进行匹配的，匹配到就结束
		//Pattern p = Pattern.compile("((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])");
		Matcher m = p.matcher(str6);
		while(m.find()) {
			System.out.println(m.group());
		}
	}

	private static void Test1() {
		// 数组的常用操作，使用Arrays工具类
		int[] arr1 = { 1, 7, 3, 9, 2, 4 };
		Arrays.sort(arr1);// 排序
		String str1 = Arrays.toString(arr1);// 转为字符串
		System.out.println(str1);
		System.out.println(Arrays.binarySearch(arr1, 3));// 返回下标
		System.out.println(Arrays.binarySearch(arr1, 5));// 返回插入位置+1，加负号

		// Integer包装类
		System.out.println(Integer.toBinaryString(255));
		System.out.println(Integer.toHexString(255));
		System.out.println(Integer.toOctalString(255));
		System.out.println(Integer.toString(255));
		System.out.println(Integer.toString(255, 16));// 可以直接用这种toString()的重载
		System.out.println(Integer.toString(255, 2));

		// Integer构造函数
		Integer int1 = new Integer(10);
		Integer int2 = new Integer("10");
		System.out.println(int1);
		System.out.println(int2);
		System.out.println(Integer.MIN_VALUE);// Integer最大最小值
		System.out.println(Integer.MAX_VALUE);

		// int转String
		int a = 10;
		String str2 = "" + a;
		String str3 = String.valueOf(a);
		System.out.println(str2);
		System.out.println(str3);

		// String转int
		int b = Integer.parseInt(str2);
		System.out.println(b);

		// 装箱
		Integer int3 = new Integer(100);
		// 拆箱
		int c = int3.intValue();
		// 自动装箱
		Integer int4 = 100;
		// 自动拆箱
		int d = int4;
		// 注意，自动拆箱时，对象为null会报错，所以最好先判断对象是否为null
		System.out.println(int3);
		System.out.println(c);
		System.out.println(int4);
		System.out.println(d);

		// 手动装箱
		Integer int5 = new Integer(50);
		Integer int6 = new Integer(50);
		System.out.println(int5 == int6);// false，两者不是一个对象
		Integer int7 = new Integer(550);
		Integer int8 = new Integer(550);
		System.out.println(int7 == int8);// false，两者不是一个对象

		// 自动装箱
		Integer int9 = 50;
		Integer int10 = 50;
		System.out.println(int9 == int10);// true，两者竟然是一个对象，
		// 这是因为，在byte范围内的数，自动装箱会指向常量池中的对象
		Integer int11 = 550;
		Integer int12 = 550;
		System.out.println(int11 == int12);// false，两者不是一个对象
	}

}
