/*
 * �ڲ���
 * 1. �ڲ�����Է����������˽�г�Ա
 * ����ʹ�� �ⲿ����.this ���޶����ʵ�ȷ������
 * 2. �ڲ�public�࣬ʵ������ʽ
 * �ⲿ����.�ڲ����� ������ = new �ⲿ����.�ڲ�����()
 * 3. �ڲ�˽���࣬�������������ڲ�����
 * 4. ��̬�ڲ���
 * 5. ��̬�ڲ���ľ�̬����
 * 6. �ֲ��ڲ��࣬�ڷ����ж������
 * ����������ڷ����ڣ�ֻ���ڷ����б�ʵ����
 *
 * 7. �����ڲ��ࣨ�ص㣩
 * ֮ǰ��д��׿�����ʱ���õ��˺ܶ��
 * ʵ���ǣ��̳г������ʵ�ֽӿڣ�����ͬʱʵ�������󣬲����÷���
*/
public class InnerClassTest {
	public static void main(String[] args) {
		//ʵ����public���ڲ���
		Outer.InnerPublic oipub = new Outer().new InnerPublic();
		oipub.method();
		
		//��������ڲ�˽���࣬�������ⲿ����
		//Outer.InnerPrivate oipri = new Outer().new InnerPrivate();
		//oipri.method();
		
		//˽���ڲ��ֻ࣬��ͨ�����з���ȥ����
		Outer o = new Outer();
		o.method();
		
		//��̬�ڲ��࣬�ķǾ�̬������Ӧ��ʵ������̬�ڲ���
		Outer.InnerStatic oista = new Outer.InnerStatic();
		oista.method();
		
		//��̬�ڲ��࣬��̬������ֱ�ӷ���
		Outer.InnerStatic.print();
		
		//�����ڲ���
		//��ʵ���൱����������һ������������ʵ����Inter�ӿڣ�
		//���ң�ʵ����һ��������Ķ���Ȼ�������print������
		//�뿴�±߲�ʹ�������ڲ����д��
		new Inter() {
			public void print() {
				System.out.println("Inter print");
			}
		}.print();
		
		//��ʹ�������ڲ����д��
		//���ظ�һ�飬
		//�����ڲ����д����
		//�൱�ڣ�
		//������һ��ֻʹ��һ���ʵ�ֽӿڵ��࣬
		class NoName implements Inter {
			public void print() {
				System.out.println("NoName print");
			}
		}
		//ʵ����������һ��ֻʹ��һ��Ķ���
		Inter inter = new NoName();
		//�����������ķ���
		inter.print();
	}
}

//һ���ӿ�
interface Inter {
	public abstract void print();
}

class Outer {
	private int num = 5;
	public class InnerPublic {
		public int num = 10;
		public void method() {
			int num = 15;
			//�ڲ�����Է����������˽�г�Ա
			System.out.println("InnerPublic:" + num);
			System.out.println("InnerPublic:" + this.num);
			//ʹ�� �ⲿ����.this ���޶����ʵ����ĸ������еĳ�Ա
			System.out.println("InnerPublic:" + Outer.this.num);
		}
	}
	
	private class InnerPrivate {
		public void method() {
			//�ڲ�����Է����������˽�г�Ա
			System.out.println("InnerPrivate:" + num);
		}
	}
	
	public void method() {
		InnerPrivate ipri = new InnerPrivate();
		ipri.method();
	}
	
	//��̬�ڲ���
	static class InnerStatic {
		public void method() {
			//���������̬�ڲ��࣬��������������ķǾ�̬��Ա
			//System.out.println("InnerStatic:" + num);
			System.out.println("InnerStatic");
		}
		
		public static void print() {
			System.out.println("InnerStatic:static print");
		}
	}
}