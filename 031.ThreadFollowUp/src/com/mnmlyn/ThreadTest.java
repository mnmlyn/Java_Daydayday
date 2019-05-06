/*
 * Thread多线程
 * 
 * 1. 多个线程同时操作一个变量，需要进行加锁
 * 不加锁，多线程对一个数执行--，直到0停止。出错。加锁解决
 * 注意，加锁是为了，在判断是否break和后续操作之间，num的值未被改变
 * 
 * 2. 死锁
 * 经典问题，请写一个死锁。两个线程按照相反顺序获取两个锁，就会引发死锁。
 * 
 * 3. Timer与TimerTask，执行定时（周期）任务
 * TimerTask中有抽象方法run()，重写run方法。
 * Timer的schedule()方法可以定时周期地调用TimerTask对象的run方法（默认间隔无穷大，即只执行一次）。
 * 
 * 4. 线程同步之wait,notify
 * 经典问题，两个线程交替执行
 * 经典问题，三个线程交替执行。使用notifyAll或者用ReentrantLock加Condition。
 * 
 * 5. 线程组ThreadGroup
 * 默认创建的线程在同一个线程组main，
 * 可以创建新的线程组，并将新的线程通过Thread构造，放入指定的线程组
 * 
 * 6. 线程的五种状态
 * 新建，刚创建的线程对象，调用start进入就绪
 * 就绪，可以被执行的线程，等待调度获取到cpu进入运行
 * 运行，时间片用完进入就绪，sleep或wait等进入阻塞。结束运行进入死亡
 * 阻塞，阻塞被唤醒进入就绪
 * 死亡，线程对象变为垃圾
 * 
 * 7. 线程池，可以提交Callable的任务，通过Future异步获取线程执行结果
 * 好像和C++里边的多线程很相似，非常熟悉的future。
 * 通过Executors创建线程池
 */
package com.mnmlyn;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
	private static String s1 = "Lock1";
	private static String s2 = "Lock2";

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Test1();
		// Test2();
		// Test3();
		// Test4();
		// Test5();
		// Test6();
		// Test7();
		// Test8();
		// Test9();
		// Test10();
	}

	private static void Test10() throws InterruptedException, ExecutionException {
		// 线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + ",正在运行");
			}
		});
		// 提交Callable的任务，返回Future对象，通过Future对象可以异步获取线程返回值
		Future<Integer> f1 = pool.submit(new Callable<Integer>() {
			@Override
			public Integer call() {
				System.out.println(Thread.currentThread().getName() + ",正在计算结果");
				return 100;
			}
		});

		System.out.println("线程的计算结果为:" + f1.get());
	}

	private static void Test9() {
		// 线程组ThreadGroup，创建新的线程组，将构造线程并放入指定线程组
		ThreadGroup tg = new ThreadGroup("myThreadGroup");
		Runnable mr = new Runnable() {
			@Override
			public void run() {
			}
		};
		Thread t1 = new Thread(tg, mr, "线程1");
		Thread t2 = new Thread(tg, mr, "线程2");
		Thread t3 = new Thread(mr, "线程3");
		Thread t4 = new Thread(Thread.currentThread().getThreadGroup(), mr, "线程4");

		System.out.println(t1.getName() + ":" + t1.getThreadGroup().getName());
		System.out.println(t2.getName() + ":" + t2.getThreadGroup().getName());
		System.out.println(t3.getName() + ":" + t3.getThreadGroup().getName());
		System.out.println(t4.getName() + ":" + t4.getThreadGroup().getName());
	}

	private static void Test8() {
		// 三个线程交替执行，使用ReentrantLock和Condition
		Printer3 p3 = new Printer3();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					try {
						p3.print1();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					try {
						p3.print2();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					try {
						p3.print3();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	private static void Test7() {
		// 线程同步问题，两个线程交替执行
		Printer2 p = new Printer2();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					try {
						p.print1();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					try {
						p.print2();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	private static void Test6() {
		// 定时周期执行任务
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println(new Date() + " 定时任务执行一次");
			}
		}, 3000, 3000);
		System.out.println("阻塞吗？不！");
	}

	private static void Test5() {
		// 写个会死锁的代码
		new Thread() {
			@Override
			public void run() {
				while (true) {
					synchronized (s1) {// 依赖的线程外变量作为锁，必须声明为static
						System.out.println(this.getName() + ",获取" + s1 + "还需获取" + s2);
						synchronized (s2) {
							System.out.println(this.getName() + ",获取" + s2 + "完成");
						}
					}
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				while (true) {
					synchronized (s2) {// 依赖的线程外变量作为锁，必须声明为static
						System.out.println(this.getName() + ",获取" + s2 + "还需获取" + s1);
						synchronized (s1) {
							System.out.println(this.getName() + ",获取" + s1 + "完成");
						}
					}
				}
			}
		}.start();
	}

	private static void Test4() {
		// 实现Runnable接口，实现多线程的--，可以用Runnable实现的this指针做锁对象。因为Runnable可以只实例化一个
		MyRunnable mr = new MyRunnable();
		new Thread(mr).start();
		new Thread(mr).start();
		new Thread(mr).start();
		new Thread(mr).start();
	}

	private static void Test3() {
		// 多线程--，加锁
		new MyThread3().start();
		new MyThread3().start();
		new MyThread3().start();
		new MyThread3().start();
	}

	private static void Test2() {
		// 多线程--，加锁，这样不行。为什么？
		// 要理解出错的原因。是因为--操作，和判断是否break，之间，不应该改变num的值。
		// 所以，要在判断和操作的整体上加锁。
		new MyThread2().start();
		new MyThread2().start();
		new MyThread2().start();
		new MyThread2().start();
	}

	private static void Test1() {
		// 多线程--，不加锁
		new MyThread1().start();
		new MyThread1().start();
		new MyThread1().start();
		new MyThread1().start();
	}

}

class MyRunnable implements Runnable {
	private int num = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {// 这里可以用this，因为Runnable可以只实例化一个对象，传给多个线程
				if (num == 0)
					break;
				// 睡眠一段时间，使得问题暴露更快
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "...减，结果" + num--);
			}
		}
	}
}

class MyThread3 extends Thread {
	private static int num = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (MyThread3.class) {
				if (num == 0)
					break;
				// 睡眠一段时间，使得问题暴露更快
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.getName() + "...减，结果" + num--);
			}
		}
	}
}

class MyThread2 extends Thread {
	private static int num = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (MyThread2.class) {
				if (num == 0)
					break;
			}
			// 睡眠一段时间，使得问题暴露更快
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (MyThread2.class) {
				System.out.println(this.getName() + "...减，结果" + num--);
			}
		}
	}
}

class MyThread1 extends Thread {
	private static int num = 100;

	@Override
	public void run() {
		while (true) {
			if (num == 0)
				break;
			// 睡眠一段时间，使得问题暴露更快
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName() + "...减，结果" + num--);
		}
	}
}
