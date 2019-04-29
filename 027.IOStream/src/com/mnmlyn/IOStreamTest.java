/*
 * IO流
 * 
 * 1. 类结构
 * 字节流：InputStream,OutputStream两个抽象父类。
 * 字符流：Reader,Writer两个抽象父类
 * 
 * 可以自己Ctrl+Shift+t,Ctrl+o去搜索，Alt+左右，Ctrl+q
 * 
 * 2. FileInputStream，和FileOutputStream
 * 文件输入输出流，不带缓冲区
 * 主要是异常处理方式的写法，参考下边代码
 * 
 * 3. BufferedInputStream和BufferedOutputStream类
 * 内置了缓冲区
 * 输入流会读入到缓冲区，缓冲区中的数据全部被读取后，再次从硬盘读取缓冲区那么多(1024*8)的数据
 * 输出流会输出到缓冲区，缓冲区被写满后，会自动写到硬盘。手动应调用flush(),在close()时，会自动将缓冲区内容写到硬盘
 */
package com.mnmlyn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamTest {
	public static void main(String[] args) throws IOException {
		// 直接演示一个文件拷贝过程，JDK1.6及以前版本的写法
		// 忽略逐个字节拷贝的操作，仅用于演示流异常处理代码的结构。
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("test.txt");
			fos = new FileOutputStream("copy.txt");// 输出文件可以不存在
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

		// 在JDK1.7版本中，引入了新的异常处理代码书写方式
		// try之后，小括号中写创建流的代码。先执行创建流，再执行大括号中代码，最后自动关闭所有流
		// 这些流实现了AutoCloseable接口，其中有close()方法
		// 若想自己定义可以自动关闭的类，只需要让类实现AutoCloseable接口即可，
		// 且close()方法应不抛出异常，或抛出IOException异常。
		try (FileInputStream fis2 = new FileInputStream("test.txt");
				FileOutputStream fos2 = new FileOutputStream("copy2.txt");
				MyStream ms = new MyStream();) {
			int onebyte;
			while ((onebyte = fis2.read()) != -1) {
				fos2.write(onebyte);
			}
		}

		// 在进行文件拷贝时，应该自定义一个数组，一次从文件读入足够多字节，累积够足够多字节，再写入文件
		try (FileInputStream fis3 = new FileInputStream("test.txt");
				FileOutputStream fos3 = new FileOutputStream("copy3.txt");) {
			byte[] buffer = new byte[1024 * 8];
			int len;
			while ((len = fis3.read(buffer)) != -1) {
				fos3.write(buffer, 0, len);
			}
		}

		// BufferedInputStream和BufferedOutputStream类
		// 输入和输出各有一个缓冲区，程序在两个缓冲区之间逐个字节拷贝数据。效率其实还是比自定数组低。
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test.txt"));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy4.txt"));) {
			int onebyte;
			while ((onebyte = bis.read()) != -1) {
				bos.write(onebyte);
			}
		}
	}
}
