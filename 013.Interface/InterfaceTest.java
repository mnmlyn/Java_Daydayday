/*
 * 接口，用interface定义，用implements实现
 * 1. 接口中的方法必须都是抽象方法
 * 2. 接口的子类可以是抽象类，也可以是实现了所有接口的具体类
 * 3. 接口中定义的变量，都是public static final的
 * 4. 接口没有构造方法，也不能不能定义构造方法
 *
 * 1. 类与类：继承关系，只能单继承
 * 2. 接口与接口：继承关系，可以多继承
 * 3. 类与接口：实现关系，可以多实现
 *
 * 多继承，多实现，发生名称冲突怎么办？
 * 没关系。因为接口的定义没有具体实现，冲突直接覆盖即可。
 *
 * 抽象类与接口的区别？
 * + 抽象类，被继承体现的是"is a"的关系，抽象类中定义的是该继承
 *   体系中的共性功能
 * + 接口，被实现体现的是"like a"的关系，接口中定义的是该继承
 *   体系的扩展功能
*/
public class InterfaceTest {
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.eat();
		//可以外部访问，是public的
		System.out.println(animal.num);
		//可以通过 类名.变量名 访问，说明是static的
		System.out.println(Animal.num);
		//报错，无法为最终变量分配值，说明是final的
		//Animal.num = 5;
	}
}

interface Animal {
	//接口中可以定义变量，但是所有变量默认都是
	//public static final修饰的
	int num = 1;
	//报错，此处不允许使用private修饰符，说明默认是public的
	//private int num1 = 2;
	
	//就算不写public和abstract，也会默认加	
	public abstract void eat();
}

//接口的子类可以是抽象类
abstract class FlyAnimal implements Animal {
	
}

class Dog implements Animal {
	public void eat() {
		System.out.println("狗吃骨头");
	}
}

interface InterfaceA {
	public abstract void printA();
}

interface InterfaceB {
	public abstract void printB();
}

//接口与接口，继承关系，可以多继承
interface InterfaceC extends InterfaceA,InterfaceB {
	
}

//类与接口，实现关系，可以多实现
class Demo implements InterfaceA,InterfaceB {
	public void printA(){}
	public void printB(){}
}