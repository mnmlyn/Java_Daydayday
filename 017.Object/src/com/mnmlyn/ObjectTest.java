/*
 * Object���е�һЩ������������ݼ�
 * 
 * 1. ��ݼ���ϰ
 * ctrl+shift+t����Open Type���ڣ����������⺯����
 * ��������Object����ת��Object.class�ļ�
 * ctrl+o���ļ��������ࡢ������
 * ����Alt+���򣬺��˵���һ�����λ�ã���ȻAlt+�Ҽ�ͷ��ǰ��
 * ctrl+q�ص����ı༭λ��
 * ctrl+���Ҽ�ͷ�����԰��յ���Ϊ��λ�����й�������ƶ�
 * 
 * 2. hashCode()����
 * ����Object�Ĺ�ϣֵ
 * 
 * 3. getClass()��������ȡ�����Ӧ������ʱ��
 * �Է��ص�Class������getName()���Ի�ȡ����
 * 
 * 4. toString()����
 * Ĭ�ϵ�Object��toString()�����ǣ����� ����@hashCode
 * ֱ�Ӵ�ӡһ������Ĭ�ϵ��õľ��Ƕ����toString()������
 * ������д������������Զ��ƴ�ӡ���ݡ�
 * Alt+Shift+s�����Կ�����д���toString()����
 * 
 * 5. equals()����
 * ==�Ƚ������ֻ�ܱȽ��������������Ƿ���ȣ������������͵ĵ�ַ�Ƿ���ͬ
 * ��дequals���������Զ��������ȱȽϹ��򣬿��Ը��ݶ��������б����Ƿ����
 */
package com.mnmlyn;

public class ObjectTest {
	public static void main(String[] args) {
		Human human = new Student("С��",18);
		int hash = human.hashCode();
		System.out.println(hash);
		
		System.out.println(human.getClass().getName());

		System.out.println(human.toString());
		
		Human human1 = new Student("С��",18);
		System.out.println(human.equals(human1));
	}
}
