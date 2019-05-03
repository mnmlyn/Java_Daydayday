/*
 * 字符流Reader和Writer
 * 
 * 1. 文件字符流FileReader，FileWriter
 * 注意，Writer抽象类中，带有缓冲区
 * 
 * 2. 带缓冲的字符流BufferedReader,BufferedWriter
 * 装饰模式的应用。其封装一个Reader或Writer。
 * 
 * 3. LineNumberReader类
 * 是BufferedReader的子类，可以统计行号，使用getLineNumber()和setLineNumber()方法
 * 
 * 4. 按照指定编码读写文本文件
 * InputStreamReader和OutputStreamWriter是字节流和字符流之间的桥梁。所谓桥梁，就是编解码。
 * 若带缓冲区的，使用BufferedReader或BufferedWriter来封装。
 * 按指定编码读文件：FileInputStream->InputStreamReader->BufferedReader
 * 按指定编码写文件：BufferedWriter->OutpurStreamWriter->FileOutputStream
 */
package com.mnmlyn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;

public class ReaderWriterTest {

	public static void main(String[] args) throws IOException {
		// 创建文件字符流的Reader，读取
		FileReader fr = new FileReader("test.txt");
		int x;
		while ((x = fr.read()) != -1) {
			char c = (char) x;
			System.out.print(c);
		}
		System.out.println();
		fr.close();

		// 创建文件字符流的Writer，写文件
		FileWriter fw = new FileWriter("a.txt");
		fw.write("你好，Java!");
		fw.close();

		// 带缓冲的字符流，除了read()或write()方法，还有readLine()和writeLine()方法
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
		String s;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
			bw.write(s);
			bw.newLine();
		}
		System.out.println();
		bw.close();
		br.close();

		// LineNumberReader类，带有行号的字符流读取
		LineNumberReader lnr = new LineNumberReader(new FileReader("test.txt"));
		String s1;
		lnr.setLineNumber(10);
		while ((s1 = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() + ": " + s1);
		}
		lnr.close();

		// 按照指定编码读写文件
		BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt"), "gbk"));
		BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("utf-8.txt"), "utf-8"));
		int x1;
		while ((x1 = br1.read()) != -1) {
			bw1.write(x1);
		}
		bw1.close();
		br1.close();
	}

}
