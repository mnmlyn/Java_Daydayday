/*
 * 内部类
 * 1. 内部类可以访问所在类的私有成员
 * 可以使用 外部类名.this 来限定访问的确定对象
 * 2. 内部public类，实例化方式
 * 外部类名.内部类名 对象名 = new 外部对象.内部对象()
 * 3. 内部私有类，可以在所在类内部访问
 * 4. 静态内部类
 * 5. 静态内部类的静态方法
 * 6. 局部内部类，在方法中定义的类
 * 作用域仅限于方法内，只能在方法中被实例化
 *
 * 7. 匿名内部类（重点）
 * 之前在写安卓程序的时候，用到了很多次
 * 实际是，继承抽象类或实现接口，并且同时实例化对象，并调用方法
*/
public class InnerClassTest {
	public static void main(String[] args) {
		//实例化public的内部类
		Outer.InnerPublic oipub = new Outer().new InnerPublic();
		oipub.method();
		
		//编译出错，内部私有类，不能在外部访问
		//Outer.InnerPrivate oipri = new Outer().new InnerPrivate();
		//oipri.method();
		
		//私有内部类，只能通过公有方法去访问
		Outer o = new Outer();
		o.method();
		
		//静态内部类，的非静态方法，应先实例化静态内部类
		Outer.InnerStatic oista = new Outer.InnerStatic();
		oista.method();
		
		//静态内部类，静态方法，直接访问
		Outer.InnerStatic.print();
		
		//匿名内部类
		//其实，相当于先声明了一个（匿名）类实现了Inter接口，
		//并且，实例化一个匿名类的对象，然后调用其print方法。
		//请看下边不使用匿名内部类的写法
		new Inter() {
			public void print() {
				System.out.println("Inter print");
			}
		}.print();
		
		//不使用匿名内部类的写法
		//再重复一遍，
		//匿名内部类的写法，
		//相当于，
		//声明了一个只使用一遍的实现接口的类，
		class NoName implements Inter {
			public void print() {
				System.out.println("NoName print");
			}
		}
		//实例化这个类的一个只使用一遍的对象，
		Inter inter = new NoName();
		//调用这个对象的方法
		inter.print();
	}
}

//一个接口
interface Inter {
	public abstract void print();
}

class Outer {
	private int num = 5;
	public class InnerPublic {
		public int num = 10;
		public void method() {
			int num = 15;
			//内部类可以访问所在类的私有成员
			System.out.println("InnerPublic:" + num);
			System.out.println("InnerPublic:" + this.num);
			//使用 外部类名.this 来限定访问的是哪个对象中的成员
			System.out.println("InnerPublic:" + Outer.this.num);
		}
	}
	
	private class InnerPrivate {
		public void method() {
			//内部类可以访问所在类的私有成员
			System.out.println("InnerPrivate:" + num);
		}
	}
	
	public void method() {
		InnerPrivate ipri = new InnerPrivate();
		ipri.method();
	}
	
	//静态内部类
	static class InnerStatic {
		public void method() {
			//编译出错，静态内部类，不能引用所在类的非静态成员
			//System.out.println("InnerStatic:" + num);
			System.out.println("InnerStatic");
		}
		
		public static void print() {
			System.out.println("InnerStatic:static print");
		}
	}
}