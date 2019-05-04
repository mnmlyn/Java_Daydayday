/*
 * IO�����ֽ������ַ���֮���������
 * 
 * 1. SequenceInputStream��
 * �������������
 * 
 * 2. ByteArrayOutputStream��
 * �����һ�����Զ������ģ��ֽ�����
 * toByteArray()�����ظ��Ƶ��ڴ�����
 * toString()������ϵͳĬ�ϱ��룬���ڴ�������н��룬�õ�String
 * 
 * 3. ObjectOutputStream���ObjectInputStream��
 * �������л��ͷ����л�
 * �����л����࣬Ҫʵ��Serializable�ӿڣ��ýӿ�û���κη�����
 * �����л����࣬�������serialVersionUID�ֶΣ���ʶ��Ĳ�ͬ�汾����ֹ���л��ͷ����л�ʱ��Ķ��岻ͬ��
 * 
 * 4. PrintStream��
 * System.out����һ��PrintStream
 * 
 * 5. PrintWriter��
 * ��print,write,println�ȷ���������ֻ��println�����Զ�flush��
 * 
 * 6. �޸ı�׼���������
 * System.in��һ��InputStream����
 * System.out��һ��PringStream����
 * System.setIn()��System.SetOut()�����޸�
 * 
 * 7. ʵ�ּ���¼������ַ���
 * ��һ��ʹ��InputStreamReader���������ֽ������ַ�����ת����ʹ��BufferedReader���а�װ�����Զ�һ�С�
 * �ڶ���ʹ��Scanner��
 * 
 * 8. RandomAccessFile�࣬ʵ���ļ��������
 * ��Ҫ��seek()��������������ָ��λ��
 * 
 * 9. DataInputStream���DataOutputStream��
 * ���ڻ����������ݵ��������������int������������4�ֽ��������
 * 
 * 10. Properties��
 * ��Hashtable�����࣬���ڶ�ȡ��д�������ļ�
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
		// Properties��
		Properties prop = new Properties();
		// prop.put("name", "Tom");
		prop.setProperty("name", "Tom");
		prop.setProperty("age", "19");
		System.out.println(prop);

		// ��ȡ���м��Ŀ�ö�ټ��ϣ����б���
		Enumeration<String> en = (Enumeration<String>) prop.propertyNames();
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			String value = prop.getProperty(key);
			System.out.println(key + "=" + value);
		}

		// load��store����
		Properties prop1 = new Properties();
		prop1.load(new FileInputStream("config.properties"));// �ļ��п�����=��:������
		System.out.println(prop1);
		prop1.setProperty("tel", "19312345678");
		prop1.store(new FileOutputStream("config.properties"), "comments");// �ڶ���������ע��
	}

	private static void Test4() throws FileNotFoundException, IOException {
		// RandomAccessFile�࣬�ļ��������
		RandomAccessFile raf = new RandomAccessFile("test4.txt", "rw");
		int x = raf.read();
		System.out.println(x);
		// �ƶ��ļ�ָ��
		raf.seek(4);
		System.out.println((char) (raf.read()));
		raf.close();

		// DataInputStream��DataOutputStream
		// �������װһ��OutputStream
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("d.txt"));
		dos.writeInt(5362);
		dos.writeInt(84627);
		dos.close();
		// ����
		DataInputStream dis = new DataInputStream(new FileInputStream("d.txt"));
		int x1 = dis.readInt();
		int x2 = dis.readInt();
		System.out.println(x1);
		System.out.println(x2);
		dis.close();
	}

	private static void Test3() throws IOException {
		// ���м���¼������ַ���
		// InputStream -> InputStreamReader -> BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		System.out.println(line);
		// Scanner��ʵ�ּ���¼�룬���ܸ�ǿ��
		Scanner sc = new Scanner(System.in);
		String line2 = sc.nextLine();
		System.out.println(line2);
		sc.close();
	}

	private static void Test2() throws FileNotFoundException, IOException {
		// PrintStream��
		PrintStream ps = System.out;
		ps.println(97);
		ps.print(97);
		// �۲쵽��write������������ʾ��Ҫ�ȵ�д��һ�����У����ߵ���flush()���������ܴ�ӡ����
		ps.write(97);
		// ps.flush();

		// PrintWriter��
		PrintWriter pw = new PrintWriter("b.txt");
		pw.print(97);
		// pw.flush();
		pw.close();

		// �޸ı�׼���������
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
		// SequenceInputStream�����ϲ����������ֽ���
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

		// SequenceInputStream�����ϲ���������ֽ���
		FileInputStream fisa = new FileInputStream("test1.txt");
		FileInputStream fisb = new FileInputStream("test2.txt");
		FileInputStream fisc = new FileInputStream("test3.txt");
		// Vector��elements()�������᷵��һ��Enumeration����������SequenceInputStream���캯���Ĳ���
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

		// ByteArrayOutputStream�࣬���ڽ��ֽ���������ڴ�
		FileInputStream fis3 = new FileInputStream("test3.txt");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();// ����close()��αIO
		int x2;
		while ((x2 = fis3.read()) != -1) {
			baos.write(x2);
		}
		// ByteArrayOutputStream������toByteArray()������toString()�������Եõ��ڴ滺��������
		// ����toString()����ʹ��Ĭ�ϱ�������ֽڵ��ַ���ת��
		byte[] arr = baos.toByteArray();
		System.out.println(new String(arr, "gbk"));
		// ��ʹ��Ĭ�ϱ���ת��Ϊ�ַ���������ֱ����toString()������ȱʡ��
		System.out.println(baos);
		fis3.close();

		// ObjectOutputStream�࣬��������л�
		Person p1 = new Person("С��", 16);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
		oos.writeObject(p1);
		oos.close();

		// ObjectInputStream�࣬����ķ����л�
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
		Person p2 = (Person) ois.readObject();// ClassNotFoundException�쳣���׳�
		System.out.println(p2);
		ois.close();
	}

}