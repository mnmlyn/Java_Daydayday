/*
 * Java中的final关键字
 * C++11中也引入了final关键字，修饰的成员函数不能被重写
 * C++11中，用const修饰变量，表示变量不能被修改
 * 
 * 1. final修饰方法，方法不能被重写
 * 2. final修饰类，类不能被继承
 * 3. final修饰变量，变量为常量
 *
 * 1. final修饰的成员变量的初始化，可以在声明时显式初始化
 * 若没有显式初始化，可以在类构造方法中初始化。
 * 若已经显式初始化，则不可以在构造方法中再次赋值。
 * 2. 若final变量，同时为static，则只能显式初始化
*/
public class FinalTest {
	public static void main(String[] args) {
		//下边这句报错，哪怕声明时未赋初值，也不能赋值
		//Father.MAX=500;
		
		final int NUM = 10;
		//final修饰局部变量，也是不能修改
		//NUM = 20;
	}
}

class Father {
	//用final修饰变量，变量为常量，只能在声明时赋值
	public static final int MAX = 500;
	//没有static修饰的final变量，可以在构造时初始化
	//否则，只能显式初始化
	final int COUNT;
	
	Father() {
		COUNT = 20;
	}
	
	//未用final修饰的方法，可以被子类重写
	public void print() {
		System.out.println("父类print");
		//下边这句报错
		//MAX = 10;
	}
	
	//用final修饰的方法，不能被子类重写
	public final void loveSon() {
		System.out.println("吾爱吾子");
	}
}

//用final修饰类，类不能被继承
final class Son extends Father {
	public void print() {
		System.out.println("子类print");
	}
	
	//下边这句报错
	//public final void loveSon() {}
}

//下边这句报错
//class SonSon extends Son {}