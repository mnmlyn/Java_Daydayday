/*
 * Collection���ϣ����м��ϸ��ӿڣ�
 * ����ѧ���˼��ϣ�����(������)~*
 * 
 * 1. Collection��һ���ӿڣ��������ӽӿ�List��Set
 * List��ȡ˳��һ�£��ɴ洢�ظ�Ԫ��
 * Set��ȡ˳��һ�£����ɴ洢�ظ�Ԫ��
 * 
 * 2. List���У�ArrayList��LinkedList��Vector
 * ����֪�⣬�����˴洢�ṹ������Vector�Ǹ���汾�Ĳ�����Ժ�����������ͬ�⣬Ҳ������洢
 * 
 * 3. Set���У�HashSet��TreeSet
 * 
 * -------------------------------------------------
 * 4. Collection�ೣ�÷���
 * add(),remove(),clear(),contains(),size(),isEmpty()
 * ����ɾ����ա��顢��С���п�
 * toArray()תΪObject����
 * addAll(),removeAll(),containsAll(),retainAll()
 * ����������Ƿ����������
 * 
 * 5. ���ϵı���
 * Iterator it = c.iterator();
 * it.hasNext()
 * it.next()
 * 
 * 6. List�ӿڵķ���
 * add(),remove(),set(),get()
 * ����ͨ���±���ɾ�Ĳ�
 * 
 * 7. ListIterator��List���б�����������ͬʱ�����޸�
 * ��Iterator���У��ᱨ�����޸��쳣ConcurrentModificationException
 * Ӧʹ��ListIterator���õ���������List���ϵ��޸�
 * ListIterator���Խ��з������
 * 
 * ʹ���±���б���ʱ�������޸ļ��ϣ�����Ҫ���±���к��ʵ�++��--
 * ʹ�õ��������б���ʱ�������õ�����������޸ķ����޸ļ��ϡ������ü��ϵ��޸ķ�����������в����޸��쳣��
 * ʹ��for(String str:list){}������ʽ��ѭ��ʱ�������ü��ϵ��޸ķ�������Ϊ����ѭ���ǻ��ڵ������ġ�
 * 
 * 8. Vector�Ѿ���ArrayList�����Vector���̰߳�ȫ��
 * ��������ڼ�����ϵ������Ҳʵ����List�ӿڡ�
 * ԭ���÷���
 * addElement(),���Ԫ��
 * elements(),����ö��Enumeration en
 * en.hasMoreElements(),�ж��Ƿ���Ԫ��
 * en.nextElement(),��ȡ��һ��Ԫ��
 * 
 * 9. LinkedList��
 * addFirst(),addLast()������ͷ���β�壬��Ȼ�ײ����˫������
 * getFirst(),getLast()����ȡͷ��β
 * removeFirst(),removeLast()��ɾ��ͷ��β
 * get()�����±��ң���
 * 
 * 10. ���ͣ�����ֻ�����������ͣ������û�������
 * ���ӷ���ʱ����ʵ����ʱĬ�ϵ�Object
 * ���弯��ʱ��new��ߵķ������Ϳ���ȱʡ��1.7�����ԣ�
 * �����е����ͣ�ֻ�����������ͣ������ǻ�������
 * 
 * 11. ������
 * class Tool<T>{}
 * ������߼����ţ�ָ��һ�����ͣ���ʵ������ʱ��ָ��һ���ض�������
 * 
 * 12. ���ͷ���
 * ���������ͺ���ķ�����ͬ��ֱ��ʹ�ü��ɡ�����ͬ��д�����£�
 * public <T1> void func(T1 t){}
 * ��̬������Ҫ�Լ��������ͣ�����ʹ���෺�͵ķǾ�̬���͡��¶�������д�����η��Ϸ���ֵ����֮��
 * public static <T2> void print(T2 t){}
 * 
 * 13. ���ͽӿڣ�����ʵ��
 * ���ͽӿ�ʾ����
 * public interface Inter<T>{}
 * ���ͽӿڵ�ʵ���࣬��Ȼʹ�÷��ͣ���Ϊ�����࣬
 * public class InterImplement1<T> implements Inter<T>{}
 * ���ͽӿڵ�ʵ���࣬���廯�ķ����࣬��Ϊһ����ʹ�÷��͵�һ����
 * public class InterImplement2 implements Inter<String>{}
 * 
 * 14. ����ͨ���
 * <?>�������������ͣ�Object������������
 * <? extends E>��E��������
 * <? super E>��E���丸��
 * 
 * 15. ����ͼ��ϵ��໥ת��
 * + ����Arrays�ľ�̬����Arrays.asList()��������ת��ΪList��
 * ��ת�����List���ܸı䳤�ȡ�
 * ֻ��ת�����������������飬����������������ת���Ὣ���鵱��һ�����󡣽����������Ҫ��
 * Ҫ�뽫�����������͵����飬תΪList����ö������װ���͵�����
 * + ����ת��Ϊ���飬toArray()����
 * �޲εķ��������ص�Object����
 * �вεķ���������ָ�����͡�
 *     �����������С С�ڵ��ڼ��ϴ�С��ת����������СΪ���ϴ�С��
 *     ����ת����������СΪ���������С
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
		// ����ת��ΪList
		String[] strArr = { "a", "b", "c" };
		List<String> list = Arrays.asList(strArr);
		// �±���Щ������֧�ֵĲ���
		// list.add("d");
		// list.clear();
		// list.remove(0);
		System.out.println(list);

		// �����������͵����飬ת��ΪList�������ܵõ���Ҫ�Ľ����Ҳ�������Զ�װ��
		int[] intArr = { 1, 2, 3 };
		List<int[]> list1 = Arrays.asList(intArr);
		System.out.println(list1);

		// Ҫʹ�û����������͵����飬ת��ΪList��Ӧʹ�����װ��
		Integer[] intArr2 = { 1, 2, 3 };
		List<Integer> list2 = Arrays.asList(intArr2);
		System.out.println(list2);

		// ����תΪ����
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("a");
		list3.add("b");
		list3.add("c");
		// ���Ͳ�������Ĵ�С��С�ڵ��ڼ��ϴ�С
		String[] arr3 = list.toArray(new String[0]);
		for (String string : arr3) {
			System.out.println(string);
		}
		System.out.println("--------------------------------");
		// ���Ͳ�������Ĵ�С�����ڼ��ϴ�С
		String[] arr4 = list.toArray(new String[5]);
		for (String string : arr4) {
			System.out.println(string);
		}
	}

	private static void Test4() {
		// �����͵ļ���
		ArrayList<String> al1 = new ArrayList<>();
		al1.add("a");
		al1.add("b");
		al1.add("c");
		// ��ȡ������
		Iterator<String> it1 = al1.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}

		// ������
		Tool<String> tool = new Tool<String>();
		tool.setT("111");
		System.out.println(tool.getT());
		// ʹ���¶��巺�͵ĳ�Ա����
		tool.print("aaa", "111");
		// ʹ���¶��巺�͵ľ�̬����
		Tool.print1("xxx");

		// ʵ�ַ��ͽӿڵķ����࣬��ʵ���Ǹ�������
		InterImplement1<String> ii1 = new InterImplement1<String>();
		ii1.show("ii1 String");

		// ʵ�ַ��ͽӿڲ����廯���࣬��ʵ���Ǹ���ͨ����
		InterImplement2 ii2 = new InterImplement2();
		ii2.show("ii2 String");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void Test3() {
		// LinkedList��˫������
		// ����ͷ�壬β��
		LinkedList list = new LinkedList();
		list.addFirst("a");
		list.addFirst("b");
		list.addFirst("c");
		list.addFirst("d");
		System.out.println(list);
		list.addLast('b');
		list.addLast('c');
		System.out.println(list);
		// �����ȡͷ����ȡβ����ȡָ���±꣨��Ч��
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.get(2));
		// ɾ��ͷ��ɾ��β
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void Test2() {
		// List�ӿڵķ���
		List list = new ArrayList();
		list.add('a');
		list.add('b');
		list.add('c');
		System.out.println(list);
		list.add(1, '6');// ��ָ��λ�����
		System.out.println(list);
		list.remove(1);// ɾ��ָ���±�Ԫ�أ�ɾ�������Զ�װ��
		System.out.println(list);
		System.out.println(list.get(1));// ��ȡָ���±�Ԫ��
		list.set(0, 'z');// �޸�ָ���±��Ԫ��
		System.out.println(list);

		// ����List���������޸�
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			char chr = (char)it.next();
//			System.out.print(chr);
//			if(chr == 'b')
//				list.add('x');//����ConcurrentModificationException
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

		// List�������
		while (lit1.hasPrevious()) {
			System.out.print(lit1.previous());
		}
		System.out.println();

		// Vectorԭ���÷�
		Vector v = new Vector();
		v.addElement("a");
		v.addElement("b");
		v.addElement("c");
		// ��ȡö����
		Enumeration en = v.elements();
		while (en.hasMoreElements()) {
			System.out.print(en.nextElement());
		}
		System.out.println();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void Test1() {
		Collection c1 = new ArrayList();
		boolean b1 = c1.add("abc");// ��ӳɹ�����true������ArrayList������true
		boolean b2 = c1.add(123);
		boolean b3 = c1.add(true);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(c1.toString());// ���Կ���ArrayList����丸����д��toString()����

		System.out.println(c1.contains("abc"));// �ж�ֵ�Ƿ��ڼ�����
		System.out.println(c1.size());// ���ϴ�С
		System.out.println(c1.isEmpty());// �ж��Ƿ�Ϊ��
		c1.remove("abc");// ��ֵɾ��Ԫ��
		System.out.println(c1);
		// c1.clear();//��ռ���
		System.out.println(c1);

		// ����ת��ΪObject����
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
		// ������c1�е�ÿ��Ԫ�ض���ӵ����������
		c2.addAll(c1);
		System.out.println(c2);
		c2.add(c1);// ������c1����һ��Object����ӵ������������Ϊһ��Ԫ��
		System.out.println(c2);
		c2.remove(c1);
		// ����ɾ������
		c2.removeAll(c1);
		System.out.println(c2);
		// �Ƿ�������뼯��
		System.out.println(c1.containsAll(c2));
		c1.add('z');
		System.out.println(c1.containsAll(c2));
		// �󽻼�
		c1.retainAll(c2);// �����õļ���c1�ı䣬����true������false
		System.out.println(c1);

		// ���ϵĵ�����ѭ��
		c1.add('a');
		c1.add('b');
		c1.add('c');
		System.out.println(c1);// ʹ����toString()��������ѭ��Ӧʹ�õ�����
		// ���ϵĵ�������ѭ�����÷�
		Iterator it = c1.iterator();// �Ȼ�ȡ������
		if (it.hasNext()) {// �ж��Ƿ������һ��
			while (true) {
				System.out.print(it.next());// �õ���һ��Ԫ��
				if (!it.hasNext())
					break;
				System.out.print(", ");
			}
			System.out.println();
		}
	}
}
