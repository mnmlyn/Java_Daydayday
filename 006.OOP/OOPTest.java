/*
 * 面向对象
*/
public class OOPTest {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.name = "小王";
		stu.setAge(15);
		stu.run();
		
		//stu = null;
		//stu.eat();//这句会报空指针异常
		//这和C++有一点不同，C++中，一个方法如果没有访问对象
		//的成员变量，也就是，没有使用this指针，则不会报错。
		//Java中显然不是这样
		
		initStudent(new Student());//匿名对象
	}
	
	//对象作为方法的参数
	public static void initStudent(Student stu) {
		stu.name = "批量产品";
		stu.setAge(18);
		stu.run();
		stu.eat();
	}
}

class Student {
	String name;//缺省为public
	private int age;
	
	public void setAge(int age) {
		this.age = age;//this引用当前对象
	}
	
	public int getAge() {
		return age;//名称不与局部变量冲突，可以不加this
	}
	
	public void run() {
		System.out.println(name + "，年龄" + age + "岁，在跑");
	}
	
	public void eat() {
		System.out.println("吃");
	}
}