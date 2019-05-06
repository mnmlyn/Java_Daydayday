/*
 * Math工具类，Random类，System工具类，BigInteger类，BigDecimal类，日期相关类
 * 
 * 1. Math工具类
 * Math.PI
 * Math.abs()
 * Math.ceil(),Math.floor(),Math.round()
 * Math.max(),Math.min()
 * Math.pow()次方,Math.sqrt()开平方
 * Math.random()，返回0.0到1.0的double值
 * 
 * 2. Random类生成随机数
 * 默认无参构造，用的是纳秒时间做种子，直接用就行
 * Random r = new Random();
 * r.nextInt()
 * 
 * 3. System类
 * System.gc()请求进行垃圾回收。垃圾回收会调用对象的finalize()方法。
 * System.exit()就是exit()函数
 * System.currentTimeMillis()返回系统当前时间的毫秒值，long类型
 * System.arraycopy()大约是memcpy()的封装
 * 
 * 4. BigInteger类
 * 可以传字符串构造
 * 加减乘除分别是add(),subtract(),multiply(),divide()
 * 除并得到商和余数是divideAndRemainder()
 * 
 * 5. BigDecimal类
 * 用于精确计算小数
 * 
 * 6. Date类
 * 日期，时间戳
 * + Date的构造和setTime()，将当前时间戳(ms)或指定时间戳(ms)，转换为Date对象
 * + getTime()，获取Date对象时间的时间戳
 * 
 * 7. SimpleDataFormat类
 * 对日期进行格式化，构造方法中指定格式pattern
 * + format()，将Date对象，格式化为构造时pattern指定的格式
 * + parse()，将pattern格式的字符串，转换为Date对象
 * 
 * 8. Calendar类
 * 进行日期字段的提取与修改
 * 抽象类，用Calendar.getInstance()获取对象，其中放的是当前日期。
 * 一般先构造，然后set想要处理的日期，然后add，get
 * get()，获取指定字段的值
 * add()，日期字段计算
 * set()，日期字段设置
 * 
 * 9. Runtime类
 * 单例模式的类，可以用于执行系统cmd命令
 * Runtime.getRuntime();获取运行时对象
 * exec()方法用于执行命令，类似exec系统调用，不过这个是在一个新的进程中执行命令，而不是当前进程
 */
package com.mnmlyn;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class SomeOtherObject {
	public static void main(String[] args) throws ParseException, IOException {
		long starttime = System.currentTimeMillis();

		// Math类
		System.out.println(Math.PI);
		float a = 1.56f;
		System.out.println(Math.abs(a));
		System.out.println(Math.ceil(a));
		System.out.println(Math.floor(a));
		System.out.println(Math.max(10, 12));
		System.out.println(Math.min(10.123, 12.1));
		System.out.println(Math.pow(2.0, 3.0));
		System.out.println(Math.sqrt(9.0));
		System.out.println(Math.round(12.45));
		System.out.println(Math.random());

		// Random类
		Random r = new Random();
		System.out.println(r.nextInt());
		System.out.println(r.nextInt(10));

		// System类
		// System.exit(0);
		// System.out.println("not exit");
		System.gc();
		int[] src = { 1, 2, 3, 4, 5 };
		int[] dst = new int[10];
		for (int x : src)
			System.out.print(x + " ");
		System.out.println();
		System.arraycopy(src, 0, dst, 0, src.length);
		for (int x : dst)
			System.out.print(x + " ");
		System.out.println();

		// BigInteger类
		BigInteger bi1 = new BigInteger("1234567890987654321");
		BigInteger bi2 = new BigInteger("10");
		System.out.println(bi1.add(bi2));
		System.out.println(bi1.subtract(bi2));
		System.out.println(bi1.multiply(bi2));
		System.out.println(bi1.divide(bi2));
		BigInteger[] biarr = bi1.divideAndRemainder(bi2);
		for (int i = 0; i < biarr.length; i++) {
			System.out.print(biarr[i] + " ");
		}
		System.out.println();

		// BigDecimal类
		BigDecimal bd1 = new BigDecimal("1.0");
		BigDecimal bd2 = new BigDecimal("0.9");
		System.out.println(bd1.subtract(bd2));
		System.out.println(1.0 - 0.9);// 这种两个double类型直接运算，不精确，有舍入误差

		// Date类
		Date d1 = new Date();
		long timestamp1 = d1.getTime();// 返回Date对象代表的时刻的毫秒时间戳
		System.out.println(timestamp1);
		// 时间戳转换为当前时区的时间
		Date d2 = new Date(0);// 时间戳，构造Date对象
		System.out.println(d2.toString());// 会返回1970.1.1午夜零点+当前时区
		d2.setTime(timestamp1);// 时间戳转换为Date
		System.out.println(d2);

		// SimpleDataFormat类
		// DateFormat是一个抽象类，不能实例化。getDateInstance()可以得到子类实例
		DateFormat df = DateFormat.getDateInstance();
		System.out.println(df.format(d1));

		// 将Date对象格式化为字符串
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();// 这样写是格式化为默认pattern
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String date_str = sdf.format(d);
		System.out.println(date_str);
		System.out.println(sdf1.format(d));

		// 将字符串按格式解析为Date对象
		String str = "3085/06/12 23:12:16";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d3 = sdf2.parse(str);// 异常，按ctrl+1暂时自动解决
		System.out.println(sdf1.format(d3));

		// Calendar类
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -5);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		System.out.println(cal.get(Calendar.YEAR));// 获取字段
		System.out.println(cal.get(Calendar.MONTH));// Month是从0开始编号的
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));// 周日是第1天

		// Runtime类
		Runtime rt = Runtime.getRuntime();
		rt.exec("shutdown -s -t 300");
		rt.exec("shutdown -a");

		long endtime = System.currentTimeMillis();
		System.out.println("程序运行时间：" + (endtime - starttime) + "ms");
	}
}