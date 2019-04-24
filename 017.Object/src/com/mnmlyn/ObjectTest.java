/*
 * Object类中的一些方法，继续快捷键
 * 
 * 1. 快捷键练习
 * ctrl+shift+t，打开Open Type窗口，可以搜索库函数。
 * 比如搜索Object，跳转到Object.class文件
 * ctrl+o在文件中搜索类、方法等
 * 按键Alt+左方向，后退到上一个浏览位置，当然Alt+右箭头是前进
 * ctrl+q回到最后的编辑位置
 * ctrl+左右箭头，可以按照单词为单位，进行光标左右移动
 * 
 * 2. hashCode()方法
 * 返回Object的哈希值
 * 
 * 3. getClass()方法，获取对象对应的运行时类
 * 对返回的Class，调用getName()可以获取类名
 * 
 * 4. toString()方法
 * 默认的Object的toString()方法是，返回 类名@hashCode
 * 直接打印一个对象，默认调用的就是对象的toString()方法。
 * 子类重写这个方法，可以定制打印内容。
 * Alt+Shift+s，可以快速重写类的toString()方法
 * 
 * 5. equals()方法
 * ==比较运算符只能比较两个基本类型是否相等，两个引用类型的地址是否相同
 * 重写equals方法，可以定制类的相等比较规则，可以根据对象属性判别其是否相等
 */
package com.mnmlyn;

public class ObjectTest {
	public static void main(String[] args) {
		Human human = new Student("小赵",18);
		int hash = human.hashCode();
		System.out.println(hash);
		
		System.out.println(human.getClass().getName());

		System.out.println(human.toString());
		
		Human human1 = new Student("小赵",18);
		System.out.println(human.equals(human1));
	}
}
