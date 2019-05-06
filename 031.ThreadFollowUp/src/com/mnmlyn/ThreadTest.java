/*
 * Thread���߳�
 * 
 * 1. ����߳�ͬʱ����һ����������Ҫ���м���
 * �����������̶߳�һ����ִ��--��ֱ��0ֹͣ�������������
 * ע�⣬������Ϊ�ˣ����ж��Ƿ�break�ͺ�������֮�䣬num��ֵδ���ı�
 * 
 * 2. ����
 * �������⣬��дһ�������������̰߳����෴˳���ȡ���������ͻ�����������
 * 
 * 3. Timer��TimerTask��ִ�ж�ʱ�����ڣ�����
 * TimerTask���г��󷽷�run()����дrun������
 * Timer��schedule()�������Զ�ʱ���ڵص���TimerTask�����run������Ĭ�ϼ������󣬼�ִֻ��һ�Σ���
 * 
 * 4. �߳�ͬ��֮wait,notify
 * �������⣬�����߳̽���ִ��
 * �������⣬�����߳̽���ִ�С�ʹ��notifyAll������ReentrantLock��Condition��
 * 
 * 5. �߳���ThreadGroup
 * Ĭ�ϴ������߳���ͬһ���߳���main��
 * ���Դ����µ��߳��飬�����µ��߳�ͨ��Thread���죬����ָ�����߳���
 * 
 * 6. �̵߳�����״̬
 * �½����մ������̶߳��󣬵���start�������
 * ���������Ա�ִ�е��̣߳��ȴ����Ȼ�ȡ��cpu��������
 * ���У�ʱ��Ƭ������������sleep��wait�Ƚ����������������н�������
 * ���������������ѽ������
 * �������̶߳����Ϊ����
 * 
 * 7. �̳߳أ������ύCallable������ͨ��Future�첽��ȡ�߳�ִ�н��
 * �����C++��ߵĶ��̺߳����ƣ��ǳ���Ϥ��future��
 * ͨ��Executors�����̳߳�
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
		// �̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + ",��������");
			}
		});
		// �ύCallable�����񣬷���Future����ͨ��Future��������첽��ȡ�̷߳���ֵ
		Future<Integer> f1 = pool.submit(new Callable<Integer>() {
			@Override
			public Integer call() {
				System.out.println(Thread.currentThread().getName() + ",���ڼ�����");
				return 100;
			}
		});

		System.out.println("�̵߳ļ�����Ϊ:" + f1.get());
	}

	private static void Test9() {
		// �߳���ThreadGroup�������µ��߳��飬�������̲߳�����ָ���߳���
		ThreadGroup tg = new ThreadGroup("myThreadGroup");
		Runnable mr = new Runnable() {
			@Override
			public void run() {
			}
		};
		Thread t1 = new Thread(tg, mr, "�߳�1");
		Thread t2 = new Thread(tg, mr, "�߳�2");
		Thread t3 = new Thread(mr, "�߳�3");
		Thread t4 = new Thread(Thread.currentThread().getThreadGroup(), mr, "�߳�4");

		System.out.println(t1.getName() + ":" + t1.getThreadGroup().getName());
		System.out.println(t2.getName() + ":" + t2.getThreadGroup().getName());
		System.out.println(t3.getName() + ":" + t3.getThreadGroup().getName());
		System.out.println(t4.getName() + ":" + t4.getThreadGroup().getName());
	}

	private static void Test8() {
		// �����߳̽���ִ�У�ʹ��ReentrantLock��Condition
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
		// �߳�ͬ�����⣬�����߳̽���ִ��
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
		// ��ʱ����ִ������
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println(new Date() + " ��ʱ����ִ��һ��");
			}
		}, 3000, 3000);
		System.out.println("�����𣿲���");
	}

	private static void Test5() {
		// д���������Ĵ���
		new Thread() {
			@Override
			public void run() {
				while (true) {
					synchronized (s1) {// �������߳��������Ϊ������������Ϊstatic
						System.out.println(this.getName() + ",��ȡ" + s1 + "�����ȡ" + s2);
						synchronized (s2) {
							System.out.println(this.getName() + ",��ȡ" + s2 + "���");
						}
					}
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				while (true) {
					synchronized (s2) {// �������߳��������Ϊ������������Ϊstatic
						System.out.println(this.getName() + ",��ȡ" + s2 + "�����ȡ" + s1);
						synchronized (s1) {
							System.out.println(this.getName() + ",��ȡ" + s1 + "���");
						}
					}
				}
			}
		}.start();
	}

	private static void Test4() {
		// ʵ��Runnable�ӿڣ�ʵ�ֶ��̵߳�--��������Runnableʵ�ֵ�thisָ������������ΪRunnable����ֻʵ����һ��
		MyRunnable mr = new MyRunnable();
		new Thread(mr).start();
		new Thread(mr).start();
		new Thread(mr).start();
		new Thread(mr).start();
	}

	private static void Test3() {
		// ���߳�--������
		new MyThread3().start();
		new MyThread3().start();
		new MyThread3().start();
		new MyThread3().start();
	}

	private static void Test2() {
		// ���߳�--���������������С�Ϊʲô��
		// Ҫ�������ԭ������Ϊ--���������ж��Ƿ�break��֮�䣬��Ӧ�øı�num��ֵ��
		// ���ԣ�Ҫ���жϺͲ����������ϼ�����
		new MyThread2().start();
		new MyThread2().start();
		new MyThread2().start();
		new MyThread2().start();
	}

	private static void Test1() {
		// ���߳�--��������
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
			synchronized (this) {// ���������this����ΪRunnable����ֻʵ����һ�����󣬴�������߳�
				if (num == 0)
					break;
				// ˯��һ��ʱ�䣬ʹ�����Ⱪ¶����
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "...�������" + num--);
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
				// ˯��һ��ʱ�䣬ʹ�����Ⱪ¶����
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.getName() + "...�������" + num--);
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
			// ˯��һ��ʱ�䣬ʹ�����Ⱪ¶����
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (MyThread2.class) {
				System.out.println(this.getName() + "...�������" + num--);
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
			// ˯��һ��ʱ�䣬ʹ�����Ⱪ¶����
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName() + "...�������" + num--);
		}
	}
}
