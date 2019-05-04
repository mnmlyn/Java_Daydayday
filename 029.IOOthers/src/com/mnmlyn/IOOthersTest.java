/*
 * IO流，字节流和字符流之外的其他类
 * 
 * 1. SequenceInputStream类
 * 串连多个输入流
 * 
 * 2. ByteArrayOutputStream类
 * 输出到一个（自动增长的）字节数组
 * toByteArray()，返回复制的内存数组
 * toString()，按照系统默认编码，对内存数组进行解码，得到String
 * 
 * 3. ObjectOutputStream类和ObjectInputStream类
 * 对象序列化和反序列化
 * 被序列化的类，要实现Serializable接口，该接口没有任何方法。
 * 被序列化的类，可以添加serialVersionUID字段，标识类的不同版本，防止序列化和反序列化时类的定义不同。
 * 
 * 4. PrintStream类
 * System.out就是一个PrintStream
 * 
 * 5. PrintWriter类
 * 有print,write,println等方法，其中只有println方法自动flush。
 * 
 * 6. 修改标准输入输出流
 * System.in是一个InputStream对象
 * System.out是一个PringStream对象
 * System.setIn()和System.SetOut()方法修改
 * 
 * 7. 实现键盘录入的两种方法
 * 第一，使用InputStreamReader进行输入字节流向字符流的转换，使用BufferedReader进行包装，可以读一行。
 * 第二，使用Scanner。
 * 
 * 8. RandomAccessFile类，实现文件随机访问
 * 主要是seek()方法，可以设置指针位置
 * 
 * 9. DataInputStream类和DataOutputStream类
 * 用于基本类型数据的输入输出，比如int类型数，按照4字节输入输出
 * 
 * 10. Properties类
 * 是Hashtable的子类，用于读取和写入配置文件
 */
package com.mnmlyn;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;
import java.util.Vector;

public class IOOthersTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Test1();
		// Test2();
		// Test3();
		// Test4();
		Test5();
	}

	private static void Test5() throws IOException, FileNotFoundException {
		// Properties类
		Properties prop = new Properties();
		// prop.put("name", "Tom");
		prop.setProperty("name", "Tom");
		prop.setProperty("age", "19");
		System.out.println(prop);

		// 获取所有键的可枚举集合，进行遍历
		Enumeration<String> en = (Enumeration<String>) prop.propertyNames();
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			String value = prop.getProperty(key);
			System.out.println(key + "=" + value);
		}

		// load和store方法
		Properties prop1 = new Properties();
		prop1.load(new FileInputStream("config.properties"));// 文件中可以用=或:都可以
		System.out.println(prop1);
		prop1.setProperty("tel", "19312345678");
		prop1.store(new FileOutputStream("config.properties"), "comments");// 第二个参数是注释
	}

	private static void Test4() throws FileNotFoundException, IOException {
		// RandomAccessFile类，文件随机访问
		RandomAccessFile raf = new RandomAccessFile("test4.txt", "rw");
		int x = raf.read();
		System.out.println(x);
		// 移动文件指针
		raf.seek(4);
		System.out.println((char) (raf.read()));
		raf.close();

		// DataInputStream和DataOutputStream
		// 输出，包装一个OutputStream
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("d.txt"));
		dos.writeInt(5362);
		dos.writeInt(84627);
		dos.close();
		// 输入
		DataInputStream dis = new DataInputStream(new FileInputStream("d.txt"));
		int x1 = dis.readInt();
		int x2 = dis.readInt();
		System.out.println(x1);
		System.out.println(x2);
		dis.close();
	}

	private static void Test3() throws IOException {
		// 进行键盘录入的两种方法
		// InputStream -> InputStreamReader -> BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		System.out.println(line);
		// Scanner类实现键盘录入，功能更强大
		Scanner sc = new Scanner(System.in);
		String line2 = sc.nextLine();
		System.out.println(line2);
		sc.close();
	}

	private static void Test2() throws FileNotFoundException, IOException {
		// PrintStream类
		PrintStream ps = System.out;
		ps.println(97);
		ps.print(97);
		// 观察到，write并不会立即显示，要等到写入一个换行，或者调用flush()方法，才能打印出来
		ps.write(97);
		// ps.flush();

		// PrintWriter类
		PrintWriter pw = new PrintWriter("b.txt");
		pw.print(97);
		// pw.flush();
		pw.close();

		// 修改标准输入输出流
		System.setIn(new FileInputStream("test3.txt"));
		System.setOut(new PrintStream("c.txt"));
		InputStream is = System.in;
		PrintStream ps1 = System.out;
		int b;
		while ((b = is.read()) != -1) {
			ps1.write(b);
		}
	}

	private static void Test1()
			throws FileNotFoundException, IOException, UnsupportedEncodingException, ClassNotFoundException {
		// SequenceInputStream用来合并两个输入字节流
		FileInputStream fis1 = new FileInputStream("test1.txt");
		FileInputStream fis2 = new FileInputStream("test2.txt");
		SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
		InputStreamReader isr = new InputStreamReader(sis);
		int x;
		while ((x = isr.read()) != -1) {
			System.out.print((char) x);
		}
		System.out.println();
		isr.close();

		// SequenceInputStream用来合并多个输入字节流
		FileInputStream fisa = new FileInputStream("test1.txt");
		FileInputStream fisb = new FileInputStream("test2.txt");
		FileInputStream fisc = new FileInputStream("test3.txt");
		// Vector的elements()方法，会返回一个Enumeration，可以用作SequenceInputStream构造函数的参数
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(fisa);
		v.add(fisb);
		v.add(fisc);
		Enumeration<FileInputStream> elements = v.elements();
		SequenceInputStream sis1 = new SequenceInputStream(elements);
		InputStreamReader isr1 = new InputStreamReader(sis1);
		int x1;
		while ((x1 = isr1.read()) != -1) {
			System.out.print((char) x1);
		}
		System.out.println();
		isr1.close();

		// ByteArrayOutputStream类，用于将字节流输出到内存
		FileInputStream fis3 = new FileInputStream("test3.txt");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();// 不用close()，伪IO
		int x2;
		while ((x2 = fis3.read()) != -1) {
			baos.write(x2);
		}
		// ByteArrayOutputStream类对象的toByteArray()方法和toString()方法可以得到内存缓冲区内容
		// 其中toString()方法使用默认编码进行字节到字符的转换
		byte[] arr = baos.toByteArray();
		System.out.println(new String(arr, "gbk"));
		// 若使用默认编码转换为字符串，可以直接用toString()方法（缺省）
		System.out.println(baos);
		fis3.close();

		// ObjectOutputStream类，对象的序列化
		Person p1 = new Person("小赵", 16);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
		oos.writeObject(p1);
		oos.close();

		// ObjectInputStream类，对象的反序列化
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
		Person p2 = (Person) ois.readObject();// ClassNotFoundException异常简单抛出
		System.out.println(p2);
		ois.close();
	}

}