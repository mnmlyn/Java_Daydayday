/*
 * 1. HashSet集合的方法
 * 实现Set接口，Set接口中的方法，和Collection中基本相同
 * 
 * 2. HashSet存储自定义对象时，先调用hashCode()方法，若hash值相同，再调用equals()方法。
 * hashCode()返回值相同，且equals()方法返回true，认为两个对象相同。
 * 自定义对象，可以用Eclipse自动生成hashCode()和equals()方法。其中，选择不大不小的素数31来进行加权计算hash。
 * 
 * 3. LinkedHashSet类
 * 底层基于链表，保证存取顺序，能够去重
 * 
 * 4. TreeSet类
 * 去重，按照元素值有序
 * 
 * 5. TreeSet不传比较器的构造
 * 会调用对象的compareTo()方法，返回值是-1,0,1
 * 自定义对象，若要存储在TreeSet中，应实现Comparable接口
 * 
 * 6. TreeSet传入比较器的构造
 * 会调用对象的compare()方法。
 * 比较器的写法。写一个类，实现Comparator接口，重写compare()方法
 * 比如，对于已有类String，要按照字符串长度排序
 * 
 * 更好的实现比较器的办法是，定义匿名内部类，这样防止把代码写的七零八落
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
		// TreeSet类
		TreeSet<Integer> tset = new TreeSet<>();
		tset.add(9);
		tset.add(1);
		tset.add(6);
		System.out.println(tset);

		// TreeSet类，存储字符串，按照字符串长度排序
		TreeSet<String> tset1 = new TreeSet<String>(new CompareByLen());
		tset1.add("aqweqweqwdasd");
		tset1.add("afdd");
		tset1.add("aqqdfdfd");
		tset1.add("a");
		System.out.println(tset1);

		// 匿名内部类，实现比较器
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
		// HashSet类，元素不重复，但不保证存储顺序
		HashSet<String> hset = new HashSet<>();
		boolean b1 = hset.add("c");
		// 添加重复元素，会返回false
		boolean b2 = hset.add("c");
		hset.add("b");
		hset.add("a");
		System.out.println(b1);
		System.out.println(b2);

		// HashSet遍历，借助迭代器
		Iterator<String> it1 = hset.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}

		System.out.println("--------------------");
		// HashSet遍历，for循环，底层依赖迭代器
		for (String str : hset) {
			System.out.println(str);
		}

		// LinkedHashSet类，保证存储顺序，去重
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("c");
		lhs.add("c");
		lhs.add("b");
		lhs.add("a");
		System.out.println(lhs);
	}

}

//定义新的比较器，实现比较器接口，重写compare()方法，按照字符串长度排序
class CompareByLen implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int num = o1.length() - o2.length();
		return num == 0 ? o1.compareTo(o2) : num;
	}

}
