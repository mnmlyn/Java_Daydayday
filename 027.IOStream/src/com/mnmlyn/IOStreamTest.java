/*
 * IO��
 * 
 * 1. ��ṹ
 * �ֽ�����InputStream,OutputStream���������ࡣ
 * �ַ�����Reader,Writer����������
 * 
 * �����Լ�Ctrl+Shift+t,Ctrl+oȥ������Alt+���ң�Ctrl+q
 * 
 * 2. FileInputStream����FileOutputStream
 * �ļ����������������������
 * ��Ҫ���쳣����ʽ��д�����ο��±ߴ���
 * 
 * 3. BufferedInputStream��BufferedOutputStream��
 * �����˻�����
 * ����������뵽���������������е�����ȫ������ȡ���ٴδ�Ӳ�̶�ȡ��������ô��(1024*8)������
 * ����������������������������д���󣬻��Զ�д��Ӳ�̡��ֶ�Ӧ����flush(),��close()ʱ�����Զ�������������д��Ӳ��
 */
package com.mnmlyn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamTest {
	public static void main(String[] args) throws IOException {
		// ֱ����ʾһ���ļ��������̣�JDK1.6����ǰ�汾��д��
		// ��������ֽڿ����Ĳ�������������ʾ���쳣�������Ľṹ��
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("test.txt");
			fos = new FileOutputStream("copy.txt");// ����ļ����Բ�����
			int onebyte;
			while ((onebyte = fis.read()) != -1) {
				fos.write(onebyte);
			}
		} finally {
			try {
				if (fis != null)
					fis.close();
			} finally {
				if (fos != null)
					fos.close();
			}
		}

		// ��JDK1.7�汾�У��������µ��쳣���������д��ʽ
		// try֮��С������д�������Ĵ��롣��ִ�д���������ִ�д������д��룬����Զ��ر�������
		// ��Щ��ʵ����AutoCloseable�ӿڣ�������close()����
		// �����Լ���������Զ��رյ��ֻ࣬��Ҫ����ʵ��AutoCloseable�ӿڼ��ɣ�
		// ��close()����Ӧ���׳��쳣�����׳�IOException�쳣��
		try (FileInputStream fis2 = new FileInputStream("test.txt");
				FileOutputStream fos2 = new FileOutputStream("copy2.txt");
				MyStream ms = new MyStream();) {
			int onebyte;
			while ((onebyte = fis2.read()) != -1) {
				fos2.write(onebyte);
			}
		}

		// �ڽ����ļ�����ʱ��Ӧ���Զ���һ�����飬һ�δ��ļ������㹻���ֽڣ��ۻ����㹻���ֽڣ���д���ļ�
		try (FileInputStream fis3 = new FileInputStream("test.txt");
				FileOutputStream fos3 = new FileOutputStream("copy3.txt");) {
			byte[] buffer = new byte[1024 * 8];
			int len;
			while ((len = fis3.read(buffer)) != -1) {
				fos3.write(buffer, 0, len);
			}
		}

		// BufferedInputStream��BufferedOutputStream��
		// ������������һ��������������������������֮������ֽڿ������ݡ�Ч����ʵ���Ǳ��Զ�����͡�
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test.txt"));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy4.txt"));) {
			int onebyte;
			while ((onebyte = bis.read()) != -1) {
				bos.write(onebyte);
			}
		}
	}
}
