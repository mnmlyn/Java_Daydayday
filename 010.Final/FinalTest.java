/*
 * Java�е�final�ؼ���
 * C++11��Ҳ������final�ؼ��֣����εĳ�Ա�������ܱ���д
 * C++11�У���const���α�������ʾ�������ܱ��޸�
 * 
 * 1. final���η������������ܱ���д
 * 2. final�����࣬�಻�ܱ��̳�
 * 3. final���α���������Ϊ����
 *
 * 1. final���εĳ�Ա�����ĳ�ʼ��������������ʱ��ʽ��ʼ��
 * ��û����ʽ��ʼ�����������๹�췽���г�ʼ����
 * ���Ѿ���ʽ��ʼ�����򲻿����ڹ��췽�����ٴθ�ֵ��
 * 2. ��final������ͬʱΪstatic����ֻ����ʽ��ʼ��
*/
public class FinalTest {
	public static void main(String[] args) {
		//�±���䱨����������ʱδ����ֵ��Ҳ���ܸ�ֵ
		//Father.MAX=500;
		
		final int NUM = 10;
		//final���ξֲ�������Ҳ�ǲ����޸�
		//NUM = 20;
	}
}

class Father {
	//��final���α���������Ϊ������ֻ��������ʱ��ֵ
	public static final int MAX = 500;
	//û��static���ε�final�����������ڹ���ʱ��ʼ��
	//����ֻ����ʽ��ʼ��
	final int COUNT;
	
	Father() {
		COUNT = 20;
	}
	
	//δ��final���εķ��������Ա�������д
	public void print() {
		System.out.println("����print");
		//�±���䱨��
		//MAX = 10;
	}
	
	//��final���εķ��������ܱ�������д
	public final void loveSon() {
		System.out.println("�ᰮ����");
	}
}

//��final�����࣬�಻�ܱ��̳�
final class Son extends Father {
	public void print() {
		System.out.println("����print");
	}
	
	//�±���䱨��
	//public final void loveSon() {}
}

//�±���䱨��
//class SonSon extends Son {}