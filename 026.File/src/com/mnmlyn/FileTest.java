/*
 * File�࣬��ʾ�ļ����ļ���
 */
package com.mnmlyn;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) {
		// ����File��
		File file1 = new File("test.txt");

		// �����ļ�����ʵ����Ҫ�ж��Ƿ���ڣ�ֱ�Ӵ��������ڻ᷵��false
		if (file1.exists()) {
			System.out.println("����");
		} else {
			try {
				file1.createNewFile();
				System.out.println("�����ɹ�");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// �����ļ��У���༶�ļ���
		File file2 = new File("test_dir");
		System.out.println(file2.mkdir());
		File file3 = new File("test_dir\\dir1\\dir2");
		System.out.println(file3.mkdirs());

		// ���������ļ�
		for (int i = 0; i < 3; ++i) {
			File file4 = new File(file2, "data_" + i + ".txt");
			try {
				file4.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// �ж��Ƿ����ļ����ļ���
		System.out.println(file3.isFile());
		System.out.println(file3.isDirectory());
		// �ܷ����д
		System.out.println(file1.canRead());
		System.out.println(file1.canWrite());
		// ��ȡ����·��
		System.out.println(file1.getAbsolutePath());
		// ��ȡ���췽���е�·��
		System.out.println(file1.getPath());
		// ��ȡ����
		System.out.println(file1.getName());
		System.out.println(file2.getName());
		// ��ȡ����
		System.out.println(file1.length());
		// ��ȡ���һ���޸�ʱ�䣬����ʱ���
		System.out.println(file1.lastModified());
		Date d = new Date(file1.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		System.out.println(sdf.format(d));
		// ��ȡ·���������ļ��л��ļ�������
		String[] list = file2.list();
		for (String name : list) {
			System.out.print(name + " ");
		}
		System.out.println();
		// �ӹ�����FilenameFilter���ӿڣ���list()������
		// �������ڲ���ʵ��FilenameFilter�ӿڵ�accept()����
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
		// ��ȡ·�������е��ļ��к��ļ���File����
		File[] fileList = file2.listFiles();
		for (File file : fileList) {
			System.out.println(file.getAbsolutePath());
			file.delete();// �ǿ�Ŀ¼ɾ����ʧ��
		}

		// ��������������·����ͬ���൱�ڸ������ƶ�����ɾ��
		System.out.println(file3.delete());
		System.out.println(file1.renameTo(file3));
	}

}
