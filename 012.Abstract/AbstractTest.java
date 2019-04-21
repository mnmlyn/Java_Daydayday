/*
 * 抽象类&抽象方法
 * 1. 抽象类不一定有抽象方法，有抽象方法的类一定是抽象类或接口
 * 2. 抽象类不能实例化
 * 3. 抽象类的子类，要么是抽象类，要么重写（实现）所有抽象方法
 *
 * abstract关键字：
 * + 不能和static共存，
 *   static修饰的方法可以用类名.方法名调用，
 *   但是抽象方法还未实现
 * + 不能和final共存
 *   final修饰的方法，不允许子类重写，和abstract矛盾
 * + 不能和private共存
 *   private修饰的方法，不能被子类访问，和abstract矛盾
*/
public class AbstractTest {
	public static void main(String[] args) {
		//编译报错
		//Animal是抽象的; 无法实例化
		//Animal animal = new Animal();
		
		//子类继承抽象类，并实现其所有抽象方法，子类可以实例化
		Animal animal = new Dog();
		animal.eat();
	}
}

abstract class Animal {
	public abstract void eat();
}


//编译报错
//Animal1不是抽象的, 并且未覆盖Animal1中的抽象方法eat()
//因为，有抽象方法的类，必须是抽象类，或者是接口
/*
class Animal1 {
	public abstract void eat();
}
*/

//正常编译
//抽象类不一定要有抽象方法
abstract class Animal2 {
	//编译报错
	//缺少方法主体, 或声明抽象
	//这个错误很显然，非抽象方法，必须有方法体
	//public void eat();
	
	public void eat(){/*do nothing*/}
}

class Dog extends Animal {
	//编译报错
	//抽象方法不能有主体
	//所以，在实现抽象类的抽象方法时，不要再加abstract修饰符
	/*
	public abstract void eat() {
		System.out.println("狗在吃");
	}
	*/
	
	public void eat() {
		System.out.println("狗在吃");
	}
}