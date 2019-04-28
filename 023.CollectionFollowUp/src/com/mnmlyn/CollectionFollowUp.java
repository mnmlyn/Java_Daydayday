/*
 * 1. HashSet���ϵķ���
 * ʵ��Set�ӿڣ�Set�ӿ��еķ�������Collection�л�����ͬ
 * 
 * 2. HashSet�洢�Զ������ʱ���ȵ���hashCode()��������hashֵ��ͬ���ٵ���equals()������
 * hashCode()����ֵ��ͬ����equals()��������true����Ϊ����������ͬ��
 * �Զ�����󣬿�����Eclipse�Զ�����hashCode()��equals()���������У�ѡ�񲻴�С������31�����м�Ȩ����hash��
 * 
 * 3. LinkedHashSet��
 * �ײ����������֤��ȡ˳���ܹ�ȥ��
 * 
 * 4. TreeSet��
 * ȥ�أ�����Ԫ��ֵ����
 * 
 * 5. TreeSet�����Ƚ����Ĺ���
 * ����ö����compareTo()����������ֵ��-1,0,1
 * �Զ��������Ҫ�洢��TreeSet�У�Ӧʵ��Comparable�ӿ�
 * 
 * 6. TreeSet����Ƚ����Ĺ���
 * ����ö����compare()������
 * �Ƚ�����д����дһ���࣬ʵ��Comparator�ӿڣ���дcompare()����
 * ���磬����������String��Ҫ�����ַ�����������
 * 
 * ���õ�ʵ�ֱȽ����İ취�ǣ����������ڲ��࣬������ֹ�Ѵ���д���������
 */
package com.mnmlyn;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionFollowUp {

	public static void main(String[] args) {
		// Test1();
		// TreeSet��
		TreeSet<Integer> tset = new TreeSet<>();
		tset.add(9);
		tset.add(1);
		tset.add(6);
		System.out.println(tset);

		// TreeSet�࣬�洢�ַ����������ַ�����������
		TreeSet<String> tset1 = new TreeSet<String>(new CompareByLen());
		tset1.add("aqweqweqwdasd");
		tset1.add("afdd");
		tset1.add("aqqdfdfd");
		tset1.add("a");
		System.out.println(tset1);

		// �����ڲ��࣬ʵ�ֱȽ���
		TreeSet<String> tset2 = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int num = o1.length() - o2.length();
				return num == 0 ? o1.compareTo(o2) : num;
			}
		});
		tset2.add("aqweqweqwdasd");
		tset2.add("afdd");
		tset2.add("aqqdfdfd");
		tset2.add("a");
		System.out.println(tset2);
	}

	private static void Test1() {
		// HashSet�࣬Ԫ�ز��ظ���������֤�洢˳��
		HashSet<String> hset = new HashSet<>();
		boolean b1 = hset.add("c");
		// ����ظ�Ԫ�أ��᷵��false
		boolean b2 = hset.add("c");
		hset.add("b");
		hset.add("a");
		System.out.println(b1);
		System.out.println(b2);

		// HashSet����������������
		Iterator<String> it1 = hset.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}

		System.out.println("--------------------");
		// HashSet������forѭ�����ײ�����������
		for (String str : hset) {
			System.out.println(str);
		}

		// LinkedHashSet�࣬��֤�洢˳��ȥ��
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("c");
		lhs.add("c");
		lhs.add("b");
		lhs.add("a");
		System.out.println(lhs);
	}

}

//�����µıȽ�����ʵ�ֱȽ����ӿڣ���дcompare()�����������ַ�����������
class CompareByLen implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int num = o1.length() - o2.length();
		return num == 0 ? o1.compareTo(o2) : num;
	}

}
