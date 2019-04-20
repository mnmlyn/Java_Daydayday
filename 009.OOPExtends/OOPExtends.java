/*
 * �������֮�̳�
 * 1. Javaû�ж�̳У�ֻ�е��̳У�����C++
 *
 * 2. ���ڶ����ʱ�򣬿���ֱ�Ӹ���Ա������Ĭ��ֵ
 *
 * 3. ����̳�֮�󣬸�������Ĺ��죬��̬����飬��������
 * �Ĺ�ϵ���£�
 * + ��һ��ʵ����һ���࣬���Ƚ������룬����þ�̬����飬
 *   ���м̳й�ϵ���������븸�ࣨ��δ���룩������������
 * + �����������������⹹�캯������������ʽд����super()��
 *   ֮�󱻵��á���һ�����캯���ĵ�һ������this������һ��
 *   ������Ĺ��캯������������ֻ������ʵ�ʵ��õ��Ǹ�
 *   ���캯���е�super(��ʽ����ʾ)��֮�󱻵��á�
 * + ����һ������ʱ�������ȹ��츸�࣬�ٹ�������
 *
 * 4. �����������г�����������ʱ�������Ḳ�ǣ����ǲ��þͽ�
 * ԭ����Ҫ��������ʹ�ø����е�������������super.varName
 *
 * 5. ������д
 * + ���������д����ķ������ⲿ�����Ḳ�Ǹ����ͬ��������
 *   ���ڷ����Ķ����У�������super.methodName()����ԭ�з���
 * + �����е�˽�з��������������֪��������ԣ������п���
 *   ��������ͬ���������Ȩ�޵ķ�����
 * + �Ӹ����м̳����ķ�����������дΪ���͵ķ���Ȩ�ޡ����磬
 *   ����public�ķ�����������дΪprivate��
 * + ����ľ�̬static������������дΪ��static�������������
 *   ��д����ô����ʱ��Ȼ��������塣static��������˽����
 *   ���ԣ����Ǻ���û��ʲô���塣
 *
 * 6. �������ϵ����⣬������дOverride�ͷ�������Overload��
 * �������������һ���ط���֪ʶ������ָ����һ�����п���
 * ����ͬ��������ֻҪ�����б�ͬ����дָ��������͸����У�
 * ͬ������ͬ�����б�ͷ���ֵ�ķ�����
*/
public class OOPExtends {
	public static void main(String[] args) {
		//����ʵ������һ�����࣬��֮���һ��ʵ��������ʱ��
		//�����Ѿ��������ڴ棬�򲻻��ٵ��ø���ľ�̬�����
		//Father father = new Father();
		System.out.println("--------------");
		Son son = new Son();
		son.show();
		son.say();
		Father.print();
		son.print();
		System.out.println("--------------");
		Son son1 = new Son(11, 22, "son1");
		son1.show();
		son1.say();
	}
	
	//������Ĺ������飬JVMֻ����static�ķ���main��
	//��Ȼ����ʵ��������࣬���������Ĺ������鲻�ᱻִ��
	{
		System.out.println("OOPExtends�Ĺ�������");
	}
	
	//������ľ�̬����飬�������ʱ������
	//����ʲôʱ��ᱻ�����أ�
	//�ڵ�һ�ε���һ����̬���������һ��ʵ�������һ������ʱ
	static {
		System.out.println("OOPExtends�ľ�̬�����");
	}
}

class Father {
	public int num1 = 3;
	public String tag = "man";
	
	public Father() {
		this.num1 = 0;
		this.tag = "real man";
		System.out.println("�����޲ι���");
	}
	
	public Father(int num1, String tag) {
		this.num1 = num1;
		this.tag = tag;
		System.out.println("�����вι���");
	}
	
	public void show() {
		System.out.println("Father show():num1=" + this.num1);
	}
	
	public static void print() {
		System.out.println("����print");
	}
	
	//���๹�����飬��ʵ��������ʱ���ڹ��캯��֮ǰ������
	{
		System.out.println("���๹������");
	}
	
	//���ྲ̬����飬�������ʱ������
	static {
		System.out.println("���ྲ̬�����");
	}
}

class Son extends Father {
	public int num2 = 20;
	public int num1 = 50;
	
	public Son() {
		//this(...)����д�ڹ��캯����һ�У�������super(...)
		//����дthis(...)��super(...)��
		//�൱��Ĭ��������޲ε�super()
		this(5, 99, "�޲�man");
		System.out.println("�����޲ι���");
	}
	
	public Son(int num1, int num2, String tag) {
		super(num1, tag);
		this.num2 = num2;
		System.out.println("�����вι���");
	}
	
	public void say() {
		System.out.println("Son say():����һ�����ˣ�num1="
				+ this.num1 + ",super.num1=" + super.num1);
	}
	
	//������д����ķ�����ʹ��super.show()���ø���ԭ�з���
	public void show() {
		super.show();
		System.out.println("Son show():num1=" + this.num1);
	}
	
	//���ڸ����еľ�̬��������дʱֻ��Ҳ�Ǿ�̬������
	public static void print() {
		System.out.println("����print");
	}
	
	//���๹������
	{
		System.out.println("���๹������");
	}
	
	//���ྲ̬�����
	static {
		System.out.println("���ྲ̬�����");
	}
}