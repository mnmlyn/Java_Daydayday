/*
 * �ַ���Reader��Writer
 * 
 * 1. �ļ��ַ���FileReader��FileWriter
 * ע�⣬Writer�������У����л�����
 * 
 * 2. ��������ַ���BufferedReader,BufferedWriter
 * װ��ģʽ��Ӧ�á����װһ��Reader��Writer��
 * 
 * 3. LineNumberReader��
 * ��BufferedReader�����࣬����ͳ���кţ�ʹ��getLineNumber()��setLineNumber()����
 * 
 * 4. ����ָ�������д�ı��ļ�
 * InputStreamReader��OutputStreamWriter���ֽ������ַ���֮�����������ν���������Ǳ���롣
 * �����������ģ�ʹ��BufferedReader��BufferedWriter����װ��
 * ��ָ��������ļ���FileInputStream->InputStreamReader->BufferedReader
 * ��ָ������д�ļ���BufferedWriter->OutpurStreamWriter->FileOutputStream
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
		// �����ļ��ַ�����Reader����ȡ
		FileReader fr = new FileReader("test.txt");
		int x;
		while ((x = fr.read()) != -1) {
			char c = (char) x;
			System.out.print(c);
		}
		System.out.println();
		fr.close();

		// �����ļ��ַ�����Writer��д�ļ�
		FileWriter fw = new FileWriter("a.txt");
		fw.write("��ã�Java!");
		fw.close();

		// ��������ַ���������read()��write()����������readLine()��writeLine()����
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

		// LineNumberReader�࣬�����кŵ��ַ�����ȡ
		LineNumberReader lnr = new LineNumberReader(new FileReader("test.txt"));
		String s1;
		lnr.setLineNumber(10);
		while ((s1 = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() + ": " + s1);
		}
		lnr.close();

		// ����ָ�������д�ļ�
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
