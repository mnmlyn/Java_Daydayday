/*
 * File类，表示文件或文件夹
 */
package com.mnmlyn;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) {
		// 创建File类
		File file1 = new File("test.txt");

		// 创建文件，其实不需要判断是否存在，直接创建，存在会返回false
		if (file1.exists()) {
			System.out.println("存在");
		} else {
			try {
				file1.createNewFile();
				System.out.println("创建成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 创建文件夹，或多级文件夹
		File file2 = new File("test_dir");
		System.out.println(file2.mkdir());
		File file3 = new File("test_dir\\dir1\\dir2");
		System.out.println(file3.mkdirs());

		// 建立几个文件
		for (int i = 0; i < 3; ++i) {
			File file4 = new File(file2, "data_" + i + ".txt");
			try {
				file4.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 判断是否是文件、文件夹
		System.out.println(file3.isFile());
		System.out.println(file3.isDirectory());
		// 能否读，写
		System.out.println(file1.canRead());
		System.out.println(file1.canWrite());
		// 获取绝对路径
		System.out.println(file1.getAbsolutePath());
		// 获取构造方法中的路径
		System.out.println(file1.getPath());
		// 获取名称
		System.out.println(file1.getName());
		System.out.println(file2.getName());
		// 获取长度
		System.out.println(file1.length());
		// 获取最后一次修改时间，毫秒时间戳
		System.out.println(file1.lastModified());
		Date d = new Date(file1.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println(sdf.format(d));
		// 获取路径下所有文件夹或文件的名称
		String[] list = file2.list();
		for (String name : list) {
			System.out.print(name + " ");
		}
		System.out.println();
		// 加过滤器FilenameFilter（接口）的list()方法，
		// 用匿名内部类实现FilenameFilter接口的accept()方法
		String[] fileNameList = file2.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		for (String name : fileNameList) {
			System.out.print(name + " ");
		}
		System.out.println();
		// 获取路径下所有的文件夹和文件的File对象
		File[] fileList = file2.listFiles();
		for (File file : fileList) {
			System.out.println(file.getAbsolutePath());
			file.delete();// 非空目录删除会失败
		}

		// 重命名（命名后路径不同，相当于改名并移动），删除
		System.out.println(file3.delete());
		System.out.println(file1.renameTo(file3));
	}

}
