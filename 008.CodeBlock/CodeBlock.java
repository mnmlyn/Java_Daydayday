/*
 * 1. �ֲ�����飺Լ��������������
 * 2. �������飨��ʼ���飩�����д���飬ÿ����һ�ζ���
 *     �ڹ��캯��֮ǰִ��
 * 3. ��̬����飬�������ʱִ��
 *
 * ����������ԣ���ȷ�ˣ�
 * ����һ�ε���һ����ľ�̬���������һ��ʵ����һ���࣬
 * ��ʹ���౻�������ڴ棬���������ľ�̬����顣
 * ÿ��ʵ�������һ�����󣬶����ȵ��ù������飨��ʼ���飩��
 * Ȼ����õ��������Ӧ���췽����
*/
public class CodeBlock {
	public static void main(String[] args) {
		System.out.println("-----------------");
		Student stu1 = new Student();
		System.out.println("-----------------");
		Student stu2 = new Student("С��", 18);
	}
	
	//���Կ�����������û�б�ִ�У���̬����鱻ִ��
	{
		System.out.println("CodeBlock���еĹ�������");
	}
	
	static {
		System.out.println("CodeBlock���еľ�̬�����");
	}
}

class Student {
	private String name;
	private int age;
	
	public Student() {
		System.out.println("�޲ι���");
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("�вι���");
	}
	
	//�������飨Ҳ�г�ʼ���飩���������⹹�캯��֮ǰִ��
	{
		System.out.println("��������");
	}
	
	//��̬����飬�������ʱִ��
	static {
		System.out.println("��̬�����");
	}
	
	//get & set
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
}