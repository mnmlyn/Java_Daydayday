/*
 * Exception异常
 * 
 * 1. 异常的继承体系
 * Throwable下，有Error和Exception，Exception下有RuntimeException
 * 
 * 2. try,catch,finally
 * 光标在Exception上，按键Ctrl+t可以查看类的继承体系。
 * finally块总会执行，哪怕try和catch中包含return语句。
 * 但是，在调用System.exit()方法时，直接退出，不再执行finally块。
 * 
 * 3. finally和catch中的return语句执行的先后顺序，
 * return先执行，返回值直接确定且不会受finally块影响。
 * finally块再执行，释放资源。
 * 最后return返回。
 * 
 * 4. Throwable的几个常见方法
 * getMessage()，获取异常信息，返回字符串
 * toString()，获取异常类名和异常信息，返回字符串
 * printStackTrace，获取异常类名和异常信息，以及异常出现在程序中的位置，返回void
 * 
 * 5. 抛出异常
 * throw异常和throws异常修饰方法。throw后跟异常对象，throws后跟异常类名
 * RuntimeException的抛出，可以不处理
 * 
 * 6. 名字比较像的，final,finally,finalize
 * final是关键字，finally是异常处理语句块，finalize是Object中的方法
 * 
 * 7. 自定义异常
 * 目的是用异常的名称，更好地确定异常的原因
 * 自定义异常可以继承Exception或RuntimeException
 * 方法抛出RuntimeException时，方法可以不用throws声明 
 * 
 * 8. 异常与继承
 * 子类重写父类方法时，
 * 父类若抛出一个或多个异常，子类不能抛出父类没有的异常。对于特定异常，只能抛出其本身或其子类异常。
 * 父类若没有抛出异常，子类也不能抛出异常。
 */
package com.mnmlyn;

public class ExceptionTest {

	public static void main(String[] args) throws Exception {
		// 异常的产生与处理
		int[] arr = { 1, 2, 3, 4, 5 };
		int a = 5, b = 0;
		try {
			// int c = a/b;
			System.out.println(arr[0]);
			// arr = null;
			// System.out.println(arr[1]);
		} catch (ArithmeticException e) {
			System.out.println("算数异常");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("数组越界");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);// toString()
			e.printStackTrace();
		}
		System.out.println("异常处理之后的代码");

		// 另一种catch的写法
		try {
			// int c = a/b;
			System.out.println(arr[10]);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println("算数异常或数组越界");
			// finally块总会执行，哪怕try和catch中包含return语句。
			// 但是，在调用System.exit()方法时，直接退出，不再执行finally块
			// System.exit(0);
			// return;
		} catch (Exception e) {
			System.out.println("其他错误");
		} finally {
			System.out.println("finally");
		}

		// 使用抛出异常的方法，必须进行异常处理，可以在main函数上throws
		test1(1);
		// test1(-1);
		test2(2);
		test3(1);
		// test3(0);
		// test3(-1);
	}

	// 方法中抛出非运行时异常（除RuntimeException之外的异常），必须在方法上用throws声明
	public static void test1(int a) throws Exception {
		if (a < 0) {
			throw new Exception("负数");
		}
	}

	// RuntimeException的抛出，可以不用在方法上用throws声明
	public static void test2(int a) {
		if (a < 0) {
			throw new RuntimeException("负数");
		}
	}

	// 自定义异常的使用
	public static void test3(int a) throws MyException {
		if (a < 0) {
			throw new MyException("自定义异常发生了");
		}
		if (a == 0) {
			try {
				throw new MyException("oo");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
