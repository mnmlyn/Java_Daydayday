/*
 * StringBuffer���̰߳�ȫ���ַ���������
 * 
 * ���̰߳�ȫ�汾ΪStringBuilder��
 * ��ʵ���о��ⶫ����������C++��ߵ�string��Java��String�����޸ģ�
 * �޸�StringҪ����StringBuffer��StringBuilder
 * 
 * 1. ���췽��
 * �ղι��죬��ʼ����ռ��СΪ16������Ϊ�գ�length()Ϊ0��capacity()Ϊ16��
 * 
 * 2. ���÷��� 
 * append()��StringBuffer�����ӣ�
 * insert()��ָ��λ�����
 * delete()ɾ���±귶Χ���ַ�
 * deleteCharAt()ɾ��ָ���±���ַ�
 * replace()�滻ָ����ΧΪ���ַ���
 * reverse()��ת�ַ���
 * substring()�õ���Χ�ڵ��ַ���������String
 * 
 * 3. String��StringBuffer����ת��
 * ���Ի��๹��
 * String -> StringBuffer������append()��
 * StringBuffer -> String������toString()������substring()
 * 
 * 4. StringBuffer�ķ��̰߳�ȫ�汾StringBuilder
 * ��������ȫ��һ�������߳�ʱʹ�ã�Ч�ʸ���
 * 
 * 5. String���������������ݣ��൱�ڴ�ֵ��
 * ��StringBuffer��StringBuilder���������������ݣ��൱�ڴ�����
 */
package com.mnmlyn;

public class StringBufferTest {

	public static void main(String[] args) {
		// ���췽��
		StringBuffer sb1 = new StringBuffer();
		System.out.println(sb1.capacity());// �ղι��죬Ĭ�ϳ�ʼ����Ϊ16
		System.out.println(sb1.length());// ����Ϊ0

		StringBuffer sb2 = new StringBuffer(10);// ָ����ʼ������С
		System.out.println(sb2.capacity());
		System.out.println(sb2.length());// ����Ϊ0

		String str1 = "hello";
		StringBuffer sb3 = new StringBuffer(str1);// ��һ���ַ�������
		System.out.println(sb3.capacity());// ���ֹ��죬���˹�����ַ�����������ӳ�ʼ����16���ܹ�5+16=21
		System.out.println(sb3.length());// ����Ϊ0

		// ĩβ׷��append()
		sb3.append(str1);
		System.out.println(sb3.toString());

		// ָ��λ�ò���insert()
		sb3.insert(1, true);// �±�Խ��ᱨ��
		System.out.println(sb3.toString());

		// ɾ��ָ��λ�õ��ַ�deleteCharAt()
		sb3.deleteCharAt(0);
		System.out.println(sb3);// ֱ�Ӵ�ӡĬ�ϵ���toString()����

		// ɾ��ָ�������ϵ��ַ������ұ�delete()
		sb3.delete(0, 4);
		System.out.println(sb3);
		sb3.delete(0, sb3.length());// ���StringBuffer
		System.out.println(sb3);

		// �滻ָ���±귶Χ���ַ�Ϊ���ַ���replace()
		sb3.append("abcdefg");
		sb3.replace(0, 2, "12");
		System.out.println(sb3);

		// ��ת�ַ���reverse()
		sb3.reverse();
		System.out.println(sb3);

		// ���ַ���substring()������String
		System.out.println(sb3.substring(5));
		System.out.println(sb3.substring(1, 3));

		// String��StringBuffer���໥ת��
		System.out.println("------String��StringBuffer-------");
		String str2 = new String(sb3);
		System.out.println(str2);
		System.out.println(sb3.substring(0));
		System.out.println(sb3.toString());

		// StringBuilder
		System.out.println("--------StringBuilder---------");
		StringBuilder sbd1 = new StringBuilder();
		sbd1.append("hello");
		sbd1.reverse();
		sbd1.replace(0, 1, "O");
		System.out.println(sbd1);

		// String,StringBuffer,StringBuilder������������
		String str3 = "hello";
		StringBuilder sbd2 = new StringBuilder();
		sbd2.append(str3);
		StringBuffer sb4 = new StringBuffer();
		sb4.append(str3);

		System.out.println("--------String func----------");
		System.out.println(str3);
		func(str3);// Ctrl+1�������ʾ���Զ���������
		System.out.println(str3);// ���Կ�����String�����������ݣ��൱�ڴ���ֵ�������е��޸ģ���Ӱ��ԭֵ

		System.out.println("--------StringBuilder func----------");
		System.out.println(sbd2);
		func(sbd2);
		System.out.println(sbd2);

		System.out.println("--------StringBuffer func----------");
		System.out.println(sb4);
		func(sb4);
		System.out.println(sb4);
	}

	private static void func(StringBuffer sb4) {
		sb4.append("changed");
	}

	private static void func(StringBuilder sbd2) {
		sbd2.append("changed");
	}

	private static void func(String str3) {
		str3 += "changed";
		str3 = str3.concat(str3);
	}
}