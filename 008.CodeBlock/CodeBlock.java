/*
 * 1. 局部代码块：约束对象生命周期
 * 2. 构造代码块（初始化块）：类中代码块，每创建一次对象，
 *     在构造函数之前执行
 * 3. 静态代码块，在类加载时执行
 *
 * 经过这个测试，明确了：
 * 当第一次调用一个类的静态方法，或第一次实例化一个类，
 * 会使得类被加载入内存，将会调用类的静态代码块。
 * 每次实例化类的一个对象，都会先调用构造代码块（初始化块），
 * 然后调用调用类的相应构造方法。
*/
public class CodeBlock {
	public static void main(String[] args) {
		System.out.println("-----------------");
		Student stu1 = new Student();
		System.out.println("-----------------");
		Student stu2 = new Student("小赵", 18);
	}
	
	//可以看到构造代码块没有被执行，静态代码块被执行
	{
		System.out.println("CodeBlock类中的构造代码块");
	}
	
	static {
		System.out.println("CodeBlock类中的静态代码块");
	}
}

class Student {
	private String name;
	private int age;
	
	public Student() {
		System.out.println("无参构造");
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("有参构造");
	}
	
	//构造代码块（也叫初始化块），会在任意构造函数之前执行
	{
		System.out.println("构造代码块");
	}
	
	//静态代码块，在类加载时执行
	static {
		System.out.println("静态代码块");
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