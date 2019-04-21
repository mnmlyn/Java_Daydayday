/*
 * �ӿڣ���interface���壬��implementsʵ��
 * 1. �ӿ��еķ������붼�ǳ��󷽷�
 * 2. �ӿڵ���������ǳ����࣬Ҳ������ʵ�������нӿڵľ�����
 * 3. �ӿ��ж���ı���������public static final��
 * 4. �ӿ�û�й��췽����Ҳ���ܲ��ܶ��幹�췽��
 *
 * 1. �����ࣺ�̳й�ϵ��ֻ�ܵ��̳�
 * 2. �ӿ���ӿڣ��̳й�ϵ�����Զ�̳�
 * 3. ����ӿڣ�ʵ�ֹ�ϵ�����Զ�ʵ��
 *
 * ��̳У���ʵ�֣��������Ƴ�ͻ��ô�죿
 * û��ϵ����Ϊ�ӿڵĶ���û�о���ʵ�֣���ͻֱ�Ӹ��Ǽ��ɡ�
 *
 * ��������ӿڵ�����
 * + �����࣬���̳����ֵ���"is a"�Ĺ�ϵ���������ж�����Ǹü̳�
 *   ��ϵ�еĹ��Թ���
 * + �ӿڣ���ʵ�����ֵ���"like a"�Ĺ�ϵ���ӿ��ж�����Ǹü̳�
 *   ��ϵ����չ����
*/
public class InterfaceTest {
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.eat();
		//�����ⲿ���ʣ���public��
		System.out.println(animal.num);
		//����ͨ�� ����.������ ���ʣ�˵����static��
		System.out.println(Animal.num);
		//�����޷�Ϊ���ձ�������ֵ��˵����final��
		//Animal.num = 5;
	}
}

interface Animal {
	//�ӿ��п��Զ���������������б���Ĭ�϶���
	//public static final���ε�
	int num = 1;
	//�����˴�������ʹ��private���η���˵��Ĭ����public��
	//private int num1 = 2;
	
	//���㲻дpublic��abstract��Ҳ��Ĭ�ϼ�	
	public abstract void eat();
}

//�ӿڵ���������ǳ�����
abstract class FlyAnimal implements Animal {
	
}

class Dog implements Animal {
	public void eat() {
		System.out.println("���Թ�ͷ");
	}
}

interface InterfaceA {
	public abstract void printA();
}

interface InterfaceB {
	public abstract void printB();
}

//�ӿ���ӿڣ��̳й�ϵ�����Զ�̳�
interface InterfaceC extends InterfaceA,InterfaceB {
	
}

//����ӿڣ�ʵ�ֹ�ϵ�����Զ�ʵ��
class Demo implements InterfaceA,InterfaceB {
	public void printA(){}
	public void printB(){}
}