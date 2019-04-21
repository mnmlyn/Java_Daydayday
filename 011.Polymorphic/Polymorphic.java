/*
 * 多态，父类引用指向子类对象
 * 
 * 1. Father f = new Son();
 * 成员方法，父类中必须有相应方法，否则编译报错
 * 成员变量，父类子类中重名，按照引用类型访问相应类
 * 静态成员方法，按照引用类型访问相应类
 *
 * 2. 在方法参数中，传递父类引用。
 *
 * 3. 关键字instanceof，判断父类引用是否是子类对象
*/
public class Polymorphic {
	public static void main(String[] args) {
		Animal animal1 = new Dog();
		//Animal类必须有eat方法，只是可能被子类重写
		animal1.eat();
		//对于父类子类中重名的成员变量，
		//访问引用类型对应类的变量，
		//可以简单记为成员变量不会多态
		System.out.println(animal1.age);
		//调用静态方法，相当于类名.方法名，
		//调用引用类型对应类的静态方法
		animal1.method();
		Animal.method();
		feedAnimal(animal1);
	}
	
	public static void feedAnimal(Animal animal) {
		if(animal instanceof Dog) {
			animal.eat();
		}
	}
}

class Animal {
	public int age = 5;
	
	public void eat() {
		System.out.println("动物在吃");
	}
	
	public static void method() {
		System.out.println("动物method");
	}
}

class Dog extends Animal {
	public int age = 10;
	
	public void eat() {
		System.out.println("狗吃骨头");
	}
	
	public void catMouse() {
		System.out.println("狗拿耗子");
	}
	
	public static void method() {
		System.out.println("狗method");
	}
}