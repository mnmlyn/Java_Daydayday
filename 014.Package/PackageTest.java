/*
 * package指定当前源文件的包名，语句只能在第一行出现一次
 *
 * 编译方法：javac -d . PackageTest.java
 * 运行方法：java com.mnmlyn.PackageTest
 *
 * 1. 没有package语句，代表无包名
 *
 * 2. 访问另一个包中的类
 * 编译时，先编译被使用的类javac -d . Person.java
 * 再编译当前类javac -d . PackageTest.java
 *
 * 3. 被使用的另一个包中的class，必须用public修饰，才能被访问
 * 被使用类的构造函数必须是public修饰的，才能被访问
 *
 * 4. 使用import加全类名，可以导入类。可以使用通配符。
 *
 * 5. 静态导入，导入类中的静态方法，可以不加前缀使用静态方法
 * 一个几乎毫无用处的特性，只需要知道就行
*/
package com.mnmlyn;
import com.google.Person;
//静态导入，导入类中的静态方法，最好别这样用
import static com.google.Person.print;

//import java.util.*;  //导入java.util这个包下，与*匹配的所有类
public class PackageTest {
	public static void main(String[] args) {
		System.out.println("Hello World");
		com.google.Person p = new com.google.Person();
		String name = p.getName();
		System.out.println(name);
		
		//使用import后，可以不写包名，直接使用类
		Person p1 = new Person();
		System.out.println(p1.getName());
		
		//未静态导入方法时，使用静态方法
		Person.print();
		//静态导入类中的静态方法后，可以不加前缀使用
		//但是，发生方法名冲突时，很麻烦，最好别这样用
		print();
	}
}