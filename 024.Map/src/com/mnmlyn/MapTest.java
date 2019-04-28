/*
 * Map��key-value�ṹ
 * 
 * 1. Map�ӿڵĻ�������
 * put()��������Ԫ�أ���key�ظ���value���£����ر����ǵ�value
 * remove()������keyɾ��Ԫ��
 * containsKey()���ж�Map�Ƿ����ĳkey
 * containsValue()���ж�Map�Ƿ����ĳValue
 * isEmpty()���ж�Map�Ƿ�Ϊ��
 * size()����С
 * 
 * 2. ��ȡMap�е�value����
 * Collection<T> c = mp.values();
 * 
 * 3. Map�ı��������ַ�ʽ����ʵ�����֣�ֻ��������������ת��Ϊʹ��forѭ����
 * + ��ȡMap��KeySet����ȡKeySet�ĵ���������key������ʹ��Map��get������ʹ��key��ȡvalue
 * + ʹ��forѭ����ʾ��for(K key : mp.keySet()){}
 * + ����Map.Entry������������Entry��Map�ӿڵ��ڲ��ӿڣ�HashSet����Map.Entry�ӿڵľ���ʵ��Entry
 * + ʹ��forѭ����ʾ��for(Entry<K,V> en:map.entrySet()){}
 * 
 * 4. HashMap�д洢��keyΪ�Զ������ʱ����HashSetһ��������hasCode()��equals()����
 * ��ʵ����HashSet����HashMap��HashSetֻ��HashMap��valueΪ�յ�����
 * 
 * 5. LinkedHashMap��
 * ���ֲ���˳��ȥ�ء���Ԫ�ز���ɾ�����²��뵽���ֻ�Ǹ���ֵ������ԭ��λ��
 * 
 * 6. TreeMap��
 * Ĭ�Ϲ��죬ʹ�ö���ʵ�ֵ�Comparable�ӿ��е�compareTo()����
 * ����Ƚ����Ĺ��죬ʹ���Զ���ıȽ���Comparator�ӿڵ�compare()������һ��ʹ�������ڲ���ʵ�ֱȽ���
 * ��TreeSet��࣬������һ����
 * 
 * 7. Hashtable���HashMap��ĶԱ�
 * ע��Hashtable��t��Сд�ģ�����һ������jdk�汾���ڵ���
 * �ײ㶼�ǻ���hash�㷨��˫�м��ϡ�
 * HashMap���̲߳���ȫ�ģ�Ч�ʸߡ�Hashtable���̰߳�ȫ�ģ�Ч�ʵ͡�
 * HashMap���Դ洢null����nullֵ��Hashtable���ܴ洢null����nullֵ��
 * 
 * 8. Collections�������еĳ��÷�����ע�ⲻ��Collection�ӿڣ���s
 * sort()����List��������
 * binarySearch()����List���ֲ���
 * max()���õ�Collection���ֵ
 * reverse()����תList
 * shuffle()����List�������
 */
package com.mnmlyn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		// Test1();
		// Test2();
		// Test3();
		// Collections������
		ArrayList<String> al = new ArrayList<>();
		al.add("b");
		al.add("gd");
		al.add("udfe");
		al.add("nd");
		al.add("qefe");
		System.out.println(al);

		// ����
		// �����Ƚ�����Ĭ�ϰ�Comparable�ӿڵ�compareTo()����
		// ���Ƚ�����sort�����������Զ���ıȽ�����compare()����
		Collections.sort(al);
		System.out.println(al);
		// �Զ���Ƚ��������ַ���������������
		Collections.sort(al, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int num = o2.length() - o1.length();
				return num == 0 ? o1.compareTo(o2) : num;
			}
		});
		System.out.println(al);

		// �������List���ж��ֲ���
		Collections.sort(al);
		System.out.println(al);
		System.out.println(Collections.binarySearch(al, "gd"));

		// �����ֵ
		System.out.println(Collections.max(al));

		// ��תList
		Collections.reverse(al);
		System.out.println(al);

		// ��List�����������
		Collections.shuffle(al);
		System.out.println(al);
	}

	private static void Test3() {
		// TreeMap��
		TreeMap<String, Integer> tm = new TreeMap<>();
		tm.put("Tom", 11);
		tm.put("Jack", 12);
		tm.put("Tiny", 17);
		tm.put("Marry", 21);
		System.out.println(tm);

		// HashMap���Դ洢null����nullֵ
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put(null, 11);
		hm.put("Jack", null);
		System.out.println(hm);

		// Hashtable���ܴ洢null����nullֵ
		Hashtable<String, Integer> ht = new Hashtable<>();
		// ht.put(null, 11);//����
		// ht.put("Jack", null);//����
		System.out.println(ht);
	}

	private static void Test2() {
		// LinkedHashMap��
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		Integer pre1 = lhm.put("Tom", 11);
		lhm.put("Jack", 12);
		lhm.put("Tiny", 17);
		lhm.put("Marry", 21);
		// �²�����ظ�Ԫ�أ�λ�ò����ı䣬ֻ�Ǹ���value
		Integer pre2 = lhm.put("Tom", 18);
		System.out.println(pre1);
		System.out.println(pre2);
		System.out.println(lhm);
	}

	private static void Test1() {
		// Map�ӿ�
		Map<String, Integer> mp = new HashMap<>();
		// Map�����put()
		Integer pre1 = mp.put("Tom", 11);
		mp.put("Jack", 12);
		mp.put("Tiny", 17);
		mp.put("Marry", 21);
		Integer pre2 = mp.put("Tom", 18);
		System.out.println(pre1);
		System.out.println(pre2);
		System.out.println(mp);
		// Map��ɾ��remove()
		mp.remove("Jack");
		System.out.println(mp);
		// Map��containsKey(),containsValue(),isEmpty(),size()
		System.out.println(mp.containsKey("Tom"));
		System.out.println(mp.containsValue(21));
		System.out.println(mp.isEmpty());
		System.out.println(mp.size());

		// ��ȡMap�е�values����
		Collection<Integer> c = mp.values();
		System.out.println(c);

		// ����Map����ʽ1
		Set<String> keySet = mp.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Integer value = mp.get(key);
			System.out.println(key + "=" + value);
		}

		// ����Map����ʽ2
		System.out.println("------------------");
		for (String key : mp.keySet()) {
			Integer value = mp.get(key);
			System.out.println(key + "=" + value);
		}

		// ����Map����ʽ3
		System.out.println("------------------");
		// ������д�Ⱥź�Ĳ��֣���Ctrl+1��ѡ��Assign statement to new local variable
		// ����Entry�ǽӿ�Map.Entry�ľ���ʵ��
		Set<Entry<String, Integer>> entrySet = mp.entrySet();
		// ��ȡ������
		Iterator<Entry<String, Integer>> it1 = entrySet.iterator();
		while (it1.hasNext()) {
			Entry<String, Integer> en = it1.next();
			String key = en.getKey();
			Integer value = en.getValue();
			System.out.println(key + "=" + value);
		}

		// ����Map����ʽ4
		System.out.println("------------------");
		for (Entry<String, Integer> en : mp.entrySet()) {
			String key = en.getKey();
			Integer value = en.getValue();
			System.out.println(key + "=" + value);
		}
	}

}
