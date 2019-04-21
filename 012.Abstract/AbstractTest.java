/*
 * ������&���󷽷�
 * 1. �����಻һ���г��󷽷����г��󷽷�����һ���ǳ������ӿ�
 * 2. �����಻��ʵ����
 * 3. ����������࣬Ҫô�ǳ����࣬Ҫô��д��ʵ�֣����г��󷽷�
 *
 * abstract�ؼ��֣�
 * + ���ܺ�static���棬
 *   static���εķ�������������.���������ã�
 *   ���ǳ��󷽷���δʵ��
 * + ���ܺ�final����
 *   final���εķ�����������������д����abstractì��
 * + ���ܺ�private����
 *   private���εķ��������ܱ�������ʣ���abstractì��
*/
public class AbstractTest {
	public static void main(String[] args) {
		//���뱨��
		//Animal�ǳ����; �޷�ʵ����
		//Animal animal = new Animal();
		
		//����̳г����࣬��ʵ�������г��󷽷����������ʵ����
		Animal animal = new Dog();
		animal.eat();
	}
}

abstract class Animal {
	public abstract void eat();
}


//���뱨��
//Animal1���ǳ����, ����δ����Animal1�еĳ��󷽷�eat()
//��Ϊ���г��󷽷����࣬�����ǳ����࣬�����ǽӿ�
/*
class Animal1 {
	public abstract void eat();
}
*/

//��������
//�����಻һ��Ҫ�г��󷽷�
abstract class Animal2 {
	//���뱨��
	//ȱ�ٷ�������, ����������
	//����������Ȼ���ǳ��󷽷��������з�����
	//public void eat();
	
	public void eat(){/*do nothing*/}
}

class Dog extends Animal {
	//���뱨��
	//���󷽷�����������
	//���ԣ���ʵ�ֳ�����ĳ��󷽷�ʱ����Ҫ�ټ�abstract���η�
	/*
	public abstract void eat() {
		System.out.println("���ڳ�");
	}
	*/
	
	public void eat() {
		System.out.println("���ڳ�");
	}
}