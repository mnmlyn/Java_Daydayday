/*
 * Exception�쳣
 * 
 * 1. �쳣�ļ̳���ϵ
 * Throwable�£���Error��Exception��Exception����RuntimeException
 * 
 * 2. try,catch,finally
 * �����Exception�ϣ�����Ctrl+t���Բ鿴��ļ̳���ϵ��
 * finally���ܻ�ִ�У�����try��catch�а���return��䡣
 * ���ǣ��ڵ���System.exit()����ʱ��ֱ���˳�������ִ��finally�顣
 * 
 * 3. finally��catch�е�return���ִ�е��Ⱥ�˳��
 * return��ִ�У�����ֱֵ��ȷ���Ҳ�����finally��Ӱ�졣
 * finally����ִ�У��ͷ���Դ��
 * ���return���ء�
 * 
 * 4. Throwable�ļ�����������
 * getMessage()����ȡ�쳣��Ϣ�������ַ���
 * toString()����ȡ�쳣�������쳣��Ϣ�������ַ���
 * printStackTrace����ȡ�쳣�������쳣��Ϣ���Լ��쳣�����ڳ����е�λ�ã�����void
 * 
 * 5. �׳��쳣
 * throw�쳣��throws�쳣���η�����throw����쳣����throws����쳣����
 * RuntimeException���׳������Բ�����
 * 
 * 6. ���ֱȽ���ģ�final,finally,finalize
 * final�ǹؼ��֣�finally���쳣�������飬finalize��Object�еķ���
 * 
 * 7. �Զ����쳣
 * Ŀ�������쳣�����ƣ����õ�ȷ���쳣��ԭ��
 * �Զ����쳣���Լ̳�Exception��RuntimeException
 * �����׳�RuntimeExceptionʱ���������Բ���throws���� 
 * 
 * 8. �쳣��̳�
 * ������д���෽��ʱ��
 * �������׳�һ�������쳣�����಻���׳�����û�е��쳣�������ض��쳣��ֻ���׳��䱾����������쳣��
 * ������û���׳��쳣������Ҳ�����׳��쳣��
 */
package com.mnmlyn;

public class ExceptionTest {

	public static void main(String[] args) throws Exception {
		// �쳣�Ĳ����봦��
		int[] arr = { 1, 2, 3, 4, 5 };
		int a = 5, b = 0;
		try {
			// int c = a/b;
			System.out.println(arr[0]);
			// arr = null;
			// System.out.println(arr[1]);
		} catch (ArithmeticException e) {
			System.out.println("�����쳣");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("����Խ��");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);// toString()
			e.printStackTrace();
		}
		System.out.println("�쳣����֮��Ĵ���");

		// ��һ��catch��д��
		try {
			// int c = a/b;
			System.out.println(arr[10]);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println("�����쳣������Խ��");
			// finally���ܻ�ִ�У�����try��catch�а���return��䡣
			// ���ǣ��ڵ���System.exit()����ʱ��ֱ���˳�������ִ��finally��
			// System.exit(0);
			// return;
		} catch (Exception e) {
			System.out.println("��������");
		} finally {
			System.out.println("finally");
		}

		// ʹ���׳��쳣�ķ�������������쳣����������main������throws
		test1(1);
		// test1(-1);
		test2(2);
		test3(1);
		// test3(0);
		// test3(-1);
	}

	// �������׳�������ʱ�쳣����RuntimeException֮����쳣���������ڷ�������throws����
	public static void test1(int a) throws Exception {
		if (a < 0) {
			throw new Exception("����");
		}
	}

	// RuntimeException���׳������Բ����ڷ�������throws����
	public static void test2(int a) {
		if (a < 0) {
			throw new RuntimeException("����");
		}
	}

	// �Զ����쳣��ʹ��
	public static void test3(int a) throws MyException {
		if (a < 0) {
			throw new MyException("�Զ����쳣������");
		}
		if (a == 0) {
			try {
				throw new MyException("oo");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
