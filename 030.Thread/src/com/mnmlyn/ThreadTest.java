/*
 * 多线程
 * 
 * 1. 使用多线程的第一种方法
 * 继承Thread类，重写run()方法定义线程中要执行的代码，调用start()方法启动线程
 * 
 * 2. 使用多线程的第二种方法
 * 实现Runnable接口，将其作为Thread类构造函数的参数，构造Thread对象，调用Thread对象的start方法
 * 
 * 两种方法，Java只能单继承，若类有父类，则可以用实现Runnable接口的方法。 
 * 
 * 3. 设置线程名称，获取线程名称的方法
 * 设置，
 * Thread的构造，setName()方法
 * 获取，
 * getName()方法
 * 
 * 4. 获取当前线程的引用
 * Thread.currentThread()，static方法
 * 
 * 5. 线程休眠
 * Thread.sleep()，static方法
 * 
 * 6. 设置为守护线程
 * 线程对象调用setDaemon(true)，将自身设置为守护线程，当其他线程退出时，该线程也随之退出
 * 
 * 7. join()
 * 当前线程暂停，等待指定线程结束后，当前线程再继续
 * 
 * 8. 当前线程让出cpu
 * yeild()方法
 * 
 * 9. 设置线程优先级
 * setPrority()方法，优先级是1~10整数的范围
 * Thread.MIN_PRIORITY和Thread.MAX_PRIORITY两个常量确定范围
 * 
 * 10. 同步代码块synchronized(obj){}
 * 用任意对象obj作为同步锁对象
 * 
 * 11. 同步方法，直接在方法上加修饰符synchronized，即可变为同步方法
 * 非静态的同步方法的同步锁对象，是当前对象，即this指针
 * 静态方法的同步锁对象，是当前类的字节码，即类名.class
 * 
 */
package com.mnmlyn;

public class ThreadTest {

	public static void main(String[] args) {
		// Test1();
		// Test2();
		// Test3();
		// Test4();
		// Test5();
		// Test6();
		// Test7();
		// Test8();
		// Test9();
	}

	private static void Test9() {
		// 静态方法，使用字节码对象进行同步
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					Printer.print7();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					Printer.print8();
				}
			}
		}.start();
	}

	private static void Test8() {
		// 非静态同步方法，使用对象的this指针作为同步锁对象
		Printer p = new Printer();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print5();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print6();
				}
			}
		}.start();
	}

	private static void Test7() {
		// 两个线程中，访问临界资源标准输出的代码，用同步代码块synchronized，保证同步
		Printer p = new Printer();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print3();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print4();
				}
			}
		}.start();
	}

	private static void Test6() {
		// 不加同步代码块时的乱序演示，这是因为标准输出是临界资源，两个线程会争用
		Printer p = new Printer();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print1();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print2();
				}
			}
		}.start();
	}

	private static void Test5() {
		// 设置线程名称，获取线程名称。
		// 线程休眠
		new Thread("MyThread-1") {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.getName());
				this.setName("新建线程1");
				System.out.println(this.getName());
			}
		}.start();

		// 获取当前线程的引用
		System.out.println(Thread.currentThread().getName());
		new Thread(new Runnable() {
			@Override
			public void run() {
				// 下边这句出错，this是Runnable接口的实现的对象，并不是Thread对象。
				// System.out.println(this.getName());
				// 要获取线程，可以如下获取当前线程引用
				System.out.println(Thread.currentThread().getName());
			}
		}).start();
	}

	private static void Test4() {
		// 多线程第二种方法，使用匿名内部类实现Runnable接口并实例化对象，传给Thread对象，调用start方法
		// 当然，可以把Thread也写为匿名内部类
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					System.out.println("ttttttttttt");
				}
			}
		});
		t3.start();
		for (int i = 0; i < 1000; ++i) {
			System.out.println("mmmmmmmm");
		}
	}

	private static void Test3() {
		// 多线程第二种方法，实现Runnable接口，重写run方法，
		// 将实现的对象传给Thread类构造Thread对象，调用其start方法
		MyRunnable mr = new MyRunnable();
		Thread t2 = new Thread(mr);
		t2.start();
		for (int i = 0; i < 1000; ++i) {
			System.out.println("mmmmmmmm");
		}
	}

	private static void Test2() {
		// 多线程第一种方法，继承Thread类，改用匿名内部类
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					System.out.println("ttttttttttt");
				}
			}
		}.start();
		for (int i = 0; i < 1000; ++i) {
			System.out.println("mmmmmmmm");
		}
	}

	private static void Test1() {
		// 多线程第一种方法，继承Thread类
		MyThread t1 = new MyThread();
		t1.start();
		for (int i = 0; i < 1000; ++i) {
			System.out.println("mmmmmmmm");
		}
	}

}
