/*
 * Map，key-value结构
 * 
 * 1. Map接口的基本方法
 * put()，插入新元素，若key重复，value更新，返回被覆盖的value
 * remove()，根据key删除元素
 * containsKey()，判断Map是否包含某key
 * containsValue()，判断Map是否包含某Value
 * isEmpty()，判断Map是否为空
 * size()，大小
 * 
 * 2. 获取Map中的value集合
 * Collection<T> c = mp.values();
 * 
 * 3. Map的遍历，四种方式（其实是两种，只不过迭代器可以转变为使用for循环）
 * + 获取Map的KeySet，获取KeySet的迭代器，对key遍历，使用Map的get方法，使用key获取value
 * + 使用for循环，示例for(K key : mp.keySet()){}
 * + 根据Map.Entry来遍历，其中Entry是Map接口的内部接口，HashSet中有Map.Entry接口的具体实现Entry
 * + 使用for循环，示例for(Entry<K,V> en:map.entrySet()){}
 * 
 * 4. HashMap中存储的key为自定义对象时，和HashSet一样，基于hasCode()和equals()方法
 * 其实，是HashSet基于HashMap，HashSet只是HashMap的value为空的特例
 * 
 * 5. LinkedHashMap类
 * 保持插入顺序，去重。新元素不是删除重新插入到最后，只是更新值，保持原有位置
 * 
 * 6. TreeMap类
 * 默认构造，使用对象实现的Comparable接口中的compareTo()方法
 * 传入比较器的构造，使用自定义的比较器Comparator接口的compare()方法，一般使用匿名内部类实现比较器
 * 和TreeSet差不多，不再敲一遍了
 * 
 * 7. Hashtable类和HashMap类的对比
 * 注意Hashtable的t是小写的，这是一个早起jdk版本存在的类
 * 底层都是基于hash算法，双列集合。
 * HashMap是线程不安全的，效率高。Hashtable是线程安全的，效率低。
 * HashMap可以存储null键和null值。Hashtable不能存储null键和null值。
 * 
 * 8. Collections工具类中的常用方法，注意不是Collection接口，有s
 * sort()，对List进行排序
 * binarySearch()，对List二分查找
 * max()，得到Collection最大值
 * reverse()，反转List
 * shuffle()，对List随机打乱
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
		// Collections工具类
		ArrayList<String> al = new ArrayList<>();
		al.add("b");
		al.add("gd");
		al.add("udfe");
		al.add("nd");
		al.add("qefe");
		System.out.println(al);

		// 排序
		// 不传比较器，默认按Comparable接口的compareTo()方法
		// 传比较器的sort方法，按照自定义的比较器的compare()方法
		Collections.sort(al);
		System.out.println(al);
		// 自定义比较器按照字符创长度逆序排列
		Collections.sort(al, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int num = o2.length() - o1.length();
				return num == 0 ? o1.compareTo(o2) : num;
			}
		});
		System.out.println(al);

		// 对升序的List进行二分查找
		Collections.sort(al);
		System.out.println(al);
		System.out.println(Collections.binarySearch(al, "gd"));

		// 求最大值
		System.out.println(Collections.max(al));

		// 反转List
		Collections.reverse(al);
		System.out.println(al);

		// 对List进行随机打乱
		Collections.shuffle(al);
		System.out.println(al);
	}

	private static void Test3() {
		// TreeMap类
		TreeMap<String, Integer> tm = new TreeMap<>();
		tm.put("Tom", 11);
		tm.put("Jack", 12);
		tm.put("Tiny", 17);
		tm.put("Marry", 21);
		System.out.println(tm);

		// HashMap可以存储null键和null值
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put(null, 11);
		hm.put("Jack", null);
		System.out.println(hm);

		// Hashtable不能存储null键和null值
		Hashtable<String, Integer> ht = new Hashtable<>();
		// ht.put(null, 11);//报错
		// ht.put("Jack", null);//报错
		System.out.println(ht);
	}

	private static void Test2() {
		// LinkedHashMap类
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		Integer pre1 = lhm.put("Tom", 11);
		lhm.put("Jack", 12);
		lhm.put("Tiny", 17);
		lhm.put("Marry", 21);
		// 新插入的重复元素，位置并不改变，只是覆盖value
		Integer pre2 = lhm.put("Tom", 18);
		System.out.println(pre1);
		System.out.println(pre2);
		System.out.println(lhm);
	}

	private static void Test1() {
		// Map接口
		Map<String, Integer> mp = new HashMap<>();
		// Map的添加put()
		Integer pre1 = mp.put("Tom", 11);
		mp.put("Jack", 12);
		mp.put("Tiny", 17);
		mp.put("Marry", 21);
		Integer pre2 = mp.put("Tom", 18);
		System.out.println(pre1);
		System.out.println(pre2);
		System.out.println(mp);
		// Map的删除remove()
		mp.remove("Jack");
		System.out.println(mp);
		// Map的containsKey(),containsValue(),isEmpty(),size()
		System.out.println(mp.containsKey("Tom"));
		System.out.println(mp.containsValue(21));
		System.out.println(mp.isEmpty());
		System.out.println(mp.size());

		// 获取Map中的values集合
		Collection<Integer> c = mp.values();
		System.out.println(c);

		// 遍历Map，方式1
		Set<String> keySet = mp.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Integer value = mp.get(key);
			System.out.println(key + "=" + value);
		}

		// 遍历Map，方式2
		System.out.println("------------------");
		for (String key : mp.keySet()) {
			Integer value = mp.get(key);
			System.out.println(key + "=" + value);
		}

		// 遍历Map，方式3
		System.out.println("------------------");
		// 可以先写等号后的部分，按Ctrl+1，选择Assign statement to new local variable
		// 这里Entry是接口Map.Entry的具体实现
		Set<Entry<String, Integer>> entrySet = mp.entrySet();
		// 获取迭代器
		Iterator<Entry<String, Integer>> it1 = entrySet.iterator();
		while (it1.hasNext()) {
			Entry<String, Integer> en = it1.next();
			String key = en.getKey();
			Integer value = en.getValue();
			System.out.println(key + "=" + value);
		}

		// 遍历Map，方式4
		System.out.println("------------------");
		for (Entry<String, Integer> en : mp.entrySet()) {
			String key = en.getKey();
			Integer value = en.getValue();
			System.out.println(key + "=" + value);
		}
	}

}
