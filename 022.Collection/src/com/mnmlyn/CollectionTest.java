/*
 * Collection集合（单列集合根接口）
 * 终于学到了集合，激动(￣▽￣)~*
 * 
 * 1. Collection是一个接口，有两个子接口List和Set
 * List存取顺序一致，可存储重复元素
 * Set存取顺序不一致，不可存储重复元素
 * 
 * 2. List中有，ArrayList，LinkedList，Vector
 * 见名知意，描述了存储结构。其中Vector是更早版本的产物，所以和其他命名不同意，也是数组存储
 * 
 * 3. Set中有，HashSet和TreeSet
 * 
 * -------------------------------------------------
 * 4. Collection类常用方法
 * add(),remove(),clear(),contains(),size(),isEmpty()
 * 增、删、清空、查、大小、判空
 * toArray()转为Object数组
 * addAll(),removeAll(),containsAll(),retainAll()
 * 并集，差集，是否包含，交集
 * 
 * 5. 集合的遍历
 * Iterator it = c.iterator();
 * it.hasNext()
 * it.next()
 * 
 * 6. List接口的方法
 * add(),remove(),set(),get()
 * 可以通过下标增删改查
 * 
 * 7. ListIterator对List进行遍历，遍历的同时进行修改
 * 用Iterator不行，会报并发修改异常ConcurrentModificationException
 * 应使用ListIterator，用迭代器进行List集合的修改
 * ListIterator可以进行反向遍历
 * 
 * 使用下标进行遍历时，可以修改集合，但是要对下标进行合适的++或--
 * 使用迭代器进行遍历时，可以用迭代器自身的修改方法修改集合。不能用集合的修改方法，否则会有并发修改异常。
 * 使用for(String str:list){}这种形式的循环时，不能用集合的修改方法，因为这种循环是基于迭代器的。
 * 
 * 8. Vector已经被ArrayList替代，Vector是线程安全的
 * 其出现早于集合体系，现在也实现了List接口。
 * 原有用法：
 * addElement(),添加元素
 * elements(),返回枚举Enumeration en
 * en.hasMoreElements(),判断是否还有元素
 * en.nextElement(),获取下一个元素
 * 
 * 9. LinkedList类
 * addFirst(),addLast()，链表头插和尾插，显然底层基于双向链表
 * getFirst(),getLast()，获取头和尾
 * removeFirst(),removeLast()，删除头和尾
 * get()，按下标找，慢
 * 
 * 10. 泛型，类型只能是引用类型，不能用基本类型
 * 不加泛型时，其实类型时默认的Object
 * 定义集合时，new后边的泛型类型可以缺省（1.7新特性）
 * 泛型中的类型，只能是引用类型，不能是基本类型
 * 
 * 11. 泛型类
 * class Tool<T>{}
 * 类名后边尖括号，指定一个类型，在实例化的时候，指定一个特定的类型
 * 
 * 12. 泛型方法
 * 若泛型类型和类的泛型相同，直接使用即可。若不同，写法如下，
 * public <T1> void func(T1 t){}
 * 静态方法，要自己声明泛型，不能使用类泛型的非静态类型。新定义类型写在修饰符合返回值类型之间
 * public static <T2> void print(T2 t){}
 * 
 * 13. 泛型接口，及其实现
 * 泛型接口示例，
 * public interface Inter<T>{}
 * 泛型接口的实现类，依然使用泛型，成为泛型类，
 * public class InterImplement1<T> implements Inter<T>{}
 * 泛型接口的实现类，具体化的泛型类，成为一个不使用泛型的一般类
 * public class InterImplement2 implements Inter<String>{}
 * 
 * 14. 泛型通配符
 * <?>，任意引用类型，Object及其所有子类
 * <? extends E>，E及其子类
 * <? super E>，E及其父类
 * 
 * 15. 数组和集合的相互转换
 * + 数组Arrays的静态方法Arrays.asList()，将数组转换为List。
 * 但转换后的List不能改变长度。
 * 只能转换引用数据类型数组，基本数据类型数组转换会将数组当做一个对象。结果并不是想要的
 * 要想将基本数据类型的数组，转为List，最好定义其封装类型的数组
 * + 集合转换为数组，toArray()方法
 * 无参的方法，返回的Object数组
 * 有参的方法，参数指定泛型。
 *     若参数数组大小 小于等于集合大小，转换后的数组大小为集合大小。
 *     否则，转换后的数组大小为参数数组大小
 */
package com.mnmlyn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class CollectionTest {

	public static void main(String[] args) {
		// Test1();
		// Test2();
		// Test3();
		// Test4();
		// Test5();
	}

	private static void Test5() {
		// 数组转换为List
		String[] strArr = { "a", "b", "c" };
		List<String> list = Arrays.asList(strArr);
		// 下边这些报错，不支持的操作
		// list.add("d");
		// list.clear();
		// list.remove(0);
		System.out.println(list);

		// 基本数据类型的数组，转换为List，并不能得到想要的结果。也即不会自动装箱
		int[] intArr = { 1, 2, 3 };
		List<int[]> list1 = Arrays.asList(intArr);
		System.out.println(list1);

		// 要使用基本数据类型的数组，转换为List，应使用其封装类
		Integer[] intArr2 = { 1, 2, 3 };
		List<Integer> list2 = Arrays.asList(intArr2);
		System.out.println(list2);

		// 集合转为数组
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("a");
		list3.add("b");
		list3.add("c");
		// 泛型参数数组的大小，小于等于集合大小
		String[] arr3 = list.toArray(new String[0]);
		for (String string : arr3) {
			System.out.println(string);
		}
		System.out.println("--------------------------------");
		// 泛型参数数组的大小，大于集合大小
		String[] arr4 = list.toArray(new String[5]);
		for (String string : arr4) {
			System.out.println(string);
		}
	}

	private static void Test4() {
		// 带泛型的集合
		ArrayList<String> al1 = new ArrayList<>();
		al1.add("a");
		al1.add("b");
		al1.add("c");
		// 获取迭代器
		Iterator<String> it1 = al1.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}

		// 泛型类
		Tool<String> tool = new Tool<String>();
		tool.setT("111");
		System.out.println(tool.getT());
		// 使用新定义泛型的成员方法
		tool.print("aaa", "111");
		// 使用新定义泛型的静态方法
		Tool.print1("xxx");

		// 实现泛型接口的泛型类，其实就是个泛型类
		InterImplement1<String> ii1 = new InterImplement1<String>();
		ii1.show("ii1 String");

		// 实现泛型接口并具体化的类，其实就是个普通的类
		InterImplement2 ii2 = new InterImplement2();
		ii2.show("ii2 String");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void Test3() {
		// LinkedList，双向链表
		// 链表，头插，尾插
		LinkedList list = new LinkedList();
		list.addFirst("a");
		list.addFirst("b");
		list.addFirst("c");
		list.addFirst("d");
		System.out.println(list);
		list.addLast('b');
		list.addLast('c');
		System.out.println(list);
		// 链表获取头，获取尾，获取指定下标（低效）
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.get(2));
		// 删除头，删除尾
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void Test2() {
		// List接口的方法
		List list = new ArrayList();
		list.add('a');
		list.add('b');
		list.add('c');
		System.out.println(list);
		list.add(1, '6');// 向指定位置添加
		System.out.println(list);
		list.remove(1);// 删除指定下标元素，删除不会自动装箱
		System.out.println(list);
		System.out.println(list.get(1));// 获取指定下标元素
		list.set(0, 'z');// 修改指定下标的元素
		System.out.println(list);

		// 遍历List，并进行修改
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			char chr = (char)it.next();
//			System.out.print(chr);
//			if(chr == 'b')
//				list.add('x');//报错ConcurrentModificationException
//		}
		ListIterator lit1 = list.listIterator();
		while (lit1.hasNext()) {
			char chr = (char) lit1.next();
			System.out.print(chr);
			if (chr == 'b')
				lit1.add('x');
		}
		System.out.println();
		System.out.println(list);

		// List反向遍历
		while (lit1.hasPrevious()) {
			System.out.print(lit1.previous());
		}
		System.out.println();

		// Vector原有用法
		Vector v = new Vector();
		v.addElement("a");
		v.addElement("b");
		v.addElement("c");
		// 获取枚举器
		Enumeration en = v.elements();
		while (en.hasMoreElements()) {
			System.out.print(en.nextElement());
		}
		System.out.println();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void Test1() {
		Collection c1 = new ArrayList();
		boolean b1 = c1.add("abc");// 添加成功返回true，对于ArrayList，总是true
		boolean b2 = c1.add(123);
		boolean b3 = c1.add(true);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(c1.toString());// 可以看到ArrayList类或其父类重写了toString()方法

		System.out.println(c1.contains("abc"));// 判断值是否在集合中
		System.out.println(c1.size());// 集合大小
		System.out.println(c1.isEmpty());// 判断是否为空
		c1.remove("abc");// 按值删除元素
		System.out.println(c1);
		// c1.clear();//清空集合
		System.out.println(c1);

		// 集合转换为Object数组
		Object[] objArr = c1.toArray();
		for (Object obj : objArr) {
			System.out.println(obj);
		}

		c1.add('a');
		c1.add('b');
		c1.add('c');
		Collection c2 = new ArrayList();
		c2.add('a');
		c2.add('b');
		c2.add('z');
		System.out.println(c2);
		// 将集合c1中的每个元素都添加到这个集合中
		c2.addAll(c1);
		System.out.println(c2);
		c2.add(c1);// 将集合c1当做一个Object，添加到这个集合中作为一个元素
		System.out.println(c2);
		c2.remove(c1);
		// 求差集，删除交集
		c2.removeAll(c1);
		System.out.println(c2);
		// 是否包含传入集合
		System.out.println(c1.containsAll(c2));
		c1.add('z');
		System.out.println(c1.containsAll(c2));
		// 求交集
		c1.retainAll(c2);// 若调用的集合c1改变，返回true，否则false
		System.out.println(c1);

		// 集合的迭代器循环
		c1.add('a');
		c1.add('b');
		c1.add('c');
		System.out.println(c1);// 使用了toString()方法，做循环应使用迭代器
		// 集合的迭代器做循环的用法
		Iterator it = c1.iterator();// 先获取迭代器
		if (it.hasNext()) {// 判断是否是最后一个
			while (true) {
				System.out.print(it.next());// 得到下一个元素
				if (!it.hasNext())
					break;
				System.out.print(", ");
			}
			System.out.println();
		}
	}
}
