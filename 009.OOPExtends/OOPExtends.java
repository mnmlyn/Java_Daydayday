/*
 * 面向对象之继承
 * 1. Java没有多继承，只有单继承，不像C++
 *
 * 2. 类在定义的时候，可以直接给成员变量赋默认值
 *
 * 3. 加入继承之后，父类子类的构造，静态代码块，构造代码块
 * 的关系如下：
 * + 第一次实例化一个类，会先将类载入，会调用静态代码块，
 *   若有继承关系，会先载入父类（若未载入），再载入子类
 * + 构造代码块总是在任意构造函数的隐含或显式写出的super()，
 *   之后被调用。若一个构造函数的第一行用了this调用另一个
 *   参数表的构造函数，则构造代码块只在最终实际调用的那个
 *   构造函数中的super(隐式或显示)，之后被调用。
 * + 构造一个子类时，总是先构造父类，再构造子类
 *
 * 4. 当父类子类中出现重名变量时，并不会覆盖，而是采用就近
 * 原则，若要在子类中使用父类中的重名变量，用super.varName
 *
 * 5. 方法重写
 * + 子类可以重写父类的方法，外部来看会覆盖父类的同名方法。
 *   但在方法的定义中，可以用super.methodName()调用原有方法
 * + 父类中的私有方法，子类根本不知道其存在性，子类中可以
 *   随意声明同名任意访问权限的方法。
 * + 从父类中继承来的方法，不能重写为更低的访问权限。比如，
 *   父类public的方法，不能重写为private。
 * + 父类的静态static方法，不能重写为非static。如果允许这种
 *   重写，那么调用时显然会产生歧义。static方法可以私有吗？
 *   可以，但是好像没有什么意义。
 *
 * 6. 极其智障的问题，方法重写Override和方法重载Overload的
 * 区别？这根本不是一个地方的知识，重载指的是一个类中可以
 * 存在同名方法，只要参数列表不同。重写指的是子类和父类中，
 * 同名且相同参数列表和返回值的方法。
*/
public class OOPExtends {
	public static void main(String[] args) {
		//若先实例化了一个父类，在之后第一次实例化子类时，
		//父类已经加载入内存，则不会再调用父类的静态代码块
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
	
	//测试类的构造代码块，JVM只调用static的方法main，
	//显然不会实例化这个类，所以这个类的构造代码块不会被执行
	{
		System.out.println("OOPExtends的构造代码块");
	}
	
	//测试类的静态代码块，在类加载时被调用
	//类在什么时候会被加载呢？
	//在第一次调用一个静态方法，或第一次实例化类的一个对象时
	static {
		System.out.println("OOPExtends的静态代码块");
	}
}

class Father {
	public int num1 = 3;
	public String tag = "man";
	
	public Father() {
		this.num1 = 0;
		this.tag = "real man";
		System.out.println("父类无参构造");
	}
	
	public Father(int num1, String tag) {
		this.num1 = num1;
		this.tag = tag;
		System.out.println("父类有参构造");
	}
	
	public void show() {
		System.out.println("Father show():num1=" + this.num1);
	}
	
	public static void print() {
		System.out.println("父类print");
	}
	
	//父类构造代码块，在实例化对象时，在构造函数之前被调用
	{
		System.out.println("父类构造代码块");
	}
	
	//父类静态代码块，在类加载时被调用
	static {
		System.out.println("父类静态代码块");
	}
}

class Son extends Father {
	public int num2 = 20;
	public int num1 = 50;
	
	public Son() {
		//this(...)必须写在构造函数第一行，或者是super(...)
		//若不写this(...)或super(...)，
		//相当于默认添加了无参的super()
		this(5, 99, "无参man");
		System.out.println("子类无参构造");
	}
	
	public Son(int num1, int num2, String tag) {
		super(num1, tag);
		this.num2 = num2;
		System.out.println("子类有参构造");
	}
	
	public void say() {
		System.out.println("Son say():我是一个男人，num1="
				+ this.num1 + ",super.num1=" + super.num1);
	}
	
	//子类重写父类的方法，使用super.show()调用父类原有方法
	public void show() {
		super.show();
		System.out.println("Son show():num1=" + this.num1);
	}
	
	//对于父类中的静态方法，重写时只能也是静态方法。
	public static void print() {
		System.out.println("子类print");
	}
	
	//子类构造代码块
	{
		System.out.println("子类构造代码块");
	}
	
	//子类静态代码块
	static {
		System.out.println("子类静态代码块");
	}
}