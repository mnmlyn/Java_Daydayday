/*
 * �������
*/
public class OOPTest {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.name = "С��";
		stu.setAge(15);
		stu.run();
		
		//stu = null;
		//stu.eat();//���ᱨ��ָ���쳣
		//���C++��һ�㲻ͬ��C++�У�һ���������û�з��ʶ���
		//�ĳ�Ա������Ҳ���ǣ�û��ʹ��thisָ�룬�򲻻ᱨ��
		//Java����Ȼ��������
		
		initStudent(new Student());//��������
		
		Student stu2 = new Student("С��", 19);
		stu2.run();
	}
	
	//������Ϊ�����Ĳ���
	public static void initStudent(Student stu) {
		stu.name = "������Ʒ";
		stu.setAge(18);
		stu.run();
		stu.eat();
	}
}

class Student {
	String name;//ȱʡΪpublic
	private int age;
	
	//���캯������δ���������Զ�����޲ι���
	//����ȱʡpublic
	//������Ϊprivate�����޷�ʹ����������б�Ĺ��캯��
	Student() {
		System.out.println("�޲ι���");
		age = 18;
		name = "�޲ι����ѧ��";
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("�вι���");
	}
	
	public void setAge(int age) {
		this.age = age;//this���õ�ǰ����
	}
	
	public int getAge() {
		return age;//���Ʋ���ֲ�������ͻ�����Բ���this
	}
	
	public void run() {
		System.out.println(name + "������" + age + "�꣬����");
	}
	
	public void eat() {
		System.out.println("��");
	}
}